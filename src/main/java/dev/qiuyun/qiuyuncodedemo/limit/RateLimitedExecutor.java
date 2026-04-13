package dev.qiuyun.qiuyuncodedemo.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.*;

/**
 * 限流任务执行器：按固定速率顺序执行任务，支持重试。
 * @param <T> 任务返回值类型
 */
public class RateLimitedExecutor<T> {
    private final BlockingQueue<TaskWrapper<T>> queue = new LinkedBlockingQueue<>();
    private final RateLimiter rateLimiter;
    private final int maxRetries;
    private final long initialDelayMs;    // 首次重试延迟（毫秒）
    private final double backoffMultiplier; // 退避乘数（如2.0表示每次翻倍）
    private final ExecutorService worker = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "RateLimitedExecutor-Worker");
        t.setDaemon(true);  // 设为守护线程，避免阻止JVM退出
        return t;
    });
    private volatile boolean running = true;

    /**
     * 构造限流执行器
     * @param permitsPerSecond 每秒允许执行的任务数（如1.0表示每秒1次）
     * @param maxRetries       最大重试次数（不含首次执行）
     * @param initialDelayMs   首次重试延迟毫秒数
     * @param backoffMultiplier 退避乘数（1.0表示固定延迟，>1.0表示指数退避）
     */
    public RateLimitedExecutor(double permitsPerSecond, int maxRetries,
                               long initialDelayMs, double backoffMultiplier) {
        this.rateLimiter = RateLimiter.create(permitsPerSecond);
        this.maxRetries = maxRetries;
        this.initialDelayMs = initialDelayMs;
        this.backoffMultiplier = backoffMultiplier;
        worker.submit(this::process);
    }

    /**
     * 提交一个任务，返回CompletableFuture异步获取结果
     * @param task 需要执行的任务（Callable）
     * @return 代表异步结果的CompletableFuture
     */
    public CompletableFuture<T> submit(Callable<T> task) {
        CompletableFuture<T> future = new CompletableFuture<>();
        queue.offer(new TaskWrapper<>(task, future));
        return future;
    }

    // 工作线程主循环
    private void process() {
        while (running) {
            try {
                TaskWrapper<T> wrapper = queue.take(); // 阻塞直到有任务
                executeWithRetry(wrapper);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    // 执行单个任务（带重试）
    private void executeWithRetry(TaskWrapper<T> wrapper) {
        int retries = 0;
        long delay = initialDelayMs;
        while (retries <= maxRetries) {
            // 限流：获取令牌，若不足则阻塞
            rateLimiter.acquire();

            try {
                T result = wrapper.task.call();
                wrapper.future.complete(result);
                return; // 成功，结束
            } catch (Exception e) {
                retries++;
                if (retries > maxRetries) {
                    wrapper.future.completeExceptionally(e);
                    return;
                }
                // 重试等待（退避）
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    wrapper.future.completeExceptionally(ie);
                    return;
                }
                // 更新下次重试延迟
                delay = (long) (delay * backoffMultiplier);
            }
        }
    }

    /**
     * 优雅关闭执行器：等待已提交任务执行完毕，不再接受新任务
     */
    public void shutdown() {
        running = false;
        worker.shutdown(); // 不再接受新任务
        try {
            if (!worker.awaitTermination(5, TimeUnit.SECONDS)) {
                worker.shutdownNow();
            }
        } catch (InterruptedException e) {
            worker.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 立即关闭执行器，尝试中断正在执行的任务
     */
    public void shutdownNow() {
        running = false;
        worker.shutdownNow();
    }

    // 内部任务包装类
    private static class TaskWrapper<T> {
        final Callable<T> task;
        final CompletableFuture<T> future;

        TaskWrapper(Callable<T> task, CompletableFuture<T> future) {
            this.task = task;
            this.future = future;
        }
    }
}

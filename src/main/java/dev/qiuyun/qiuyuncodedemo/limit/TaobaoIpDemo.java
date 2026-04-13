package dev.qiuyun.qiuyuncodedemo.limit;

import org.springframework.web.client.RestClient;

import java.util.concurrent.CompletableFuture;


/**
 * 🌰 实战示例：调用淘宝IP接口
 *
 * 假设淘宝IP接口地址为 `http://ip.taobao.com/outGetIpInfo?ip={ip}`，我们需要：
 *
 * - 限制每秒 1 次请求
 * - 失败重试 3 次
 * - 首次重试延迟 1 秒，指数退避乘数 2.0
 */
public class TaobaoIpDemo {
    public static void main(String[] args) throws Exception {
        // 创建限流执行器：每秒1次，重试3次，首次延迟1秒，指数退避2.0
        RateLimitedExecutor<String> executor = new RateLimitedExecutor<>(
            1.0,    // 每秒1次
            3,      // 重试3次
            1000,   // 首次延迟1秒
            2.0     // 指数退避
        );

        // 需要查询的IP列表
        String[] ips = {"8.8.8.8", "114.114.114.114", "223.5.5.5"};

        // 提交所有任务
        for (String ip : ips) {
            CompletableFuture<String> future = executor.submit(() -> queryIp(ip));

            // 异步处理结果
            future.thenAccept(result -> {
                System.out.println("IP: " + ip + ", 结果: " + result);
            }).exceptionally(ex -> {
                System.err.println("IP: " + ip + ", 查询失败: " + ex.getMessage());
                return null;
            });
        }

        // 等待所有任务完成（实际应用中不需要，这里仅演示）
        Thread.sleep(10000);

        // 优雅关闭
        executor.shutdown();
    }

    private static String queryIp(String ip) {
        String url = "https://ip.taobao.com/outGetIpInfo?accessKey=alibaba-inc&ip=" + ip;
        return RestClient.create()
                .get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }
}

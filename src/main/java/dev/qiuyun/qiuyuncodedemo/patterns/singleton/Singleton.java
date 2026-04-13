package dev.qiuyun.qiuyuncodedemo.patterns.singleton;

/**
 * 单例模式 - 双重检查锁定（Double-Checked Locking）
 * 兼顾线程安全和性能，延迟加载
 */
public class Singleton {
    // volatile 确保多线程环境下的可见性和有序性
    private static volatile Singleton instance;
    private String data;

    // 私有构造函数，防止外部实例化
    private Singleton() {
        // 防止反射攻击
        if (instance != null) {
            throw new IllegalStateException("单例实例已存在！");
        }
        this.data = "单例数据";
    }

    /**
     * 双重检查锁定的全局访问点
     * 第一次检查避免不必要的同步，第二次检查确保线程安全
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 防止反序列化创建新实例
    protected Object readResolve() {
        return getInstance();
    }

    public void businessLogic() {
        System.out.println("执行业务逻辑: " + data);
    }

    public String getData() {
        return data;
    }
}

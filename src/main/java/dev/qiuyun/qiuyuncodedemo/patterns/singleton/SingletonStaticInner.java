package dev.qiuyun.qiuyuncodedemo.patterns.singleton;

/**
 * 单例模式 - 静态内部类方式（推荐）
 * 利用类加载机制实现延迟加载，线程安全且无需同步
 */
public class SingletonStaticInner {
    private String data;

    private SingletonStaticInner() {
        this.data = "静态内部类单例";
    }

    // 静态内部类，在首次使用时才会加载
    private static class SingletonHolder {
        private static final SingletonStaticInner INSTANCE = new SingletonStaticInner();
    }

    public static SingletonStaticInner getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

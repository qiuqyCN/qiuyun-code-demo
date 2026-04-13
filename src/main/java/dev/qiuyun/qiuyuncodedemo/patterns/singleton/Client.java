package dev.qiuyun.qiuyuncodedemo.patterns.singleton;

// 使用示例
public class Client {
    public static void main(String[] args) {
        // 双重检查锁定方式
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true

        // 静态内部类方式
        SingletonStaticInner s3 = SingletonStaticInner.getInstance();

        // 枚举方式
        SingletonEnum.INSTANCE.businessLogic();
    }
}

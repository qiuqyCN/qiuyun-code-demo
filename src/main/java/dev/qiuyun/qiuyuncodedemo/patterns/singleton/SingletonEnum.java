package dev.qiuyun.qiuyuncodedemo.patterns.singleton;

/**
 * 单例模式 - 枚举方式（最简洁、最安全的实现）
 * 自动支持序列化，防止反射攻击
 */
public enum SingletonEnum {
    INSTANCE;

    private String data = "枚举单例";

    public void businessLogic() {
        System.out.println("枚举单例执行业务: " + data);
    }
}

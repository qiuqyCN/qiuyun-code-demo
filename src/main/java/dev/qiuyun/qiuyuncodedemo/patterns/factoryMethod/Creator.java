package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 创建者抽象类
public abstract class Creator {
    /**
     * 工厂方法 - 由子类实现
     */
    public abstract Product factoryMethod();

    /**
     * 业务逻辑 - 使用工厂方法创建的产品
     */
    public void operation() {
        Product product = factoryMethod();
        System.out.println("创建者：我现在正在使用 " + product.getName());
        product.use();
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 具体产品 B
public class ConcreteProductB implements Product {
    private String name = "产品 B";

    @Override
    public void use() {
        System.out.println("使用 " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}

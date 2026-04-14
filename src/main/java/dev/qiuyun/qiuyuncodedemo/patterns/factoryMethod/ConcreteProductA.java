package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 具体产品 A
public class ConcreteProductA implements Product {
    private String name = "产品 A";

    @Override
    public void use() {
        System.out.println("使用 " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}

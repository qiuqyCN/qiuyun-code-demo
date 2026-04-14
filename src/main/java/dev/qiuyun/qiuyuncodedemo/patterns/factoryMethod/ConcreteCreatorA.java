package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 具体创建者 A
public class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

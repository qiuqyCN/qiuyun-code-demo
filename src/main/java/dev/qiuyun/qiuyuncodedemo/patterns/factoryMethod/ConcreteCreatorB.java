package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 具体创建者 B
public class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

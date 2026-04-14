package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod;

// 客户端代码
public class Client {
    public static void main(String[] args) {
        System.out.println("=== 类方式实现 ===");

        Creator creatorA = new ConcreteCreatorA();
        creatorA.operation();

        Creator creatorB = new ConcreteCreatorB();
        creatorB.operation();

        System.out.println("\n=== 函数式实现 ===");

        Product productA = FunctionalFactory.createProduct(ConcreteProductA::new);
        Product productB = FunctionalFactory.createProduct(ConcreteProductB::new);

        productA.use();
        productB.use();
    }
}

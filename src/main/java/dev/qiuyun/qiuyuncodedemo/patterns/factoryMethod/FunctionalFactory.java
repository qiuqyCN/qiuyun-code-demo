package dev.qiuyun.qiuyuncodedemo.patterns.factoryMethod; /**
 * 工厂方法模式 - 使用函数式接口（Java 8+）
 * 使用 Supplier 函数式接口实现工厂
 */
import java.util.function.Supplier;

public class FunctionalFactory {
    /**
     * 使用 Supplier 作为工厂方法
     */
    public static Product createProduct(Supplier<Product> factory) {
        return factory.get();
    }

    public static void main(String[] args) {
        // 使用 Lambda 表达式作为工厂
        Product productA = createProduct(ConcreteProductA::new);
        Product productB = createProduct(ConcreteProductB::new);

        productA.use();
        productB.use();
    }
}

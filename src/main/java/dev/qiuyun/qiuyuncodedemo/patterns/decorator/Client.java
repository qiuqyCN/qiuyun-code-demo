package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

// ============================================
// 6. 客户端代码 - 展示多层装饰
// ============================================
public class Client {
    public static void main(String[] args) {
        System.out.println("=== 装饰器模式演示 ===\n");

        // 1. 基础组件
        Component textView = new TextView("Hello, Decorator!");
        System.out.println("1. 基础组件:");
        System.out.println("描述: " + textView.getDescription());
        System.out.println("内容:");
        System.out.println(textView.operation());
        System.out.println();

        // 2. 单层装饰：添加边框
        Component borderedView = new BorderDecorator(textView, 2, "blue");
        System.out.println("2. 添加边框后:");
        System.out.println("描述: " + borderedView.getDescription());
        System.out.println("内容:");
        System.out.println(borderedView.operation());
        System.out.println();

        // 3. 多层装饰：边框 + 滚动条
        Component scrolledBorderedView = new ScrollDecorator(borderedView, 50);
        System.out.println("3. 添加边框 + 滚动条后:");
        System.out.println("描述: " + scrolledBorderedView.getDescription());
        System.out.println("内容:");
        System.out.println(scrolledBorderedView.operation());
        System.out.println();

        // 4. 三层装饰：边框 + 滚动条 + 阴影
        Component fullyDecorated = new ShadowDecorator(scrolledBorderedView, "darkgray", 10);
        System.out.println("4. 添加边框 + 滚动条 + 阴影后:");
        System.out.println("描述: " + fullyDecorated.getDescription());
        System.out.println("内容:");
        System.out.println(fullyDecorated.operation());
        System.out.println();

        // 5. 不同顺序的装饰
        Component shadowFirst = new BorderDecorator(new ShadowDecorator(new TextView("Different Order")));
        System.out.println("5. 不同装饰顺序（先阴影后边框）:");
        System.out.println("描述: " + shadowFirst.getDescription());
        System.out.println("内容:");
        System.out.println(shadowFirst.operation());
        System.out.println();

        // 6. Java I/O 示例
        System.out.println("=== Java I/O 装饰器示例 ===");
        JavaIOExample.demonstrateIO();
    }
}

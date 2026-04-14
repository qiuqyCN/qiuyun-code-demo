package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

// ============================================
// 2. ConcreteComponent - 具体组件（被装饰对象）
// ============================================
public class TextView implements Component {
    private String content;

    public TextView() {
        this("Hello World");
    }

    public TextView(String content) {
        this.content = content;
    }

    @Override
    public String operation() {
        return content;
    }

    @Override
    public String getDescription() {
        return "TextView";
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.decorator;// ============================================
// 4. ConcreteDecorator - 具体装饰器
// ============================================

/**
 * 边框装饰器 - 为组件添加边框
 */
public class BorderDecorator extends Decorator {
    private int borderWidth;
    private String borderColor;

    public BorderDecorator(Component component) {
        this(component, 1, "black");
    }

    public BorderDecorator(Component component, int width, String color) {
        super(component);
        this.borderWidth = width;
        this.borderColor = color;
    }

    @Override
    public String operation() {
        String content = component.operation();
        String border = "=".repeat(content.length() + 4);
        return border + "\n| " + content + " |\n" + border;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + " + Border(" + borderWidth + "px " + borderColor + ")";
    }

    public void setBorder(int width, String color) {
        this.borderWidth = width;
        this.borderColor = color;
    }
}

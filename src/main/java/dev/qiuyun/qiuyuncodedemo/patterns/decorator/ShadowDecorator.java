package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

/**
 * 阴影装饰器 - 为组件添加阴影效果
 */
public class ShadowDecorator extends Decorator {
    private String shadowColor;
    private int shadowBlur;

    public ShadowDecorator(Component component) {
        this(component, "gray", 5);
    }

    public ShadowDecorator(Component component, String color, int blur) {
        super(component);
        this.shadowColor = color;
        this.shadowBlur = blur;
    }

    @Override
    public String operation() {
        String content = component.operation();
        String shadowEffect = "[Shadow: " + shadowColor + ", blur=" + shadowBlur + "]";
        return content + "\n" + shadowEffect;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + " + Shadow(" + shadowColor + ")";
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

/**
 * 滚动条装饰器 - 为组件添加滚动功能
 */
public class ScrollDecorator extends Decorator {
    private int scrollPosition = 0;
    private int maxScroll;

    public ScrollDecorator(Component component) {
        this(component, 100);
    }

    public ScrollDecorator(Component component, int maxScroll) {
        super(component);
        this.maxScroll = maxScroll;
    }

    @Override
    public String operation() {
        String content = component.operation();
        String scrollBar = "[Scroll: " + scrollPosition + "/" + maxScroll + "]\n";
        return scrollBar + content;
    }

    @Override
    public String getDescription() {
        return component.getDescription() + " + ScrollBar";
    }

    public void scrollTo(int position) {
        this.scrollPosition = Math.max(0, Math.min(position, maxScroll));
    }

    public void scrollDown(int amount) {
        scrollTo(scrollPosition + amount);
    }
}


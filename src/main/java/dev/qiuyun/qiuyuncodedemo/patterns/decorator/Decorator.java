package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

// ============================================
// 3. Decorator 基类 - 装饰器抽象类
// ============================================
public abstract class Decorator implements Component {
    // 被包装的组件（可以是具体组件或其他装饰器）
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    /**
     * 默认实现：直接委托给被包装组件
     * 子类可以重写此方法以添加新行为
     */
    @Override
    public String operation() {
        return component.operation();
    }

    @Override
    public String getDescription() {
        return component.getDescription();
    }
}

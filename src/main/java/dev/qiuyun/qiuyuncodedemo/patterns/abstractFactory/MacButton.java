package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// Mac 风格产品
public class MacButton implements Button {
    private Runnable callback;
    @Override
    public void render() { System.out.println("渲染 Mac 风格按钮 [圆角边框 | 渐变背景]"); }
    @Override
    public void onClick(Runnable callback) { this.callback = callback; }
}

package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// Windows 风格产品
public class WindowsButton implements Button {
    private Runnable callback;
    @Override
    public void render() { System.out.println("渲染 Windows 风格按钮 [直角边框 | 蓝色背景]"); }
    @Override
    public void onClick(Runnable callback) { this.callback = callback; }
}

package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// Linux 风格产品
public class LinuxButton implements Button {
    private Runnable callback;
    @Override
    public void render() { System.out.println("渲染 Linux 风格按钮 [扁平设计 | 橙色背景]"); }
    @Override
    public void onClick(Runnable callback) { this.callback = callback; }
}

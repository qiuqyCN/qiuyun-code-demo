package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

public class MacTextField implements TextField {
    private String text = "";
    @Override
    public void render() { System.out.println("渲染 Mac 风格文本框 [" + (text.isEmpty() ? "空" : text) + "] [无边框 | 下划线]"); }
    @Override
    public void setText(String text) { this.text = text; }
    @Override
    public String getText() { return text; }
}

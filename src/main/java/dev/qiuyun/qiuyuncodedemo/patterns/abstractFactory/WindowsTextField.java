package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

public class WindowsTextField implements TextField {
    private String text = "";
    @Override
    public void render() { System.out.println("渲染 Windows 风格文本框 [" + (text.isEmpty() ? "空" : text) + "] [带边框]"); }
    @Override
    public void setText(String text) { this.text = text; }
    @Override
    public String getText() { return text; }
}

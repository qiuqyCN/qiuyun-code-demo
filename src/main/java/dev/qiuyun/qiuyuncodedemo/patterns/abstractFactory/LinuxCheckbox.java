package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

public class LinuxCheckbox implements Checkbox {
    private boolean checked = false;
    @Override
    public void render() { System.out.println("渲染 Linux 风格复选框 [" + (checked ? "\u2714" : "\u2610") + "] [极简风格]"); }
    @Override
    public void toggle() { checked = !checked; }
    @Override
    public boolean isChecked() { return checked; }
}

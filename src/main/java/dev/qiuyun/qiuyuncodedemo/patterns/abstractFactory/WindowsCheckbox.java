package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

public class WindowsCheckbox implements Checkbox {
    private boolean checked = false;
    @Override
    public void render() { System.out.println("渲染 Windows 风格复选框 [" + (checked ? "X" : " ") + "] [方形边框]"); }
    @Override
    public void toggle() { checked = !checked; }
    @Override
    public boolean isChecked() { return checked; }
}

package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

public class MacCheckbox implements Checkbox {
    private boolean checked = false;
    @Override
    public void render() { System.out.println("渲染 Mac 风格复选框 [" + (checked ? "\u2713" : "\u25EF") + "] [圆形边框]"); }
    @Override
    public void toggle() { checked = !checked; }
    @Override
    public boolean isChecked() { return checked; }
}

package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// 具体工厂
public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() { return new WindowsButton(); }
    @Override
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
    @Override
    public TextField createTextField() { return new WindowsTextField(); }
}

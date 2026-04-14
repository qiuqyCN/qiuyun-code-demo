package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// 抽象工厂接口
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
    TextField createTextField();
}

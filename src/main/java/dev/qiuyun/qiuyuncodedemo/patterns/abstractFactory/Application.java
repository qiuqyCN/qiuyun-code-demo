package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// 客户端代码
public class Application {
    private Button button;
    private Checkbox checkbox;
    private TextField textField;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
        textField = factory.createTextField();
    }

    public void paint() {
        button.render();
        checkbox.render();
        textField.render();
    }
}

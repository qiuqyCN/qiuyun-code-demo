package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// 使用示例
public class Client {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        GUIFactory factory;
        if (osName.contains("win")) factory = new WindowsFactory();
        else if (osName.contains("mac")) factory = new MacFactory();
        else factory = new LinuxFactory();
        Application app = new Application(factory);
        app.paint();
    }
}

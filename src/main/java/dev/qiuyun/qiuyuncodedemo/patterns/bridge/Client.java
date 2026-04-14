package dev.qiuyun.qiuyuncodedemo.patterns.bridge;

/**
 * 客户端类 - 演示桥接模式的使用
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== 桥接模式演示 - 设备与遥控器 ===\n");

        // 创建设备（实现部分）
        Device tv = new TV();
        Device radio = new Radio();

        // 创建基础遥控器控制电视机
        System.out.println("--- 基础遥控器控制电视机 ---");
        RemoteControl basicRemote = new RemoteControl(tv) {};
        basicRemote.togglePower();
        basicRemote.volumeUp();
        basicRemote.volumeUp();
        basicRemote.channelUp();
        basicRemote.channelUp();
        System.out.println(basicRemote.getDeviceStatus());
        System.out.println();

        // 创建高级遥控器控制收音机
        System.out.println("--- 高级遥控器控制收音机 ---");
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);
        advancedRemote.togglePower();
        advancedRemote.volumeUp();
        advancedRemote.jumpToChannel(100);
        advancedRemote.previousChannel();
        advancedRemote.voiceControl("静音");
        System.out.println(advancedRemote.getDeviceStatus());
        System.out.println();

        // 演示同一个遥控器可以控制不同设备
        System.out.println("--- 高级遥控器切换控制电视机 ---");
        AdvancedRemoteControl tvRemote = new AdvancedRemoteControl(tv);
        tvRemote.togglePower();
        tvRemote.jumpToChannel(5);
        tvRemote.mute();
        System.out.println(tvRemote.getDeviceStatus());

        // 演示设备可以独立变化
        System.out.println("\n--- 设备独立变化演示 ---");
        System.out.println("可以独立添加新设备（如DVD播放器）或新遥控器类型");
        System.out.println("而不需要修改现有代码，符合开闭原则");
    }
}

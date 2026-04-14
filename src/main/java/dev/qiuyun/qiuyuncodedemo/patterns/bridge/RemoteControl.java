package dev.qiuyun.qiuyuncodedemo.patterns.bridge;

/**
 * 抽象类 - 遥控器
 * 定义遥控器的基本功能，委托给设备实现
 */
abstract class RemoteControl {
    /**
     * 对实现部分的引用
     */
    protected Device device;

    /**
     * 构造函数
     * @param device 被控制的设备
     */
    public RemoteControl(Device device) {
        this.device = device;
    }

    /**
     * 切换电源状态
     */
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    /**
     * 增加音量
     */
    public void volumeUp() {
        int currentVolume = device.getVolume();
        if (currentVolume < 100) {
            device.setVolume(currentVolume + 10);
        }
    }

    /**
     * 减小音量
     */
    public void volumeDown() {
        int currentVolume = device.getVolume();
        if (currentVolume > 0) {
            device.setVolume(currentVolume - 10);
        }
    }

    /**
     * 切换到下一个频道
     */
    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }

    /**
     * 切换到上一个频道
     */
    public void channelDown() {
        int current = device.getChannel();
        if (current > 1) {
            device.setChannel(current - 1);
        }
    }

    /**
     * 获取当前控制的设备名称
     */
    public String getDeviceName() {
        return device.getDeviceName();
    }

    /**
     * 获取设备状态
     */
    public String getDeviceStatus() {
        return String.format("%s - 电源: %s, 音量: %d, 频道: %d",
            device.getDeviceName(),
            device.isEnabled() ? "开" : "关",
            device.getVolume(),
            device.getChannel());
    }
}

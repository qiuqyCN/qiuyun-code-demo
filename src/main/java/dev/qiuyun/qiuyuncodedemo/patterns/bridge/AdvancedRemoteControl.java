package dev.qiuyun.qiuyuncodedemo.patterns.bridge;

/**
 * 扩展抽象 - 高级遥控器
 * 在基础遥控器功能上添加高级功能
 */
class AdvancedRemoteControl extends RemoteControl {
    private int previousChannel;

    public AdvancedRemoteControl(Device device) {
        super(device);
        this.previousChannel = device.getChannel();
    }

    /**
     * 静音功能
     */
    public void mute() {
        System.out.println("设备已静音");
        device.setVolume(0);
    }

    /**
     * 跳转到指定频道
     */
    public void jumpToChannel(int channel) {
        previousChannel = device.getChannel();
        device.setChannel(channel);
    }

    /**
     * 返回上一个频道
     */
    public void previousChannel() {
        int temp = device.getChannel();
        device.setChannel(previousChannel);
        previousChannel = temp;
    }

    /**
     * 语音控制功能
     */
    public void voiceControl(String command) {
        System.out.println("语音识别: " + command);
        if (command.contains("开机")) {
            if (!device.isEnabled()) device.enable();
        } else if (command.contains("关机")) {
            if (device.isEnabled()) device.disable();
        } else if (command.contains("静音")) {
            mute();
        }
    }
}

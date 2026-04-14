package dev.qiuyun.qiuyuncodedemo.patterns.bridge;
/**
 * 具体实现 - 收音机
 */
class Radio implements Device {
    private boolean on = false;
    private int volume = 20;
    private int channel = 88; // FM频率

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("收音机已开启");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("收音机已关闭");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent >= 0 && percent <= 100) {
            volume = percent;
            System.out.println("收音机音量设置为: " + volume);
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("收音机调频到: " + channel + " FM");
    }

    @Override
    public String getDeviceName() {
        return "收音机";
    }
}

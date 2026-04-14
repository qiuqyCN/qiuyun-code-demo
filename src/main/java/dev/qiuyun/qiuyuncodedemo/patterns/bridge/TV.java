package dev.qiuyun.qiuyuncodedemo.patterns.bridge;

/**
 * 具体实现 - 电视机
 */
class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("电视机已开启");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("电视机已关闭");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int percent) {
        if (percent >= 0 && percent <= 100) {
            volume = percent;
            System.out.println("电视机音量设置为: " + volume);
        }
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("电视机切换到频道: " + channel);
    }

    @Override
    public String getDeviceName() {
        return "电视机";
    }
}

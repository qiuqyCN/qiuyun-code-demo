package dev.qiuyun.qiuyuncodedemo.patterns.bridge;

/**
 * 实现接口 - 设备接口
 * 定义所有设备都需要支持的基本操作
 */
interface Device {
    /**
     * 判断设备是否开启
     */
    boolean isEnabled();

    /**
     * 开启设备
     */
    void enable();

    /**
     * 关闭设备
     */
    void disable();

    /**
     * 获取当前音量
     */
    int getVolume();

    /**
     * 设置音量
     * @param percent 音量百分比 0-100
     */
    void setVolume(int percent);

    /**
     * 获取当前频道
     */
    int getChannel();

    /**
     * 设置频道
     */
    void setChannel(int channel);

    /**
     * 获取设备名称
     */
    String getDeviceName();
}

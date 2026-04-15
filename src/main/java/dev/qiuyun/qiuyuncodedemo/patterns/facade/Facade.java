package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 外观类
 * 为复杂的视频播放子系统提供简化的统一接口
 */
class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    /**
     * 简化操作：播放视频
     * 封装了所有子系统的复杂调用顺序
     */
    public String operation() {
        StringBuilder results = new StringBuilder();
        results.append("Facade 开始初始化视频播放...\n");
        results.append(subsystemC.operationC()).append("\n");   // 连接服务器
        results.append(subsystemC.operationC2()).append("\n");  // 下载数据
        results.append(subsystemB.operationB()).append("\n");   // 解码视频
        results.append(subsystemA.operationA()).append("\n");   // 初始化音频
        results.append(subsystemB.operationB2()).append("\n");  // 渲染视频
        results.append(subsystemA.operationA2()).append("\n");  // 播放音频
        results.append("Facade 视频播放开始！");
        return results.toString();
    }

    /**
     * 简化操作：仅播放音频
     * 另一种封装方式，只使用部分子系统
     */
    public String operation2() {
        StringBuilder results = new StringBuilder();
        results.append("Facade 开始音频播放...\n");
        results.append(subsystemC.operationC()).append("\n");
        results.append(subsystemA.operationA()).append("\n");
        results.append(subsystemA.operationA2()).append("\n");
        results.append("Facade 音频播放开始！");
        return results.toString();
    }
}

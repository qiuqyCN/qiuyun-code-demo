package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 子系统 A
 * 负责处理音频播放相关功能
 */
class SubsystemA {
    public String operationA() {
        return "SubsystemA: 初始化音频播放器";
    }

    public String operationA2() {
        return "SubsystemA: 播放音频";
    }
}

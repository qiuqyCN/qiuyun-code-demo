package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 子系统 B
 * 负责处理视频解码相关功能
 */
class SubsystemB {
    public String operationB() {
        return "SubsystemB: 解码视频流";
    }

    public String operationB2() {
        return "SubsystemB: 渲染视频帧";
    }
}

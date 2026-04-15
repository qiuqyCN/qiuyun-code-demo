package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 子系统 C
 * 负责处理网络请求相关功能
 */
class SubsystemC {
    public String operationC() {
        return "SubsystemC: 连接媒体服务器";
    }

    public String operationC2() {
        return "SubsystemC: 下载媒体数据";
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.decorator;

// ============================================
// 1. Component 接口 - 组件通用接口
// ============================================
public interface Component {
    /**
     * 核心操作方法
     * 所有具体组件和装饰器都必须实现此方法
     */
    String operation();

    /**
     * 获取组件描述
     */
    String getDescription();
}

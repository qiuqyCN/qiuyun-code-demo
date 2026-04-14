package dev.qiuyun.qiuyuncodedemo.patterns.composite; /**
 * 组合模式 - Java 实现
 * 将对象组合成树形结构以表示"部分-整体"的层次结构
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Component 接口声明了叶子和组合的共同操作
 * 客户端通过此接口与树中的所有组件交互
 */
interface Component {
    /**
     * 执行操作，叶子和组合的实现方式不同
     */
    String operation();

    /**
     * 添加子组件（叶子节点可能不支持此操作）
     */
    void add(Component component);

    /**
     * 移除子组件（叶子节点可能不支持此操作）
     */
    void remove(Component component);

    /**
     * 获取子组件（叶子节点可能不支持此操作）
     */
    Component getChild(int index);
}

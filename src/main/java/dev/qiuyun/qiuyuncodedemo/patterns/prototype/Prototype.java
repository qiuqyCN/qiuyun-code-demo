package dev.qiuyun.qiuyuncodedemo.patterns.prototype; /**
 * 原型模式 - Java 实现
 * 包含：基本实现、Cloneable 接口实现、序列化实现
 */

import java.io.*;
import java.util.*;

// ==================== 基本原型接口 ====================

/**
 * 原型接口
 * 定义克隆方法，所有实现类都可以被复制
 */
interface Prototype {
    /**
     * 克隆方法
     * @return 克隆的新对象
     */
    Prototype clone();

    String getName();

    void display();
}

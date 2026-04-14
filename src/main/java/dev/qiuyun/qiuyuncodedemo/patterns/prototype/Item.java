package dev.qiuyun.qiuyuncodedemo.patterns.prototype;

import java.io.Serializable;

/**
 * 物品类（可序列化）
 */
class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; }
    public int getValue() { return value; }
}

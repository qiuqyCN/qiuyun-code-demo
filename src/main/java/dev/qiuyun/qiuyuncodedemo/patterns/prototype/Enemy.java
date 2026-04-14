package dev.qiuyun.qiuyuncodedemo.patterns.prototype;

import java.io.Serializable;

/**
 * 敌人类（可序列化）
 */
class Enemy implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
    private int health;

    public Enemy(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public String getType() { return type; }
    public int getHealth() { return health; }
}

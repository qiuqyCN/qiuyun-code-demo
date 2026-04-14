package dev.qiuyun.qiuyuncodedemo.patterns.prototype;

import java.io.*;
import java.util.*;

/**
 * 具体原型类 - 游戏关卡
 * 通过序列化实现深拷贝（适用于复杂对象）
 */
class GameLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int difficulty;
    private List<Enemy> enemies;
    private Map<String, Item> items;
    private transient Date loadedAt; // transient 字段不会被序列化

    public GameLevel(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.enemies = new ArrayList<>();
        this.items = new HashMap<>();
        this.loadedAt = new Date();
    }

    /**
     * 添加敌人
     */
    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    /**
     * 添加物品
     */
    public void addItem(String key, Item item) {
        this.items.put(key, item);
    }

    /**
     * 序列化深拷贝
     * 将对象写入字节流，再读取出来实现深拷贝
     */
    public GameLevel deepCloneViaSerialization() {
        try {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();

            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            GameLevel cloned = (GameLevel) ois.readObject();
            ois.close();

            // 重新设置加载时间
            cloned.loadedAt = new Date();

            return cloned;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Deep clone failed", e);
        }
    }

    public String getName() { return name; }
    public int getDifficulty() { return difficulty; }
    public List<Enemy> getEnemies() { return enemies; }

    public void display() {
        System.out.println("游戏关卡: " + name);
        System.out.println("  难度: " + difficulty);
        System.out.println("  敌人数量: " + enemies.size());
        System.out.println("  物品数量: " + items.size());
        System.out.println("  加载时间: " + loadedAt);
    }
}

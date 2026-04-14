package dev.qiuyun.qiuyuncodedemo.patterns.prototype;// ==================== Cloneable 接口实现 ====================

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 具体原型类 - 用户档案
 * 实现 Cloneable 接口，使用浅拷贝
 */
class UserProfile implements Prototype, Cloneable {
    private String id;
    private String name;
    private int age;
    private List<String> roles; // 引用类型
    private Date createdAt; // 可变对象

    public UserProfile(String id, String name, int age, List<String> roles) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roles = new ArrayList<>(roles); // 复制列表
        this.createdAt = new Date();
    }

    /**
     * 浅拷贝实现
     * 基本类型和不可变对象会被复制
     * 可变对象（List, Date）保持引用
     */
    @Override
    public UserProfile clone() {
        try {
            return (UserProfile) super.clone();
        } catch (CloneNotSupportedException e) {
            // 由于实现了 Cloneable，这里不会发生
            throw new RuntimeException("Clone failed", e);
        }
    }

    /**
     * 深拷贝实现
     * 所有引用类型都被完全复制
     */
    public UserProfile deepClone() {
        UserProfile cloned = new UserProfile(
            this.id + "_copy",
            this.name,
            this.age,
            new ArrayList<>(this.roles)
        );
        cloned.createdAt = (Date) this.createdAt.clone();
        return cloned;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void display() {
        System.out.println("用户档案:");
        System.out.println("  ID: " + id);
        System.out.println("  姓名: " + name);
        System.out.println("  年龄: " + age);
        System.out.println("  角色: " + roles);
        System.out.println("  创建时间: " + createdAt);
    }

    // Getter 和 Setter
    public String getId() { return id; }
    public void setName(String name) { this.name = name; }
    public List<String> getRoles() { return roles; }
    public void addRole(String role) { this.roles.add(role); }
}

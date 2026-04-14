package dev.qiuyun.qiuyuncodedemo.patterns.prototype;// ==================== 客户端使用示例 ====================

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrototypeDemo {
    public static void main(String[] args) {
        System.out.println("========== 原型模式演示 ==========\n");

        // 1. Cloneable 接口实现
        System.out.println("--- Cloneable 接口实现 ---");
        List<String> roles = new ArrayList<>();
        roles.add("管理员");
        roles.add("用户");

        UserProfile originalUser = new UserProfile("U001", "张三", 25, roles);
        originalUser.display();

        System.out.println("\n浅拷贝:");
        UserProfile shallowUser = originalUser.clone();
        shallowUser.setName("李四");
        shallowUser.addRole("访客");

        System.out.println("原始用户角色: " + originalUser.getRoles());
        System.out.println("克隆用户角色: " + shallowUser.getRoles());
        System.out.println("浅拷贝共享了角色列表引用！");

        System.out.println("\n深拷贝:");
        UserProfile deepUser = originalUser.deepClone();
        deepUser.setName("王五");
        deepUser.addRole("测试员");

        System.out.println("原始用户角色: " + originalUser.getRoles());
        System.out.println("深拷贝用户角色: " + deepUser.getRoles());
        System.out.println("深拷贝完全独立！");

        // 2. 序列化深拷贝
        System.out.println("\n--- 序列化深拷贝 ---");
        GameLevel originalLevel = new GameLevel("第一关", 1);
        originalLevel.addEnemy(new Enemy("哥布林", 100));
        originalLevel.addEnemy(new Enemy("狼人", 150));
        originalLevel.addItem("key", new Item("钥匙", 50));
        originalLevel.display();

        GameLevel clonedLevel = originalLevel.deepCloneViaSerialization();
        clonedLevel.display();

        // 3. 原型注册表
        System.out.println("\n--- 原型注册表 ---");
        PrototypeRegistry registry = new PrototypeRegistry();
        registry.register("admin-user", new UserProfile("A001", "管理员", 30, Arrays.asList("管理员")));
        registry.register("user-guest", new UserProfile("G001", "访客", 20, Arrays.asList("访客")));

        System.out.println("\n注册的原型: " + registry.listPrototypes());

        UserProfile userFromRegistry = (UserProfile) registry.get("admin-user");
        System.out.println("从注册表获取的用户: " + userFromRegistry.getName());
    }
}

/**
 * 克隆方法选择建议：
 * 1. 简单对象：实现 Cloneable 接口
 * 2. 复杂对象（包含多层嵌套）：使用序列化或手动深拷贝
 * 3. 需要完全控制拷贝过程：实现自定义 clone 方法
 * 4. 考虑使用拷贝构造函数或静态工厂方法作为替代方案
 */

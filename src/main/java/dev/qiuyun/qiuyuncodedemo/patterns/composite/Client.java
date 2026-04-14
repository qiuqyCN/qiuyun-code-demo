package dev.qiuyun.qiuyuncodedemo.patterns.composite;

/**
 * 客户端代码
 * 通过 Component 接口与所有组件交互，无需知道是叶子还是组合
 */
public class Client {
    public static void main(String[] args) {
        // 创建根组合
        Component root = new Composite("Root");

        // 创建分支组合
        Component branch1 = new Composite("Branch1");
        Component branch2 = new Composite("Branch2");

        // 创建叶子节点
        Component leaf1 = new Leaf("Leaf1");
        Component leaf2 = new Leaf("Leaf2");
        Component leaf3 = new Leaf("Leaf3");

        // 构建树形结构
        root.add(branch1);
        root.add(branch2);

        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);

        // 客户端统一调用，无需区分叶子和组合
        System.out.println(root.operation());
        // 输出: Composite(Root)[Composite(Branch1)[Leaf(Leaf1), Leaf(Leaf2)], Composite(Branch2)[Leaf(Leaf3)]]

        // 也可以单独操作叶子
        System.out.println(leaf1.operation()); // 输出: Leaf(Leaf1)
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.composite;

/**
 * Leaf 类表示树的叶子节点
 * 叶子节点没有子节点，通常执行实际的工作
 */
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 叶子节点的操作实现
     */
    @Override
    public String operation() {
        return "Leaf(" + name + ")";
    }

    /**
     * 叶子节点不支持添加子组件
     */
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to a leaf");
    }

    /**
     * 叶子节点不支持移除子组件
     */
    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from a leaf");
    }

    /**
     * 叶子节点没有子组件
     */
    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Leaf has no children");
    }
}

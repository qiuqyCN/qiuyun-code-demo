package dev.qiuyun.qiuyuncodedemo.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite 类表示有子节点的组合对象
 * 它存储子组件并实现与子组件相关的操作
 */
class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    private String name;

    public Composite(String name) {
        this.name = name;
    }

    /**
     * 向组合中添加子组件
     */
    @Override
    public void add(Component component) {
        children.add(component);
    }

    /**
     * 从组合中移除子组件
     */
    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    /**
     * 获取指定索引的子组件
     */
    @Override
    public Component getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    /**
     * 组合的操作实现：递归调用所有子组件的操作
     * 这是组合模式的核心，统一处理单个和组合对象
     */
    @Override
    public String operation() {
        StringBuilder result = new StringBuilder();
        result.append("Composite(").append(name).append(")[");

        // 递归调用所有子组件的 operation
        for (int i = 0; i < children.size(); i++) {
            result.append(children.get(i).operation());
            if (i < children.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }
}

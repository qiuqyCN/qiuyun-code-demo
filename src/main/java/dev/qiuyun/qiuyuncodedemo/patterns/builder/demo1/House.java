package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

import java.util.ArrayList;
import java.util.List;

// ============================================
// Product（产品）- 要创建的复杂对象
// ============================================
class House {
    private List<String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add(part);
    }

    public void listParts() {
        System.out.println("房屋组成部分: " + String.join(", ", parts));
    }

    public List<String> getParts() {
        return new ArrayList<>(parts);
    }

    public String getDescription() {
        return "房屋类型: " + parts.size() + " 个部分组成";
    }
}

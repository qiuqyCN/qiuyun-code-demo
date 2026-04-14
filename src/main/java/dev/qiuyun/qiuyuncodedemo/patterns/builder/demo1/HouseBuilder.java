package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

// ============================================
// Builder（抽象建造者）- 定义创建产品的接口
// ============================================
interface HouseBuilder {
    void reset();                     // 重置，生成新产品
    void buildBasement();             // 地基
    void buildStructure();            // 结构
    void buildRoof();                // 屋顶
    void buildInterior();             // 室内装修
    House getResult();                // 获取建造的产品
}

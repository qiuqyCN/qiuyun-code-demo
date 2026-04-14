package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

// ============================================
// Director（指挥者）- 控制建造过程
// ============================================
class ConstructionDirector {
    private HouseBuilder builder;

    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }

    /**
     * 标准建造流程
     */
    public House constructStandardHouse() {
        if (this.builder == null) {
            throw new IllegalStateException("请先设置建造者");
        }
        builder.reset();
        builder.buildBasement();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        return builder.getResult();
    }

    /**
     * 快速建造流程（无地下室）
     */
    public House constructQuickHouse() {
        if (this.builder == null) {
            throw new IllegalStateException("请先设置建造者");
        }
        builder.reset();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        return builder.getResult();
    }
}

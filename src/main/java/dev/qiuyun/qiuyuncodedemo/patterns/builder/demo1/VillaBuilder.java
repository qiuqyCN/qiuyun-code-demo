package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

/**
 * 别墅建造者
 */
class VillaBuilder implements HouseBuilder {
    private House house;

    public VillaBuilder() {
        this.house = new House();
    }

    @Override
    public void reset() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.addPart("豪华地下室");
    }

    @Override
    public void buildStructure() {
        house.addPart("钢筋混凝土框架结构");
    }

    @Override
    public void buildRoof() {
        house.addPart("琉璃瓦屋顶");
    }

    @Override
    public void buildInterior() {
        house.addPart("豪华精装修");
        house.addPart("智能家居系统");
        house.addPart("中央空调");
    }

    @Override
    public House getResult() {
        House result = this.house;
        this.reset(); // 重置以便重用
        return result;
    }
}

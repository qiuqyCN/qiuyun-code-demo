package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

/**
 * 普通住宅建造者
 */
class NormalHouseBuilder implements HouseBuilder {
    private House house;

    public NormalHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void reset() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.addPart("标准地基");
    }

    @Override
    public void buildStructure() {
        house.addPart("砖混结构");
    }

    @Override
    public void buildRoof() {
        house.addPart("普通瓦片屋顶");
    }

    @Override
    public void buildInterior() {
        house.addPart("基础装修");
    }

    @Override
    public House getResult() {
        House result = this.house;
        this.reset();
        return result;
    }
}

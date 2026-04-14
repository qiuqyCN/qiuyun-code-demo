package dev.qiuyun.qiuyuncodedemo.patterns.builder.demo1;

// ============================================
// 客户端代码
// ============================================
class BuilderDemo {
    public static void main(String[] args) {
        ConstructionDirector director = new ConstructionDirector();

        System.out.println("=== 建造别墅 ===");
        HouseBuilder villaBuilder = new VillaBuilder();
        director.setBuilder(villaBuilder);
        House villa = director.constructStandardHouse();
        villa.listParts();
        System.out.println(villa.getDescription());

        System.out.println("\n=== 建造普通住宅 ===");
        HouseBuilder normalBuilder = new NormalHouseBuilder();
        director.setBuilder(normalBuilder);
        House normalHouse = director.constructStandardHouse();
        normalHouse.listParts();
        System.out.println(normalHouse.getDescription());
    }
}

package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 客户端代码
 * 演示使用外观和不使用外观的区别
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== 不使用外观模式（直接与子系统交互）===");
        SubsystemA subsystemA = new SubsystemA();
        SubsystemB subsystemB = new SubsystemB();
        SubsystemC subsystemC = new SubsystemC();

        // 客户端需要了解所有子系统的调用顺序和细节
        System.out.println(subsystemC.operationC());
        System.out.println(subsystemC.operationC2());
        System.out.println(subsystemB.operationB());
        System.out.println(subsystemA.operationA());
        System.out.println(subsystemB.operationB2());
        System.out.println(subsystemA.operationA2());

        System.out.println("\n=== 使用外观模式 ===");
        Facade facade = new Facade();
        // 客户端只需要调用简单的接口
        System.out.println(facade.operation());

        System.out.println("\n=== 使用外观模式 - 仅音频 ===");
        System.out.println(facade.operation2());

        System.out.println("\n=== 使用额外外观 ===");
        OptionalFacade optionalFacade = new OptionalFacade();
        System.out.println(optionalFacade.videoOnlyOperation());
    }
}

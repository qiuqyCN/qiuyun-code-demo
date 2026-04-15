package dev.qiuyun.qiuyuncodedemo.patterns.facade;

/**
 * 额外外观类（可选）
 * 提供更细粒度的控制或不同的接口风格
 */
class OptionalFacade {
    private SubsystemB subsystemB;
    private SubsystemC subsystemC;

    public OptionalFacade() {
        this.subsystemB = new SubsystemB();
        this.subsystemC = new SubsystemC();
    }

    /**
     * 仅处理视频相关操作（无音频）
     */
    public String videoOnlyOperation() {
        StringBuilder results = new StringBuilder();
        results.append("OptionalFacade: 纯视频模式\n");
        results.append(subsystemC.operationC()).append("\n");
        results.append(subsystemB.operationB()).append("\n");
        results.append(subsystemB.operationB2());
        return results.toString();
    }
}

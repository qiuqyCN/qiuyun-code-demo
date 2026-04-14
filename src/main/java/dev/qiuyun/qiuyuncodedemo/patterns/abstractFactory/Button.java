package dev.qiuyun.qiuyuncodedemo.patterns.abstractFactory;

// 抽象产品接口
public interface Button {
    void render();
    void onClick(Runnable callback);
}

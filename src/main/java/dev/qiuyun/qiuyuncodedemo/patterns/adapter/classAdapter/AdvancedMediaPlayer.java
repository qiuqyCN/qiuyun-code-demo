package dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter;

// ============================================
// Adaptee 1: 高级媒体播放器接口
// ============================================
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

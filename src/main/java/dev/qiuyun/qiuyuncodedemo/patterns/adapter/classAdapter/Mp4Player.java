package dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter;

// ============================================
// Concrete Adaptee: MP4 播放器
// ============================================
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // MP4 播放器不支持 VLC
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

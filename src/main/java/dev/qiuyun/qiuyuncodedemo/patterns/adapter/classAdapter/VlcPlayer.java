package dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter;

// ============================================
// Concrete Adaptee: VLC 播放器
// ============================================
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // VLC 播放器不支持 MP4
    }
}

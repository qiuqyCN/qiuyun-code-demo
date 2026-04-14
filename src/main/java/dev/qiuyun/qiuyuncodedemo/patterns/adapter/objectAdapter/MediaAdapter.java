package dev.qiuyun.qiuyuncodedemo.patterns.adapter.objectAdapter;

import dev.qiuyun.qiuyuncodedemo.patterns.adapter.MediaPlayer;
import dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter.AdvancedMediaPlayer;
import dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter.Mp4Player;
import dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter.VlcPlayer;

// ============================================
// 对象适配器 (Object Adapter) - 推荐方式
// 使用组合方式，更灵活，可以适配多个 Adaptee
// ============================================
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    /**
     * 根据音频类型创建对应的适配器
     */
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

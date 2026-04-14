package dev.qiuyun.qiuyuncodedemo.patterns.adapter.objectAdapter;

import dev.qiuyun.qiuyuncodedemo.patterns.adapter.MediaPlayer;

// ============================================
// 客户端：音频播放器
// ============================================
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // 内置支持 MP3
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        }
        // 使用适配器支持其他格式
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

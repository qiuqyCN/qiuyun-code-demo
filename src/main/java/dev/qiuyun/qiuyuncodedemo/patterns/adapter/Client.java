package dev.qiuyun.qiuyuncodedemo.patterns.adapter;

import dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter.Mp4ClassAdapter;
import dev.qiuyun.qiuyuncodedemo.patterns.adapter.objectAdapter.AudioPlayer;

// ============================================
// 使用示例
// ============================================
public class Client {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        // 直接播放 MP3
        audioPlayer.play("mp3", "song.mp3");

        // 通过对象适配器播放 MP4
        audioPlayer.play("mp4", "movie.mp4");

        // 通过对象适配器播放 VLC
        audioPlayer.play("vlc", "video.vlc");

        // 不支持的格式
        audioPlayer.play("avi", "clip.avi");

        System.out.println("\n=== 类适配器示例 ===");
        // 使用类适配器
        MediaPlayer classAdapter = new Mp4ClassAdapter();
        classAdapter.play("mp4", "class_adapter_movie.mp4");
    }
}

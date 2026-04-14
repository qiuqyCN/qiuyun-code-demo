package dev.qiuyun.qiuyuncodedemo.patterns.adapter.classAdapter;


import dev.qiuyun.qiuyuncodedemo.patterns.adapter.MediaPlayer;

// ============================================
// 类适配器 (Class Adapter)
// 使用继承方式，Java 中只能继承一个类
// 这里演示继承 Mp4Player 的情况
// ============================================
public class Mp4ClassAdapter extends Mp4Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            playMp4(fileName);
        } else {
            System.out.println("Class adapter only supports mp4 format");
        }
    }
}

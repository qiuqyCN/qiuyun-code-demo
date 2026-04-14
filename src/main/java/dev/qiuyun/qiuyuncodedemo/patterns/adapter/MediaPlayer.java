package dev.qiuyun.qiuyuncodedemo.patterns.adapter;

// Target: 目标接口
// ============================================
public interface MediaPlayer {
    /**
     * 播放媒体文件
     * @param audioType 音频类型（如 "mp3", "mp4", "vlc"）
     * @param fileName 文件名
     */
    void play(String audioType, String fileName);
}

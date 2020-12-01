package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:22
 * @description:
 **/
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "...");
        audioPlayer.play("mp4", "...");
        audioPlayer.play("vlc", "...");
        audioPlayer.play("avi", "...");
    }
}

package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:11
 * @description:
 **/
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("...");
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing
    }
}

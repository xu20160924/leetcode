package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:12
 * @description:
 **/
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("...");
    }
}

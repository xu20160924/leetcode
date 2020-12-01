package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:07
 * @description:
 **/
public class WindowImpl extends WindowAdapter {
    @Override
    public void open() {
        System.out.println("窗口打开");
    }

    @Override
    public void close() {
        System.out.println("窗口关闭");
    }
}

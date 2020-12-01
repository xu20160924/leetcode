package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:08
 * @description:
 **/
public class WindowDemo {
    public static void main(String[] args) {
        Window win = new WindowImpl();
        win.open();
        win.close();
    }
}

package com.designpattern.adapter;

/**
 * @author: John
 * @date: 2020-04-24 16:06
 * @description: 定义抽象类实现接口， 在此类中覆写方法，但是所有的方法体为空
 **/
public abstract class WindowAdapter implements Window {

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void iconified() {

    }

    @Override
    public void deiconified() {

    }

    @Override
    public void activated() {

    }
}

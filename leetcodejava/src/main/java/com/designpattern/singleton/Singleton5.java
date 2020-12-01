package com.designpattern.singleton;

/**
 * @author: John
 * @date: 2020-11-01 17:53
 * @description: 线程安全的懒汉式单例
 **/
public class Singleton5 {
    // 私有内部类，按需加载，用时加载，也就是延迟加载
    private static class Holder {
        private static Singleton5 singleton5 = new Singleton5();
    }
    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return Holder.singleton5;
    }
}

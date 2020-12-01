package com.designpattern.singleton;

/**
 * @author: John
 * @date: 2020-04-24 11:16
 * @description: Singleton
 **/
public class Singleton {

    // 需要加上 volatile 关键字来保证线程安全 对于双重检查的时候
    private static volatile Singleton singleton = null;

    private Singleton() {
        System.out.println("init class");
    }

    // 第一种方法: 利用synchronize关键字来实现线程安全
    public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    // 第二种方法: 双重检测 来确保线程安全
    // 同时将同步块放在方法内减少每次都需要同步加锁带来的消耗
    public static Singleton getInstance1() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 第三种方法: 静态内部类实现懒汉式
    // 实现了线程安全又避免同步带来的影响
    private static class LazyLoader {
        // jvm内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的
        private static final Singleton SINGLETON = new Singleton();
    }

    public static final Singleton getInstance3() {
        return LazyLoader.SINGLETON;
    }
}

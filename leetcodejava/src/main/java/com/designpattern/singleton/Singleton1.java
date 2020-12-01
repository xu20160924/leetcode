package com.designpattern.singleton;

/**
 * @author: John
 * @date: 2020-11-01 17:32
 * @description: 饿汉式单例
 **/
public class Singleton1 {

    // 指向自己实例的私有静态引用，主动创建
    private static Singleton1 singleton1 = new Singleton1();

    // 私有构造方法
    private Singleton1() {
    }

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static Singleton1 getSingleton1() {
        return singleton1;
    }
}

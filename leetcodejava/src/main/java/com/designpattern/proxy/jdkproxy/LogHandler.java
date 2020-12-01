package com.designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: John
 * @date: 2020-04-24 15:07
 * @description:
 **/
public class LogHandler implements InvocationHandler {

    private Object impClass;

    public LogHandler(Object impClass) {
        this.impClass = impClass;
    }

    public Object bind(Object impClass) {
        this.impClass = impClass;
        return Proxy.newProxyInstance(impClass.getClass().getClassLoader(),
                impClass.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在调用代理的对象的真实方法前  先调用一些自己的方法和规则...");
        System.out.println("Method: " + method);

        method.invoke(impClass, args);

        return null;
    }
}

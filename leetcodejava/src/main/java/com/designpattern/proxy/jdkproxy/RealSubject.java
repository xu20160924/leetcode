package com.designpattern.proxy.jdkproxy;

/**
 * @author: John
 * @date: 2020-04-24 15:06
 * @description:
 **/
public class RealSubject implements SubjectOperations {
    @Override
    public void print() {
        System.out.println("...");
    }

    @Override
    public void printfStr(String string) {
        System.out.println(string);
    }
}

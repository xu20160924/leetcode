package com.designpattern.proxy.jdkproxy;

/**
 * @author: John
 * @date: 2020-04-24 15:10
 * @description:
 **/
public class Client {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        LogHandler handler = new LogHandler(subject);

        // 转化成接口 只能代理实现了接口的类
        SubjectOperations subjectOperations = (SubjectOperations) handler.bind(subject);
        System.out.println(subjectOperations.getClass().getName());

        subjectOperations.print();
        subjectOperations.printfStr("YYYYYY");
    }
}

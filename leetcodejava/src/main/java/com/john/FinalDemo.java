package com.john;

/**
 * @author: John
 * @date: 2020-10-23 14:15
 * @description:
 **/
public class FinalDemo {
    private int a; // 普通域
    private final int b; // finaly域
    private static FinalDemo finalDemo;

    public FinalDemo() {
        a = 1;
        b = 2;
    }
    public static void writer() {
        finalDemo = new FinalDemo();
    }

    public static void reader() {
        FinalDemo demo = finalDemo;
        int a = demo.a;
        int b = demo.b;
    }

}

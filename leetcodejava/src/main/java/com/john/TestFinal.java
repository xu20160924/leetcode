package com.john;

/**
 * @author: John
 * @date: 2020-10-23 13:57
 * @description:
 **/
public class TestFinal {
//    final int a = 20;
    // ldc 常量池中获取，final会将大于short类型最大值的数字放入常量池中
    public final static int constant = 200_0000;
    public static int staticNumber = 300_0000;
    // ldc 常量池中获取，final会将大于short类型最大值的数字放入常量池中
    public final int finalNumber = 400_0000;
    public final int littleNumber = 400;

    public static void main(String[] args) {
        System.out.println(constant);
        System.out.println(staticNumber);
        System.out.println(new TestFinal().finalNumber);
        System.out.println(new TestFinal().littleNumber);
    }

}

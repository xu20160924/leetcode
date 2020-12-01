package com.leetcode;

/**
 * @author: John
 * @date: 2020-10-22 09:55
 * @description: 371
 **/
public class ThreeSevenOne {
//    public int getSum(int a, int b) {
//        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
//    }

    public int getSum(int a, int b) {
        int c;
        while (b != 0) {
            c = (a & b);
            System.out.println(Integer.toBinaryString(c));
            a = a ^ b;
            System.out.println(Integer.toBinaryString(a));
            b = (c) << 1;
            System.out.println(Integer.toBinaryString(b));
        }
        return a;
    }

    public static void main(String[] args) {
        ThreeSevenOne threeSevenOne = new ThreeSevenOne();
        threeSevenOne.getSum(3, 2);

    }
}

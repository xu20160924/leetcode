package com.john;

/**
 * @author: John
 * @date: 2020-02-03 16:09
 * @description: Bit operation
 **/
public class BitWise {

    public static int flip(int n) {
        return n ^ 1;
    }
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }
    public static int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void printOddTimesNum2(int[] arr) {
        int e0 = 0, e0hasOne = 0;
        for (int curNum : arr) {
            e0 ^= curNum;
        }
        int rightOne = e0 & (~e0 + 1);
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {
                e0hasOne ^= cur;
            }
        }
        System.out.println(e0hasOne + e0 ^ e0hasOne);
    }

    public static void main(String[] args) {
        System.out.println(5 - -3);
    }
}

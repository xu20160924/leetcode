package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-10 14:18
 * @description: 10
 **/
public class OneZero {

    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}

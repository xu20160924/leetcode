package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-10 14:36
 * @description: Frog jump
 **/
public class OneZeroFrog {
    public int numWays(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}

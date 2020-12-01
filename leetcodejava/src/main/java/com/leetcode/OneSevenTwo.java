package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-28 12:44
 * @description: 172
 **/
public class OneSevenTwo {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

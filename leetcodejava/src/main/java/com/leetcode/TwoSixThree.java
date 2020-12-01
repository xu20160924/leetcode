package com.leetcode;

/**
 * @author: John
 * @date: 2020-04-22 16:11
 * @description: 263
 **/
public class TwoSixThree {
    public boolean isUgly(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
               num /= i;
            }
        }
        return num == 1;
    }
}

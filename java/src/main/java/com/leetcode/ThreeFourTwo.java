package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-18 11:49
 * @description: 342
 **/
public class ThreeFourTwo {
    public boolean isPowerOfFour(int num) {
       return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555)  != 0;
    }
}

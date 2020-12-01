package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-18 11:49
 * @description: 342
 **/
public class ThreeFourTwo {
    public boolean isPowerOfFour(int num) {
        //        return !((num & (num - 1)) && (num & 0x55555555));
//        return !(num&(num-1)) && (num&0x55555555);
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }
}

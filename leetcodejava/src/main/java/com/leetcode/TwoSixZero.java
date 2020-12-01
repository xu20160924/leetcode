package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-03 19:49
 * @description: 260
 **/
public class TwoSixZero {
    public static int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums) {
           if ((num & diff) != 0) {
               x ^= num;
           }
        }
        return new int[] {x, bitmask ^ x};
    }

}

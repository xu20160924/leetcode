package com.leetcode;

/**
 * @author: John
 * @date: 2020-04-14 13:54
 * @description: 80
 **/
public class EightZero {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        EightZero eightZero = new EightZero();
        eightZero.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}

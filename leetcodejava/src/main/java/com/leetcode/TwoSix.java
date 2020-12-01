package com.leetcode;

/**
 * @author: John
 * @date: 2020-04-14 13:22
 * @description: 26
 **/
public class TwoSix {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        TwoSix twoSix = new TwoSix();
        twoSix.removeDuplicates(new int[]{1, 1, 2});
    }
}


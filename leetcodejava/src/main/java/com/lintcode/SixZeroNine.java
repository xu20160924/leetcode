package com.lintcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-16 09:20
 * @description: 609
 **/
public class SixZeroNine {
    public int twoSumS(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}

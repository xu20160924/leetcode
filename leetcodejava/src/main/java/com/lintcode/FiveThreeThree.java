package com.lintcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-16 09:33
 * @description: 533
 **/
public class FiveThreeThree {
    public int twoSumCloset(int[] nums, int target) {
        if (nums == null) {
           return -1;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int best = Integer.MAX_VALUE;
        while (i < j) {
            int diff = Math.abs(nums[i] + nums[j] - target);
            best = Math.min(best, diff);
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return best;
    }
}

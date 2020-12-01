package com.lintcode;

import java.util.List;

/**
 * @author: John
 * @date: 2020-04-06 21:35
 * @description: 44
 **/
public class FourFour {
    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int n = nums.size();
        int[] dp = new int[n];
        dp[0] = nums.get(0);
        int min = nums.get(0);

        for (int i = 1; i < n; i++) {
            dp[i] = nums.get(i) + (dp[i - 1] < 0 ? dp[i - 1] : 0);
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}

package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-16 21:42
 * @description: 53
 **/
public class FiveThree {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}

package com.leetcode;


/**
 * @author: John
 * @date: 2020-01-14 12:01
 * @description:  152
 **/
public class OneFiveTwo {

    public int maxProduct(int[] nums) {
        Tuple[] dp = new Tuple[nums.length];
        dp[0] = new Tuple(nums[0], nums[0]);
        int res = dp[0].imax;
        for (int i = 1; i < nums.length; i++) {
            Tuple prev = dp[i - 1];
            int imax = Math.max(Math.max(nums[i], nums[i] * prev.imax), nums[i] * prev.imin);
            int imin = Math.min(Math.min(nums[i], nums[i] * prev.imax), nums[i] * prev.imin);
            dp[i] = new Tuple(imax, imin);
            res = Math.max(imax, res);
        }
        return res;
    }

    class Tuple {
        private int imax;
        private int imin;

        public Tuple(int imax, int imin) {
            this.imax = imax;
            this.imin = imin;
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, -2, 4};
        OneFiveTwo oneFiveTwo = new OneFiveTwo();
        System.out.println(oneFiveTwo.maxProduct(input));
    }
}

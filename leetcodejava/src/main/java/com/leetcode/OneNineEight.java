package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-03-02 19:23
 * @description: 198
 **/
public class OneNineEight {
//    public int rob(int[] num) {
//        int prevMax = 0;
//        int currMax = 0;
//        for (int x : num) {
//            int temp = currMax;
//            currMax = Math.max(prevMax + x, currMax);
//            prevMax = temp;
//        }
//        return currMax;
//    }

//    public int rob(int[] nums) {
//        return rob(nums, nums.length - 1);
//    }
//    private int rob(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//    }

//    int[] memo;
//    public int rob(int[] nums) {
//        memo = new int[nums.length + 1];
//        Arrays.fill(memo, 0);
//        return rob(nums, nums.length - 1);
//    }
//    private int rob(int[] nums, int i) {
//        if (i < 0) {
//            return 0;
//        }
//        if (memo[i] >= 0) {
//            return memo[i];
//        }
//        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
//        memo[i] = result;
//        return result;
//    }

//    public int rob(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int[] memo = new int[nums.length + 1];
//        memo[0] = 0;
//        memo[1] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//           int val = nums[i];
//           memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
//        }
//        return memo[nums.length];
//    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1};
        OneNineEight oneNineEight = new OneNineEight();
        oneNineEight.rob(num);
    }
}

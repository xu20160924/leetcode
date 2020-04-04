package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-01-26 14:54
 * @description: 239
 **/
public class TwoThreeNine {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n ; i++) {
            // from left to right
            // block start
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            int j = n - i - 1;
            // block end
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1 ; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Arrays.stream(TwoThreeNine.maxSlidingWindow(nums, k)).forEach(x -> System.out.println(x));
    }
}

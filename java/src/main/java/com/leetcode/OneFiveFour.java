package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-30 17:56
 * @description: 154
 **/
public class OneFiveFour {
//    public static int findMin(int[] nums) {
//        int result = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] < result) {
//                result = nums[i];
//            }
//        }
//        return result;
//    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}

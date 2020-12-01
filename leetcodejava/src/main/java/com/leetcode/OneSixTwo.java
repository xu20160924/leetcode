package com.leetcode;

/**
 * @author: John
 * @date: 2020-05-11 11:56
 * @description: 162
 **/
public class OneSixTwo {


    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * recursive binary search
     *
     * @param nums
     * @return
     */
//    public int findPeakElement(int[] nums) {
//        return search(nums, 0, nums.length - 1);
//    }
//
//    public int search(int[] nums, int l, int r) {
//        if (l == r) {
//            return l;
//        }
//        int mid = l + (r - l) / 2;
//        if (nums[mid] > nums[mid + 1]) {
//            return search(nums, l, mid);
//        }
//        return search(nums, mid + 1, r);
//    }

    // linear scan
//    public int findPeakElement(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return nums.length - 1;
//    }


}

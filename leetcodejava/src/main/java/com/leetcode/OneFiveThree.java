package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-30 21:05
 * @description: 153
 **/
public class OneFiveThree {
//    public static int findMin(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int left = 0, right = nums.length - 1;
//        if (nums[right] > nums[0]) {
//            return nums[0];
//        }
//        while (right >= left) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] > nums[mid + 1]) {
//                return nums[mid + 1];
//                //                right = mid - 1;
//            }
//            if (nums[mid - 1] > nums[mid]) {
//                return nums[mid];
//            }
//
//            if (nums[mid] > nums[0]) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return nums[0];
//    }

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                // case 1 right side sorted, left side has pivot (minval), go left to find it
                // case 2 both sides sorted, go left to find the smallest value (minval)
                hi = mid;
            } else {
                // case 1 left side sorted, right side has pivot (minval), go right to find it
                lo = mid + 1;
            }
        }
        // loop exits when hi == lo == the smallest value in the array
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(OneFiveThree.findMin(nums));
    }
}

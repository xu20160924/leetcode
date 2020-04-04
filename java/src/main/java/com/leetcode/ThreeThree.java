package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-06 14:36
 * @description: 33
 **/
public class ThreeThree {
//    public static int search(int[] nums, int target) {
//        int minIdx = findMinIdx(nums);
//        if (target == nums[minIdx]) {
//            return minIdx;
//        }
//        int m = nums.length;
//        int start = (target <= nums[m - 1]) ? minIdx : 0;
//        int end = (target > nums[m - 1]) ? minIdx : m - 1;
//        while(start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (target > nums[mid]) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return -1;
//    }
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // target and mid are on the same side
            if ((nums[mid] - nums[nums.length - 1]) * (target - nums[nums.length - 1]) > 0) {
                if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else if (target > nums[nums.length - 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        if (nums[lo] == target) {
            return lo;
        } else {
            return -1;
        }
    }

    public static int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        ThreeThree.search(nums, 4);
    }
}

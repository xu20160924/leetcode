package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-29 13:34
 * @description: 41
 **/
public class FourOne {
//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        int contains = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 1) {
//                contains++;
//                break;
//            }
//        }
//        if (contains == 0) {
//            return 1;
//        }
//        if (n == 1) {
//            return 2;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if ((nums[i] <= 0) || (nums[i] > n)) {
//               nums[i] = 1;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            int a = Math.abs(nums[i]);
//            if (a == n) {
//                nums[0] = -Math.abs(nums[0]);
//            } else {
//                nums[a] = -Math.abs(nums[a]);
//            }
//        }
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > 0) {
//                return i;
//            }
//        }
//        if (nums[0] > 0) {
//            return n;
//        }
//        return n + 1;
//    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        FourOne fourOne = new FourOne();
//        int[] nums = {3,4,1,1,1,5,1,1,2,1};
        int[] nums = {2,3,-1,0};
        fourOne.firstMissingPositive(nums);
    }
}

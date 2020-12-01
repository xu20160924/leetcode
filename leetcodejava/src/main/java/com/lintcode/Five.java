package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-11 16:46
 * @description: 5
 **/
public class Five {

    public int kthLargestElement(int n, int[] nums) {
        if (nums == null || nums.length == 0 || n < 1 || n > nums.length) {
            return -1;
        }
        return partition(nums, 0, nums.length - 1, nums.length - n);
    }

    private int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[k];
        }
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

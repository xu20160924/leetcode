package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-16 20:15
 * @description: 31
 **/
public class ThreeOne {

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] < k) {
                left++;
            }
            while (left < right && nums[right] >= k) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (nums[left] < k) {
            return left + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        ThreeOne threeOne = new ThreeOne();
        threeOne.partitionArray(new int[]{3,2,2,1}, 2);
    }
}

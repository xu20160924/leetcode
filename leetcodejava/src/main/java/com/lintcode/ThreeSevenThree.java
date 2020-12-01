package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-16 20:32
 * @description: 373
 **/
public class ThreeSevenThree {
    public void partitionArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
           while (start < end && nums[start] % 2 == 1) {
              start++;
           }
           while (start < end && nums[end] % 2 == 0) {
              end--;
           }
           if (start < end) {
              int temp = nums[start];
              nums[start] = nums[end];
              nums[end] = temp;
              start++;
              end--;
           }
        }
    }
}

package com.lintcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-16 09:24
 * @description: 443
 **/
public class FourFourThree {
   public int twoSumS(int[] nums, int target) {
       if (nums == null || nums.length < 2) {
           return 0;
       }

       Arrays.sort(nums);
       int left = 0, right = nums.length - 1;
       int count = 0;
       while (left < right) {
          if (nums[left] + nums[right] >= target) {
              count += right - left;
              left++;
          } else {
              right--;
          }
       }
       return count;
   }
}

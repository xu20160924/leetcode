package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-10-22 13:36
 * @description: 268
 **/
public class TwoSixEight {
//    public int missingNumber(int[] nums) {
//        int ret = 0;
//        for (int i = 0; i < nums.length; i++) {
//            ret ^= i;
//            ret ^= nums[i];
//        }
//        return ret ^= nums.length;
//    }

//    public int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//
//        if (nums[nums.length - 1] !=  nums.length) {
//            return nums.length;
//        }
//
//        if (nums[0] != 0) {
//            return 0;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            int expectedNum = nums[i - 1] + 1;
//            if (nums[i] != expectedNum) {
//                return expectedNum;
//            }
//        }
//        return -1;
//    }

//    public int missingNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int expectedNumCount = nums.length + 1;
//        for (int i = 0; i < expectedNumCount; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public int missingNumber(int[] nums) {
//        int missing = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            missing ^= i ^ nums[i];
//        }
//        return missing;
//    }

    public int missingNumber(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
    }

}

package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-04-13 16:06
 * @description: 523
 **/
public class FiveTwoThree {
//    public boolean checkSubarraySum(int[] nums, int k) {
//
//        if (nums.length < 2) {
//            return false;
//        }
//        if (k == 0) {
//            k++;
//        }
//
//        int remain = 0;
//        Set<Integer> remainSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            if ((remain == 0 && remain == nums[i] && remainSet.size() > 1) || remainSet.contains(remain % k)) {
//               return true;
//            }
//            int curr = nums[i] % k;
//            remainSet.add(curr);
//
//            if ((nums[i] != 0 && nums[i] % k == 0)) {
//                remain = 0;
//                remainSet.clear();
//            }
//            remain += curr;
//        }
//        return false;
//
////        HashMap<Integer, Integer> map = new HashMap<>();
////        for (int i = 0; i < nums.length; i++) {
////
////        }
//
//    }

//    public boolean checkSubarraySum(int[] nums, int k) {
//
//        if (nums.length < 2) {
//            return false;
//        }
//
//        int remain = 0;
//        Set<Integer> remainSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            int curr = 0;
//            if (k == 0) {
//                curr += nums[i];
//                if (remainSet.size() == 1 && curr == 0) {
//                   return true;
//                }
//                if (remain > 0) {
//                    remain = 0;
//                    remainSet.clear();
//                }
//
//            } else {
//                if (remainSet.size() == 2 && remainSet.contains(remain % k)) {
//                    return true;
//                }
//                curr = nums[i] % k;
//
//                if ((nums[i] != 0 && nums[i] % k == 0)) {
//                    remain = 0;
//                    remainSet.clear();
//                }
//            }
//            remain += curr;
//            remainSet.add(curr);
//        }
//        return false;
//
////        HashMap<Integer, Integer> map = new HashMap<>();
////        for (int i = 0; i < nums.length; i++) {
////
////        }
//
//    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // 这里初始化(0, -1) 是为了corner case  当k == 0 时 如果不加入 (0, -1)
        // 再进行put的时会把0覆盖，
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            // 0 不能进行求余
            if (k != 0) {
                runningSum %= k;
            }
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(runningSum, i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FiveTwoThree fiveTwoThree = new FiveTwoThree();
//        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{0, 0}, 0));
        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{0, 1, 0, 0}, 0));
//        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{1, 0}, 2));
//        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{0}, 0));
//        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{0, 1, 0}, 0));
//        System.out.println(fiveTwoThree.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 0));
//        System.out.println(23 % 1);
    }
}

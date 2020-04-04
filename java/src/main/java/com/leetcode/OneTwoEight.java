package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-03-06 16:28
 * @description: 128
 **/
public class OneTwoEight {


    // brute solution
//    private boolean arrayContains(int[] arr, int num) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == num) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int longestConsecutive(int[] nums) {
//        int longestStreak = 0;
//        for (int num : nums) {
//            int currentNum = num;
//            int currentStreak = 1;
//            while (arrayContains(nums, currentNum + 1)) {
//                currentNum += 1;
//                currentStreak += 1;
//            }
//            longestStreak = Math.max(longestStreak, currentStreak);
//        }
//        return longestStreak;
//    }


    // sort solution
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        Arrays.sort(nums);
//        int longestStreak = 1;
//        int currentStreak = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[i-1]) {
//                if (nums[i] == nums[i-1] + 1) {
//                    currentStreak += 1;
//                } else {
//                    longestStreak = Math.max(longestStreak, currentStreak);
//                    currentStreak = 1;
//                }
//            }
//        }
//        return Math.max(longestStreak, currentStreak);
//    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
           num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currenStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currenStreak += 1;
                    currentNum += 1;
                }
                longestStreak = Math.max(longestStreak, currenStreak);
            }
        }
        return longestStreak;
    }


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        OneTwoEight oneTwoEight = new OneTwoEight();
        oneTwoEight.longestConsecutive(nums);

//        System.out.println(100 % 6);
//        System.out.println((4) % 6 + 5);
//        System.out.println((200) % 6 + 4);
//        System.out.println((10) % 6 + 3);
//        System.out.println((3) % 6 + 2);
//        System.out.println((2) % 6 + 1);


//        System.out.println(100 % 6);
//        System.out.println((4+ 1) % 6);
//        System.out.println((200 + 2) % 6);
//        System.out.println((10 + 3) % 6);
//        System.out.println((3 + 4) % 6);
//        System.out.println((2 + 5) % 6);


//        System.out.println(100 % 6);
//        System.out.println((4+ 1) % 6);
//        System.out.println((200 + 2) % 6);
//        System.out.println((10 + 3) % 6);
//        System.out.println((3 + 4) % 6);
//        System.out.println((2 + 5) % 6);
    }
}

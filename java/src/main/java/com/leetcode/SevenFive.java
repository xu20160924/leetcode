package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-01-22 13:57
 * @description: 75
 **/
public class SevenFive {

//    public void sortColors(int[] nums) {
//        // for all  idx < i : nums[idx < i] = 0
//        // j is current index
//        int p0 = 0, curr = 0;
//        // for all idex > k : nums[idx > k] = 2
//        int p2 = nums.length - 1;
//
//        int tmp;
//        while (curr <= p2) {
//            if (nums[curr] == 0) {
//                // swap p0 and curr item
//                //i++ j++
//                tmp = nums[p0];
//                nums[p0++] = nums[curr];
//                nums[curr++] = tmp;
//            } else if (nums[curr] == 2) {
//                //swap k and curr item
//                // p2--
//                tmp = nums[curr];
//                nums[curr] = nums[p2];
//                nums[p2--] = tmp;
//            } else {
//                curr++;
//            }
//        }
//    }

    /**
     * 用三个变量记录red,white,blue的下标位置。起始下标都为-1
     *
     * 如果A[i] == 0 ，插入red对white blue有影响，blue先整体向后移动一位，white再整体向后移动一位，如果不移动，前面插入的数据就会覆盖已有的。
     *
     * 如果A[i] == 1，插入white对blue有影响，blue整体向后移动一位。
     *
     * A[i] == 2，直接插入blue
     */
//    public static int[] sortColors(int[] nums) {
//        int red = -1, white = -1, blue = -1;
//        for (int i = 0; i < nums.length; ++i) {
//            if (nums[i] == 0) {
//                nums[++blue] = 2;
//                nums[++white] = 1;
//                nums[++red] = 0;
//            } else if (nums[i] == 1){
//                nums[++blue] = 2;
//                nums[++white] = 1;
//            } else {
//                nums[++blue] = 2;
//            }
//        }
//        return nums;
//    }

    // I want to some trick operation but i failed
    public static int[] sortColors(int[] nums) {
        int n = nums.length;
        int c = n / 3;
        if (n < 3) {
            Arrays.sort(nums);
            return nums;
        }
        for (int i = 0; i < n; i++) {
//            if (nums[0] == 0) {
//                nums[0] = 0;
//                continue;
//            }
            nums[i] = i / c;
        }
        return nums;
    }

    public static void main(String[] args) {
//        int[] input = {2,0,2,1,1,0};
        int[] input = {1};
        Arrays.stream(SevenFive.sortColors(input)).forEach(x -> System.out.println(x));
//        System.out.println(5 / 2);
    }


}

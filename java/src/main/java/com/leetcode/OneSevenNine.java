package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * @author: John
 * @date: 2020-03-04 17:11
 * @description: 179
 **/
public class OneSevenNine {
    //    private class LargerNumberComparator implements Comparator<String> {
//
//        @Override
//        public int compare(String a, String b) {
//            String order1 = a + b;
//            String order2 = b + a;
//            return order2.compareTo(order1);
//        }
//    }
//
//    public String largestNumber(int[] nums) {
//        // Get input integers as strings.
//        String[] asStrs = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            asStrs[i] = String.valueOf(nums[i]);
//        }
//        // Sort strings according to custom comparator.
//        Arrays.sort(asStrs, new LargerNumberComparator());
//
//        //If, after being sorted, the largest number is `0`, the entire number
//        // is zero.
//        if (asStrs[0].equals("0")) {
//            return "0";
//        }
//        String largestNumberStr = new String();
//        for (String numAsStr : asStrs) {
//            largestNumberStr += numAsStr;
//        }
//        return largestNumberStr;
//    }
    private class LargerNumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            o1 = Math.max(o1 / 10, o1 % 10);
            o2 = Math.max(o2 / 10, o2 % 10);
            return o2 - o1;
        }
    }

    public String largestNumber(int[] nums) {
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = Integer.valueOf(nums[i]);
        }
        Arrays.sort(integers, new LargerNumberComparator());
        StringBuilder res = new StringBuilder();
        for (int s : integers) {
            res.append(s);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {121, 12};
        OneSevenNine oneSevenNine = new OneSevenNine();
        oneSevenNine.largestNumber(nums);
    }

}

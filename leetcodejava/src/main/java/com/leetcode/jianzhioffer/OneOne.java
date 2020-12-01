package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-10 14:42
 * @description: 11
 **/
public class OneOne {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
           int mid = l + (r - l) / 2;
           if (numbers[mid] > numbers[r]) {
               l = mid + 1;
           } else if (numbers[mid] < numbers[r]) {
               r = mid;
           } else {
               // 针对去重处理
               r--;
           }
        }
        return numbers[r];
    }

    public static void main(String[] args) {
        OneOne oneOne = new OneOne();
//        System.out.println(oneOne.minArray(new int[]{3,4,5,1,2}));
        System.out.println(oneOne.minArray(new int[]{3,3,1,3}));
    }
}

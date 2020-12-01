package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-04-17 16:22
 * @description: 31
 **/
public class ThreeOne {
//    public void nextPermutation(int[] nums) {
//        // 1. 从后向前查看逆序区域， 找到逆序区域的前一位，也就是数字置换的边界
//        int index = findTransferPoint(nums);
//        // 如果数字置换边界为0， 说明整个数组已经逆序，
//        // 无法得到更大的相同数字组成的整数，返回null
//        if (index == 0) {
//            return;
//        }
//
//        // 2. 把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
//        // 复制并入参，避免直接修改入参
//        int[] numsCopy = Arrays.copyOf(nums, nums.length);
//        exchangeHead(numsCopy, index);
//        // 3. 把原来的逆序区域转为顺序
//        reverse(numsCopy, index);
//    }
//
//    private int[] reverse(int[] num, int index) {
//        for (int i = index, j = num.length - 1; i < j; i++, j--) {
//            int tmp = num[i];
//            num[i] = num[j];
//            num[j] = tmp;
//        }
//        return num;
//    }
//
//    private int[] exchangeHead(int[] nums, int index) {
//        int head = nums[index - 1];
//        for (int i = nums.length - 1; i > 0; i--) {
//            if (head < nums[i]) {
//               nums[index - 1] = nums[i];
//               nums[i] = head;
//               break;
//            }
//        }
//        return nums;
//    }
//
//
//
//    private static int findTransferPoint(int[] numbers) {
//        for (int i = numbers.length - 1; i > 0; i--) {
//            if (numbers[i] > numbers[i - 1]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        ThreeOne threeOne = new ThreeOne();
//        threeOne.nextPermutation(new int[]{1, 2, 3});
        threeOne.nextPermutation(new int[]{1, 1});
    }
}

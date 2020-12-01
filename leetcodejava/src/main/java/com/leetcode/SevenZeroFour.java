package com.leetcode;

/**
 * @author: John
 * @date: 2020-11-21 19:57
 * @description: 704
 **/
public class SevenZeroFour {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * [-1,0,3,5,9,12]
     * 9
     * @param args
     */
    public static void main(String[] args) {
        SevenZeroFour sevenZeroFour = new SevenZeroFour();
        System.out.println(sevenZeroFour.search(new int[]{-1,0,3,5,9,12}, 9));
    }
}

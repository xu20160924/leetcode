package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-18 21:15
 * @description: 189
 **/
public class OneEightNine {
//    public void rotate(int[] nums, int k) {
//        int[] a = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            a[(i + k) % nums.length] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = a[i];
//        }
//    }
//   public void rotate(int[] nums, int k) {
//       k = k % nums.length;
//       int count = 0;
//       for (int start = 0; count < nums.length; start++) {
//           int current = start;
//           int prev = nums[start];
//           do {
//               int next = (current + k) % nums.length;
//               int temp = nums[next];
//               nums[next] = prev;
//               prev = temp;
//               current = next;
//               count++;
//           } while (start != current);
//       }
//   }


    /**
     * 假设 n=7n=7 且 k=3k=3 。
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end)  {
           int temp = nums[start];
           nums[start] = nums[end];
           nums[end] = temp;
           start++;
           end--;
        }
    }

    public static void main(String[] args) {
        OneEightNine oneEightNine = new OneEightNine();
        int[] nums = new int[]{1,2,3,4,5,6};
        oneEightNine.rotate(nums, 2);
        System.out.println("a");
    }
}

package com.leetcode.jianzhioffer;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-05-04 10:29
 * @description: 03
 **/
public class ZeroThree {

    /**
     *  这道题需要进行沟通
     *  1. 如果只是时间优先就用字典
     *  2. 如果还有空间要求 就用指针+原地排序数组
     *  3. 如果要求空间O(1)并且不能修改原数组，用二分法
     *  4. 还可以将数组视为哈希表计算处理（原地hash）
     */


    /**
     * 4. 把数组视为哈希表
     *
     * @param nums
     * @return
     */
//    public int findRepeatNumber(int[] nums) {
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            /**
//             * 这里其实相当于进行一个排序， 如果当前的数不在它应该在的下标上
//             * 就进行交换 直到交换到对应的下标上，如果交换到了对应的下标上 但没有找到重复的
//             * 就进行下一个下标的计算
//             */
//            System.out.println(Arrays.toString(nums));
//            // 只要当前值不是对应的下标 就进行计算
//            while (nums[i] != i) {
//                if (nums[i] == nums[nums[i]]) {
//                    return nums[i];
//                }
//                swap(nums, i, nums[i]);
//            }
//        }
//        return -1;
//    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        ZeroThree zeroThree = new ZeroThree();
//        System.out.println(zeroThree.findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
//        System.out.println(zeroThree.findRepeatNumber(new int[]{2,3,1,2,5,3}));
//        System.out.println(zeroThree.findRepeatNumber(new int[]{3,1,2,3}));
        System.out.println(zeroThree.findRepeatNumber(new int[]{0, 1, 2, 0, 4, 5, 6, 7, 8, 9}));
    }

    /**
     * 3. 二分
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (end >= start) {
            // int mid = start + (end - start) / 2;
            int count = 0;
            int mid = ((end - start) >> 1) + start;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= start && nums[i] <= mid) {
                    count++;
                }
            }
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start) + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 2. 指针排序
     * @param nums
     * @return
     */
//    public int findRepeatNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return nums[i];
//            }
//        }
//        return -1;
//    }


    /**
     * 1. set
     * @param nums
     * @return
     */
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        int repeat = -1;
//        for (int num : nums) {
//            if (!set.add(num)) {
//                repeat = num;
//                break;
//            }
//        }
//        return repeat;
//    }


}

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-15 08:50
 * @description: 18
 **/
public class OneEight {
    //    public List<List<Integer>> fourSum(int[] nums, int target) {
//        // 定义一个返回值
//        List<List<Integer>> result = new ArrayList<>();
//        // 当数组为null或元素小于4个时，直接返回
//        if (nums == null || nums.length < 4) {
//            return result;
//        }
//
//        // 对数组进行从小到大排序
//        Arrays.sort(nums);
//        // 数组长度
//        int length = nums.length;
//        // 定义4个指针k, i, j, h, k 从0开始遍历，i 从k+1 开始遍历， 留下j和h
//        // j指向i+1, h指向数组最大值
//        for (int k = 0; k < length - 3; k++) {
//            // 当k的值与前面的值相等时hulve
//            if (k > 0 && nums[k] == nums[k - 1]) {
//                continue;
//            }
//            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
//            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
//            if (min1 > target) {
//                break;
//            }
//
//            // 获取当前最大值，如果最大值比目标值小, 说明后面越来越小的值根本没戏，忽略
//            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
//            if (max1 < target) {
//                continue;
//            }
//
//            // 第二层循环i， 初始值指向k + 1
//            for (int i = k + 1; i < length - 2; i++) {
//                // 当i的值与前面的值相等时忽略
//                if (i > k + 1 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                // 定义指针j 指向i+1
//                int j = i + 1;
//                // 定义指针h指向数组末尾
//                int h = length - 1;
//                // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏， 忽略
//                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
//                if (min > target) {
//                    continue;
//                }
//                // 获取当前最大值， 如果最大值比目标值小，说明后面越来越小的值根本没戏， 忽略
//                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
//                if (max < target) {
//                    continue;
//                }
//                // 开始j指针和i指针的表演，计算当前和， 如果等于目标值，j++ 并去重，h--并去重，
//                // 当当前和大于目标值时h--，当当前和小于目标值时j++
//                while (j < h) {
//                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
//                    if (curr == target) {
//                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
//                        j++;
//                        while (j < h && nums[j] == nums[j - 1]) {
//                            j++;
//                        }
//                        h--;
//                        while (j < h && i < h && nums[h] == nums[h + 1]) {
//                           h--;
//                        }
//                    } else if (curr > target) {
//                        h--;
//                    } else {
//                        j++;
//                    }
//                }
//            }
//        }
//        return result;
//    }
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                // find a pair
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    // skip duplication
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                    // move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    // move right bound
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                // use current number to reduce ksum into k - 1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    // add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    // skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        OneEight oneEight = new OneEight();
        List<List<Integer>> res = oneEight.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        System.out.println("");
    }
}

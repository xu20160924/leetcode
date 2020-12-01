package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-23 12:05
 * @description: 15
 **/
public class OneFive {

//    public List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length - 2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                       res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                       while (lo < hi && num[lo] == num[lo + 1]) {
//                           lo++;
//                       }
//                       while (lo < hi && num[hi] == num[hi - 1]) {
//                           hi--;
//                       }
//                       lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) {
//                       lo++;
//                    } else {
//                        hi--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

//    public List<List<Integer>> threeSum(int[] num) {
//        Arrays.sort(num);
//        List<List<Integer>> res = new LinkedList<>();
//        for (int i = 0; i < num.length - 2; i++) {
//            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
//                int lo = i+1, hi = num.length -1, sum = 0 -num[i];
//                while (lo < hi) {
//                    if (num[lo] + num[hi] == sum) {
//                       res.add(Arrays.asList(num[i], num[lo], num[hi]));
//                       while (lo < hi && num[lo] == num[lo+1]) {
//                           lo++;
//                       }
//                       while (lo < hi && num[hi] == num[hi-1]) {
//                           hi--;
//                       }
//                       lo++; hi--;
//                    } else if (num[lo] + num[hi] < sum) {
//                        while (lo < hi & num[lo] == num[lo + 1]) {
//                            lo++;
//                        }
//                        lo++;
//                    } else {
//                        while (lo < hi && num[hi] == num[hi - 1]) {
//                            hi--;
//                        }
//                        hi--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {  // 如果排序后的取i是大于0的  由于后面都是正数 更不可能构成答案 直接返回
                return res;
            }
            // 如果下一个与当前重复 直接跳过当前这个 以避免重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i]; // sum 先减去当前的 然后循环中去求剩下的两个
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    // 从左边开始去重
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    // 从右边开始去重
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    // 去重后分别向中间一步
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < sum) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        OneFive oneFive = new OneFive();
        System.out.println(oneFive.threeSum(array));
    }
}

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 14:13
 * @description: 39
 **/
public class ThreeNine {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
//        backtrack(res, new ArrayList<>(), candidates, target, 0);
//        return res;
//    }
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int start) {
//        if (remain < 0) {
//            return;
//        } else if (remain == 0) {
//            res.add(new ArrayList<>(temp));
//        } else {
//            for (int i = start; i < nums.length; i++) {
//                temp.add(nums[i]);
//                backtrack(res, temp, nums, remain - nums[i], i);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//        backtrack(ans, new ArrayList<>(), candidates, target, 0);
//        return ans;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int start) {
//        if (remain < 0) {
//            return;
//        }
//        if (remain == 0) {
//            res.add(temp);
//        } else {
//            for (int i = start; i < nums.length; i++) {
//                temp.add(nums[i]);
//                backtrack(res, temp, nums, remain - nums[i], i);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int index) {
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (remain < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remain - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        ThreeNine threeNine = new ThreeNine();
        List<List<Integer>> a = threeNine.combinationSum(new int[]{2,3,6,7}, 7);

    }
}

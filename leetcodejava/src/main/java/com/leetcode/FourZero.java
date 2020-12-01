package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 15:05
 * @description: 40
 **/
public class FourZero {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(candidates);
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int start) {
//        if (remain < 0) {
//            return;
//        } else if (remain == 0) {
//            res.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (i > start && nums[i] == nums[i - 1]) {
//                    continue;
//                }
//                temp.add(nums[i]);
//                backtrack(res, temp, nums, remain - nums[i], i + 1);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }

    /**
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> list = new ArrayList<>();
       Arrays.sort(candidates);
       backtrack(list, new ArrayList<>(), candidates, target, 0);
       return list;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int index) {
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
        }
        if (remain < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remain - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
       FourZero fourZero = new FourZero();
       List<List<Integer>> a = fourZero.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);

    }
}

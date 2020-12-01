package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 13:01
 * @description: 46 permutation
 **/
public class FourSix {

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(res, new ArrayList<>(), nums);
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
//        if (temp.size() == nums.length) {
//            res.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (temp.contains(nums[i])) {
//                   continue;
//                }
//                temp.add(nums[i]);
//                backtrack(res, temp, nums);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        FourSix fourSix = new FourSix();
        List<List<Integer>> a = fourSix.permute(new int[]{1,2,3});

    }
}

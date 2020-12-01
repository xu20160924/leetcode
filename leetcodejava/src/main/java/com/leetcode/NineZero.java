package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 12:32
 * @description: 90
 **/
public class NineZero {

//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        // if nums might  contain duplicates, there must be sort for check duplicates in backtrack
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        backtrack(res, new ArrayList<>(), nums, 0);
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
//        res.add(new ArrayList<>(temp));
//        for (int i = start; i < nums.length; i++) {
//            if (i > start && nums[i] == nums[i-1]) { // skip duplicates
//                continue;
//            }
//            temp.add(nums[i]);
//            backtrack(res, temp, nums, i + 1);
//            temp.remove(temp.size() - 1);
//        }
//    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {

        res.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        NineZero nineZero = new NineZero();
        List<List<Integer>> a = nineZero.subsetsWithDup(new int[]{1,2,2});
    }
}

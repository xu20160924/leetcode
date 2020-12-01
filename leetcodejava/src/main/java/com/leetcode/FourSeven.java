package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-16 13:27
 * @description: 47
 **/
public class FourSeven {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
//        return res;
//    }
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
//        if (temp.size() == nums.length) {
//            res.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0; i < nums.length; i++) {
//                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
//                    continue;
//                }
////                if (used[i] || i > 0 && nums[i] == nums[i - 1]) {
////                    continue;
////                }
//                used[i] = true;
//                temp.add(nums[i]);
//                backtrack(res, temp, nums, used);
//                used[i] = false;
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }

//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(nums==null || nums.length==0) return res;
//        boolean[] used = new boolean[nums.length];
//        List<Integer> list = new ArrayList<Integer>();
//        Arrays.sort(nums);
//        dfs(nums, used, list, res);
//        return res;
//    }
//
//    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
//        if(list.size()==nums.length){
//            res.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for(int i=0;i<nums.length;i++){
//            if(used[i]) continue;
//            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
//            used[i]=true;
//            list.add(nums[i]);
//            dfs(nums,used,list,res);
//            used[i]=false;
//            list.remove(list.size()-1);
//        }
//    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        dfs(res, new ArrayList<>(), used, nums);
        return res;

    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, boolean[] used, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            dfs(res, temp, used, nums);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }



    /**
     *
     * Input: nums = [1,1,2]
     * Output:
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     */



    public static void main(String[] args) {
        FourSeven fourSeven = new FourSeven();
        List<List<Integer>> a = fourSeven.permuteUnique(new int[]{1,1,2});
    }
}

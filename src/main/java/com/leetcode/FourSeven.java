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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                    continue;
                }
//                if (used[i] || i > 0 && nums[i] == nums[i - 1]) {
//                    continue;
//                }
                used[i] = true;
                temp.add(nums[i]);
                backtrack(res, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        FourSeven fourSeven = new FourSeven();
        fourSeven.permuteUnique(new int[]{1,1,2});
    }
}

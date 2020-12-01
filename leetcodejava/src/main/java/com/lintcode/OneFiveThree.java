package com.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-01 15:10
 * @description: 153
 **/
public class OneFiveThree {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        Arrays.sort(num);
//        helper(num, 0, new ArrayList<>(), target, results);
        recursion(num, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void recursion(int[] num, int remainTarget, int startIndex, List<Integer> combination,
                           List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        for (int i = startIndex; i < num.length; i++) {
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            if (remainTarget < 0) {
                break;
            }
            combination.add(num[i]);
            recursion(num, remainTarget - num[i], i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
//    private void recursion(int[] num, int remainTarget, int startIndex, List<Integer> combination,
//                           List<List<Integer>> results) {
//        if (remainTarget == 0) {
//            results.add(new ArrayList<>(combination));
//            return;
//        }
//        for (int i = startIndex; i < num.length; i++) {
//            if (i != startIndex && num[i] == num[i - 1]) {
//                continue;
//            }
//            if (remainTarget < 0) {
//                break;
//            }
//            combination.add(num[i]);
//            recursion(num, remainTarget - num[i], i + 1, combination, results);
//            combination.remove(combination.size() - 1);
//        }
//    }


//    private void helper(int[] candidates, int startIndex, List<Integer> combination, int target,
//                        List<List<Integer>> results) {
//        if (target == 0) {
//            results.add(new ArrayList<>(combination));
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++) {
//            if (i != startIndex && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            if (target < candidates[i]) {
//               break;
//            }
//            combination.add(candidates[i]);
//            helper(candidates, i + 1, combination, target - candidates[i], results);
//            combination.remove(combination.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        OneFiveThree oneFiveThree = new OneFiveThree();
        oneFiveThree.combinationSum2(new int[]{7,1,2,5,1,6,10}, 8);
    }
}

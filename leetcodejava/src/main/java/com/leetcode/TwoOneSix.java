package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-12-01 08:30
 * @description: 216
 **/
public class TwoOneSix {


    /**
     * k = 3 count of number
     * n = 7 target
     * 1 ~ 9
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (list.size() > n || list.contains(i)) {
                continue;
            }
            list.add(i);
            backtrack(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TwoOneSix twoOneSix = new TwoOneSix();
        List<List<Integer>> a = twoOneSix.combinationSum3(3, 7);

    }
}

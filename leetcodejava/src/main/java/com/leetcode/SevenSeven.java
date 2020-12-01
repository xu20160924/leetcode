package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-11-19 17:37
 * @description: 77
 **/
public class SevenSeven {
    /**
     * Input: n = 4, k = 2
     * Output:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            temp.add(i);
            backtrack(res, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }



//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> combs = new ArrayList<List<Integer>>();
//        combine(combs, new ArrayList<Integer>(), 1, n, k);
//        return combs;
//    }
//    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
//        if(k==0) {
//            combs.add(new ArrayList<Integer>(comb));
//            return;
//        }
//        for(int i=start;i<=n - k + 1;i++) {
//            comb.add(i);
//            combine(combs, comb, i+1, n, k-1);
//            comb.remove(comb.size()-1);
//        }
//    }

    public static void main(String[] args) {
        SevenSeven sevenSeven = new SevenSeven();
        List<List<Integer>> a = sevenSeven.combine(4, 2);
    }
}

package com.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-11-23 21:40
 * @description: Nc42
 **/
public class NcFourTwo {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);

        backtrack(res, new ArrayList<>(), used, num);
        return res;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> res, List<Integer> temp, boolean[] used, int[] num) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && num[i] == num[i - 1] &&  !used[i - 1]) {
                continue;
            }
            temp.add(num[i]);
            used[i] = true;
            backtrack(res, temp, used, num);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        NcFourTwo ncFourTwo = new NcFourTwo();
        ArrayList<ArrayList<Integer>> a = ncFourTwo.permuteUnique(new int[]{1, 1, 2});
    }
}

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Denial.AO
 * @date: 2020-12-02 12:58
 * @description: 526
 **/
public class FiveTwoSix {
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        backtrack(visited, N, 1);
        return res;
    }

    Integer res = 0;

    private void backtrack(boolean[] visited, int n, int pos) {
        if (pos > n) {
           res++;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backtrack(visited, n, pos + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        FiveTwoSix fiveTwoSix = new FiveTwoSix();
        int a = fiveTwoSix.countArrangement(2);
    }
}

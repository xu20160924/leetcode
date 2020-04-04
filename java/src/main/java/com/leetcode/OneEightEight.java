package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-15 18:30
 * @description:
 **/
public class OneEightEight {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            return quickSolve(prices);
        }
        int[][] t = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            int tempMax = - prices[0];
            for (int j = 0; j < len; j++) {
               t[i][j] = Math.max(t[i][j - 1], prices[j] + tempMax);
               tempMax = Math.max(tempMax, t[i - 1][j -1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] = prices[i-1];
            }
        }
        return profit;
    }
}

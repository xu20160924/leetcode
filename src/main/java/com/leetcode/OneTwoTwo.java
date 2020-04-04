package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-15 11:01
 * @description:
 **/
public class OneTwoTwo {
    private int res;

//    public int maxProfit(int[] prices) {
//        return calculate(prices, 0);
//    }

//    public int calculate(int prices[], int s) {
//        if (s >= prices.length) {
//            return 0;
//        }
//        int max = 0;
//        for (int start = s; start < prices.length; start++) {
//            int maxProfit = 0;
//            for (int i = start + 1; i < prices.length; i++) {
//                if (prices[start] < prices[i]) {
//                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
//
//                    if (profit > maxProfit) {
//                        maxProfit = profit;
//                    }
//                }
//                if (maxProfit > max) {
//                    max = maxProfit;
//                }
//            }
//        }
//        return max;
//    }

//    public int maxProfit(int[] prices) {
//        int i = 0;
//        int valley = prices[0];
//        int peak = prices[0];
//        int maxProfit = 0;
//        while (i < prices.length - 1) {
//            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
//                i++;
//            }
//            valley = prices[i];
//            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
//                i++;
//            }
//            peak = prices[i];
//            maxProfit += peak - valley;
//        }
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public int bruteFroce(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, len, 0, res);
        return this.res;
    }

    /**
     *
     * @param prices stock array
     * @param index current day begin to 0
     * @param status  0 mean dont have stokc 1 mean have stock
     * @param profit current profit
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {
        if (index == len) {
            this.res = Math.max(this.res, profit);
            return;
        }

        dfs(prices, index + 1, len, status, profit);

        if (status == 0) {
            dfs(prices, index + 1, len, 1, profit - prices[index]);
        } else {
            dfs(prices, index + 1, len, 0, profit + prices[index]);
        }

    }


    /**
     * maxProfit with greed
     * @param prices
     * @return
     */
    public int maxProfitGreed(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len -1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

    /**
     * maxProfit with greed
     * @param prices
     * @return
     */
    public int maxProfitGreed2(int[] prices) {
        int res = 0;
        int len = prices.length;
        for (int i = 0; i < len - 1; i++) {
            res += Math.max(prices[i + 1] - prices[i], 0);
        }
        return res;
    }

    /**
     * maxProfit with dp
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }


    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        OneTwoTwo oneTwoTwo = new OneTwoTwo();
        System.out.println(oneTwoTwo.maxProfit(input));
    }

}

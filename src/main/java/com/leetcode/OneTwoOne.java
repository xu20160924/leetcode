package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-15 10:17
 * @description:
 **/
public class OneTwoOne {
//    public int maxProfit(int prices[]) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; i < prices.length; i++) {
//                int profit = prices[j] - prices[i];
//                if (profit > maxProfit) {
//                    maxProfit = profit;
//                }
//            }
//        }
//        return maxProfit;
//    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}

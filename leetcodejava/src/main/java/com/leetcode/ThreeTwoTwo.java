package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-11-22 11:36
 * @description: 322
 **/
public class ThreeTwoTwo {


    // memo
//    public int coinChange(int[] coins, int amount) {
//        return dp(new HashMap<>(), coins, amount);
//    }
//
//    private int dp(Map<Integer, Integer> memo, int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        if (memo.containsKey(amount)) {
//            return memo.get(amount);
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int subproblem = dp(memo, coins, amount - coin);
//            if (subproblem == -1) {
//                continue;
//            }
//            res = Math.min(res, 1 + subproblem);
//        }
//        memo.put(amount, res == Integer.MAX_VALUE ? -1 : res);
//        return memo.get(amount);
//    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // outer loop retrieve status of dp
        for (int i = 1; i < dp.length; i++) {
            // inner loop retrieve min value
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? - 1: dp[amount];
    }



    public static void main(String[] args) {
        ThreeTwoTwo threeTwoTwo = new ThreeTwoTwo();
        System.out.println(threeTwoTwo.coinChange(new int[]{2}, 3));
    }
}

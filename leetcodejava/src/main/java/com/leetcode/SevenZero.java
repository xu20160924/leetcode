package com.leetcode;

/**
 * @author: John
 * @date: 2020-05-03 20:27
 * @description: 70
 **/
public class SevenZero {


//    public int climbStairs(int n) {
//        return climbStairs(0, n);
//    }
//
//    public int climbStairs(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
//    }

//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }

    public int climbStairs(int n) {
       if (n == 1) {
           return 1;
       }
       int first = 1;
       int second = 2;
       for (int i = 3; i <= n; i++) {
           int third = first + second;
           first = second;
           second = third;
       }
       return second;
    }

    /**
     * recursion
     * @param n
     * @return
     */
//    public int climbStairs(int n) {
//        int memo[] = new int[n + 1];
//        return climbStairs(0, n, memo);
//    }
//
//    public int climbStairs(int i, int n, int memo[]) {
//        if (i > n) {
//           return 0;
//        }
//        if (i == n) {
//           return 1;
//        }
//        if (memo[i] > 0) {
//           return memo[i];
//        }
//        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
//        return memo[i];
//    }
}

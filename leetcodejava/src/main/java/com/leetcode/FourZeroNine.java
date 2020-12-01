package com.leetcode;

/**
 * @author: John
 * @date: 2020-11-23 21:21
 * @description: 409
 **/
public class FourZeroNine {
    public int longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int d = 0; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                if (s.charAt(j) == s.charAt(i)) {
                    if (d == 0 || d == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]) {
                        max = Math.max(max, d + 1);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FourZeroNine fourZeroNine = new FourZeroNine();
        int a = fourZeroNine.longestPalindrome("abccccdd");
    }
}

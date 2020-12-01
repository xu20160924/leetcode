package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-23 21:01
 * @description: Nc17
 **/
public class NcOneSeven {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int a = A.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int d = 0; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                if (A.charAt(j) == A.charAt(i)) {
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
        NcOneSeven ncOneSeven = new NcOneSeven();
        ncOneSeven.getLongestPalindrome("abc1234321ab", 12);
    }
}

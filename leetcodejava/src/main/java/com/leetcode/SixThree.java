package com.leetcode;

/**
 * @author: John
 * @date: 2020-05-03 18:15
 * @description: 63
 **/
public class SixThree {
    //    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int width = obstacleGrid[0].length;
//        int[] dp = new int[width];
//
//        dp[0] = 1;
//        for (int[] row : obstacleGrid) {
//            for (int j = 0; j < width; j++) {
//                if (row[j] == 1) {
//                    dp[j] = 0;
//                } else if (j > 0) {
//                    dp[j] += dp[j - 1];
//                }
//            }
//        }
//        return dp[width - 1];
//    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}

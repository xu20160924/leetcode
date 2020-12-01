package com.leetcode;

/**
 * @author: John
 * @date: 2020-10-01 11:16
 * @description: 221
 **/
public class TwoTwoOne {
//    public int sum = 0;
//    public int maximalSquare(char[][] matrix) {
//
//    }
//    private void bfs(char[][] matrix, int i, int j) {
//        if () {
//        }
//    }

//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//        int maxsqlen = 0;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == '1') {
//                    int sqlen = 1;
//                    boolean flag = true;
//                    while (sqlen + i < rows && sqlen + j < cols && flag) {
//                        for (int k = j; k <= sqlen + j; k++) {
//                            if (matrix[i + sqlen][k] == '0') {
//                                flag = false;
//                                break;
//                            }
//                        }
//                        for (int k = i; k <= sqlen + i; k++) {
//                            if (matrix[k][j + sqlen] == '0') {
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if (flag) {
//                            sqlen++;
//                        }
//                    }
//                    if (maxsqlen < sqlen) {
//                        maxsqlen = sqlen;
//                    }
//                }
//            }
//        }
//        return maxsqlen * maxsqlen;
//    }

//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//        int[][] dp = new int[rows + 1][ cols + 1];
//        int maxsqlen = 0;
//        for (int i = 1; i <= rows; i++) {
//            for (int j = 1; j <= cols; j++) {
//                if (matrix[i - 1][j - 1] == '1') {
//                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
//                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
//                }
//            }
//        }
//        return maxsqlen * maxsqlen;
//    }

    // one dimension array
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], prev)) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        TwoTwoOne twoTwoOne = new TwoTwoOne();
        twoTwoOne.maximalSquare(matrix);
    }

//    public int maximalSquare(char[][] matrix) {
//        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
//    }
}

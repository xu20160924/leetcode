package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-03-06 21:24
 * @description: 329
 **/
public class ThreeTwoNine {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;


    /**
     * naive dfs solution
     *
     * @param matrix
     * @return
     */
//    public int longestIncreaseingPath(int[][] matrix) {
//        if (matrix.length == 0) {
//            return 0;
//        }
//        m = matrix.length;
//        n = matrix[0].length;
//        int ans = 0;
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                ans = Math.max(ans, dfs(matrix, i, j));
//            }
//        }
//        return ans;
//    }
//
//    private int dfs(int[][] matrix, int i, int j) {
//        int ans = 0;
//        for (int[] d : dirs) {
//            int x = i + d[0], y = j + d[1];
//            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
//                ans = Math.max(ans, dfs(matrix, x, y));
//            }
//            //           dfs(matrix, i + dir[0], j);
////           dfs(matrix, i + dir[1], j);
////           dfs(matrix, i,, j + dir[0]);
////           dfs(matrix, i, j + dir[1]);
//        }
//        return ++ans;
//    }

    // DFS + Memoization Solution
//    public int longestIncreasingPath(int[][] matrix) {
//        if (matrix.length == 0) {
//            return 0;
//        }
//        m = matrix.length;
//        n = matrix[0].length;
//        int ans = 0;
//        int[][] memo = new int[m][n];
//        for (int i = 0; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                ans = Math.max(ans, dfs(matrix, i, j, memo));
//            }
//        }
//        return ans;
//    }
//    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
//        if (memo[i][j] != 0) {
//            return memo[i][j];
//        }
//        int ans = 0;
//        for (int[] d: dirs) {
//           int x = i + d[0], y = j + d[1];
//           if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j]) {
//               memo[i][j] = Math.max(ans, dfs(matrix, x, y, memo));
//           }
//        }
//        return ++memo[i][j];
//    }


    // topological sort based solution
    // an alternative solution
//    public int longestIncreasingPath(int[][] grid) {
//        int m = grid.length;
//        if (m == 0) {
//            return 0;
//        }
//        int n = grid[0].length;
//        // padding the matrix with zero as boundaries
//        // assuming all positive integer, otherwise use INT_MIN as boundaries
//        int[][] matrix = new int[m + 2][n + 2];
//        for (int i = 0; i < m; ++i) {
//            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);
//        }
//
//        // calculate outdegrees
//        int[][] outdegree = new int[m + 2][n + 2];
//        for (int i = 1; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                for (int[] d : dirs) {
//                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]]) {
//                        outdegree[i][j]++;
//                    }
//                }
//            }
//        }
//
//        // find leaves who have zero out degree as the initial level
//        n += 2;
//        m += 2;
//        List<int[]> leaves = new ArrayList<>();
//        for (int i = 1; i < m -1; ++i) {
//           for (int j = 1; j < n - 1; ++j) {
//               if (outdegree[i][j] == 0) {
//                   leaves.add(new int[]{i, j});
//               }
//           }
//        }
//
//        // remove leaves level by level in topological order
//        int height = 0;
//        while (!leaves.isEmpty()) {
//            height++;
//            List<int[]> newLeaves = new ArrayList<>();
//            for (int[] node : leaves) {
//                for (int[] d : dirs) {
//                   int x = node[0] + d[0], y = node[1] + d[1];
//                    if (matrix[node[0]][node[1]] > matrix[x][y]) {
//                        if (--outdegree[x][y] == 0) {
//                            newLeaves.add(new int[]{x, y});
//                        }
//                    }
//                }
//            }
//            leaves = newLeaves;
//        }
//        return height;
//    }

    // dp solution
    private int maxLen = 0;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a,b)->b[2] - a[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxPQ.offer(new int[]{i, j, matrix[i][j]});
            }
        }

        int[][] dp = new int[n][m];
        while (!maxPQ.isEmpty()) {
            int[] cell = maxPQ.poll();
            int i = cell[0], j = cell[1];
            dp[i][j] = 1;
            for (int[] d : dirs) {
                int newI = i + d[0], newJ = j + d[1];
                if (newI < 0 || newI >= n || newJ < 0 || newJ >= m || matrix[i][j] >= matrix[newI][newJ]) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[newI][newJ] + 1);
            }
            maxLen = Math.max(maxLen, dp[i][j]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[][] matrix = {{7, 7, 5}, {2, 4, 6}, {8, 2, 0}};
//        int[][] matrix = {{1, 2}};
        ThreeTwoNine threeTwoNine = new ThreeTwoNine();
        System.out.println(threeTwoNine.longestIncreasingPath(matrix));
    }
}

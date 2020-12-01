package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-17 16:37
 * @description: 62
 **/
public class SixTwo {

//    public int count = 0;
//
//    public int uniquePaths(int m, int n) {
//        boolean[][] used = new boolean[m][n];
//        backtrack(m-1, n-1, 0, 0, used);
//        return count;
//    }
//    private void backtrack(int m, int n, int x, int y, boolean[][] used) {
//        if (used[m][n]) {
//           count++;
//           return;
//        }
//        if (x == m || y == n) {
//            return;
//        }
//        if (!used[x][y+1]) {
//            used[x][y+1] = true;
//            backtrack(m, n, x, y+1, used);
//        }
//        if (!used[x+1][y]) {
//           used[x+1][y] = true;
//           backtrack(m, n, x+1, y, used);
//        }
//        used[x][y] = false;
//    }


//    public int uniquePaths(int m, int n) {
//        HashMap<String, Integer> visited = new HashMap<>();
//        return getAns(0, 0, m - 1, n - 1, visited);
//    }
//
//    private int getAns(int x, int y, int m, int n, HashMap<String, Integer> visited) {
//        if (x == m && y == n) {
//           return 1;
//        }
//
//        int n1 = 0;
//        int n2 = 0;
//        String key = x + 1 + "@" + y;
//        // 判断当前点是否已经求过了
//        if (!visited.containsKey(key)) {
//            if (x + 1 <= m) {
//               n1 = getAns(x + 1, y, m, n, visited);
//            }
//        } else {
//            n1 = visited.get(key);
//        }
//
//        key = x + "@" + (y + 1);
//        if (!visited.containsKey(key)) {
//            if (y + 1 <= n) {
//               n2 = getAns(x, y + 1, m, n, visited);
//            }
//        } else {
//            n2 = visited.get(key);
//        }
//        key = x + "@" + y;
//        visited.put(key, n1 + n2);
//        return n1 + n2;
//    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        // 初始化最后一列
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        // 从右向左更新所有列
        for (int i = n - 2; i >= 0; i--) {
            // 最后一行永远是1， 所以从倒数第2行开始
            // 从下向上更新所有列
            for (int j = m - 2; j >= 0; j--) {
                // 右边的和下边的更新当前的元素
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SixTwo sixTwo = new SixTwo();
        System.out.println(sixTwo.uniquePaths(3, 2));
    }
}

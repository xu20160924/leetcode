package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-17 16:37
 * @description: 62
 **/
public class SixTwo {

    public int count = 0;

    public int uniquePaths(int m, int n) {
        boolean[][] used = new boolean[m][n];
        backtrack(m-1, n-1, 0, 0, used);
        return count;
    }
    private void backtrack(int m, int n, int x, int y, boolean[][] used) {
        if (used[m][n]) {
           count++;
           return;
        }
        if (x == m || y == n) {
            return;
        }
        if (!used[x][y+1]) {
            used[x][y+1] = true;
            backtrack(m, n, x, y+1, used);
        }
        if (!used[x+1][y]) {
           used[x+1][y] = true;
           backtrack(m, n, x+1, y, used);
        }
        used[x][y] = false;
    }

    public static void main(String[] args) {
        SixTwo sixTwo = new SixTwo();
        System.out.println(sixTwo.uniquePaths(3, 2));
    }
}

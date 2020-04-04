package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-13 16:59
 * @description: 695
 **/
public class SixNineFive {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, areaOfIsLand(grid, i, j));
                }
            }
        }
        return max_area;
    }

    public int areaOfIsLand(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + areaOfIsLand(grid, i + 1, j) + areaOfIsLand(grid, i, j + 1) + areaOfIsLand(grid, i -1, j) + areaOfIsLand(grid, i, j-1);
        }
        return 0;
    }
}

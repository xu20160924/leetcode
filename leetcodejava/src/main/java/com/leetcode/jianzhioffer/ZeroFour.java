package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-04 15:38
 * @description: 04
 **/
public class ZeroFour {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length < 1 || matrix.length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

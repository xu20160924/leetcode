package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-18 20:24
 * @description: 240
 **/
public class TwoFourZero {
//    public int searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0) {
//            return 0;
//        }
//        if (matrix[0] == null || matrix[0].length == 0) {
//            return 0;
//        }
//        // from bottom left to top right
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int x = n - 1;
//        int y = 0;
//        int count = 0;
//
//        while (x >= 0 && y < m) {
//           if (matrix[x][y] < target) {
//               y++;
//           } else if (matrix[x][y] > target) {
//               x--;
//           } else {
//               count++;
//               x--;
//               y++;
//           }
//        }
//        return count;
//    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
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

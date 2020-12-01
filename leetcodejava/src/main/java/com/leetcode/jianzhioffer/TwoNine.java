package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-20 17:18
 * @description: 29
 **/
public class TwoNine {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = 1; i <= r; i++) {
                // left to right
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                // top to bottom
                res[x++] = matrix[i][r];
            }
            if (t > --b) {
                break;
            }
            for (int i = r; i >= l; i--) {
                // right to left
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                // bottom to top
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}

package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-17 10:24
 * @description: 73
 **/
public class SevenThree {

    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < C; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,1,1,1}, {1,0,1,1},{1,1,0,0},{0,0,0,1}};
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        SevenThree sevenThree = new SevenThree();
        sevenThree.setZeroes(matrix);
    }
}

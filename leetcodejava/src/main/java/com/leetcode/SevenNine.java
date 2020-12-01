package com.leetcode;

public class SevenNine {
//    public boolean exist(char[][] board, String word) {
//        char[] w = word.toCharArray();
//        for (int x = 0; x < board.length; x++) {
//            for (int y = 0; y < board[0].length; y++) {
//                return helper(board, w, 0, x, y);
//            }
//        }
//        return false;
//    }
//
//    private boolean helper(char[][] board, char[] word, int k, int x, int y) {
//        if (k == word.length) {
//            return true;
//        }
//        if (x < 0 || y < 0 || x == board.length || y == board[x].length) {
//            return false;
//        }
//
//        if (board[x][y] != word[k]) {
//            return false;
//        }
//        board[x][y] ^= 256;
//
//        boolean exist = helper(board, word, k++, x, y + 1) || helper(board, word, k++, x + 1, y) || helper(board, word, k++, x - 1, y) || helper(board, word, k++, x, y--);
//        board[x][y] ^= 256;
//        return exist;
//    }

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[i].length; j++) {
                if (helper(board, w, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] w, int i, int j, int idx) {
        if (idx == w.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
            return false;
        }
        if (board[i][j] != w[idx]) {
            return false;
        }
        board[i][j] = '*';
        boolean exist = helper(board, w, i, j + 1, idx++) || helper(board, w, i + 1, j, idx++) || helper(board, w, i - 1, j, idx++) ||helper(board, w, i, j - 1, idx++);
        board[i][j] = w[idx];
        return exist;

    }

}

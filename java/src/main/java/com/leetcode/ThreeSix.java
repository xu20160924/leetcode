package com.leetcode;

import com.sun.rowset.internal.Row;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-03-15 09:30
 * @description: 36
 **/
public class ThreeSix {
//    public boolean isValidSudoku(char[][] board) {
//        Set seen = new HashSet<>();
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] != '.') {
//                    String b = "(" + board[i][j] + ")";
//                    if (!seen.add(b + i) || !seen.add(j+b) || !seen.add(i/3 + b + j/3)) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if (board[RowIndex + j / 3][ColIndex+ j%3]!='.' && !cube.add(board[RowIndex + j /3][ColIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}

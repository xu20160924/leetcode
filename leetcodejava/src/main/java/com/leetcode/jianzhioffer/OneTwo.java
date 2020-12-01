package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-10 14:53
 * @description: 12
 **/
public class OneTwo {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }

        // 将board[i][j] 值暂存于变量tmp, 并修改为字符 '/'，代表此元素已访问过，防止之后搜索时重复访问
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1)
        || dfs(board, word, i, j + 1, k + 1)
        || dfs(board, word, i - 1, j, k + 1)
        || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }
}

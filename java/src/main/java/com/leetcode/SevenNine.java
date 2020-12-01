package com.leetcode;

/**
 * @author: John
 * @date: 2020-09-09 12:08
 * @description:
 **/
public class SevenNine {
//    public boolean exist(char[][] board, String word) {
//        char[] w = word.toCharArray();
//        for (int y = 0; y < board.length; y++) {
//            for (int x = 0; x < board[x].length; x++) {
//                if (exist(board, y, x, w, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
//        if (i == word.length) {
//            return true;
//        }
//        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
//            return false;
//        }
//        if (board[y][x] != word[i]) {
//            return false;
//        }
//        board[y][x] = '`';
//        boolean exist = exist(board, y + 1, x, word, i++) || exist(board, y, x + 1, word, i++) || exist(board, y - 1, x, word, i++) || exist(board, y, x - 1, word, i++);
//        board[y][x] = '`';
//        return exist;
//    }

//    public boolean exist(char[][] board, String word) {
//        char[] w = word.toCharArray();
//        for (int y = 0; y < board.length; y++) {
//            for (int x = 0; x < board[y].length; x++) {
//                if (exist(board, y, x, w, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean exist(char[][] board, int y, int x, char[] word, int i) {
//        if (i == word.length) {
//            return true;
//        }
//        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
//            return false;
//        }
//        if (board[y][x] != word[i]) {
//           return false;
//        }
//        board[y][x] = '`';
////        board[y][x] ^= 256;
//
////        boolean exist = exist(board, y + 1, x, word, i + 1)  || exist(board, y, x + 1, word, i + 1) || exist(board, y - 1, x, word, i + 1) || exist(board, y, x - 1, word, i + 1);
//        boolean exist = exist(board, y, x+1, word, i+1)
//                || exist(board, y, x-1, word, i+1)
//                || exist(board, y+1, x, word, i+1)
//                || exist(board, y-1, x, word, i+1);
////        board[y][x] ^= 256;
//        board[y][x] = '`';
//        return exist;
//    }

//    public boolean exist(char[][] board, String word) {
//        char[] w = word.toCharArray();
//        for (int y=0; y<board.length; y++) {
//            for (int x=0; x<board[y].length; x++) {
//                if (exist(board, y, x, w, 0)) return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
//        if (i == word.length) return true;
//        if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
//        if (board[y][x] != word[i]) return false;
//        board[y][x] ^= 256;
//        boolean exist = exist(board, y, x+1, word, i+1)
//                || exist(board, y, x-1, word, i+1)
//                || exist(board, y+1, x, word, i+1)
//                || exist(board, y-1, x, word, i+1);
//        board[y][x] ^= 256;
//        return exist;
//    }

    public boolean exist(char[][] board, String word) {
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length; j++) {
               if (exist(board, i, j, word, 0)) {
                   return true;
               }
           }
       }
       return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind) {
       if (ind == word.length()) {
           return true;
       }
       if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] != word.charAt(ind)) {
           return false;
       }
       board[i][j] = '*';
       boolean result = exist(board, i - 1, j, word, ind++) || exist(board, i, j - 1, word, ind++) || exist(board, i + 1, j, word, ind++) || exist(board, i, j + 1, word, ind++);
       board[i][j] = word.charAt(ind);
       return result;
    }


    public static void main(String[] args) {
        char[][] board = new char[3][3];
        board[0][0] = 'C';
        board[0][1] = 'A';
        board[0][2] = 'A';

        board[1][0] = 'A';
        board[1][1] = 'A';
        board[1][2] = 'A';

        board[2][0] = 'B';
        board[2][1] = 'C';
        board[2][2] = 'D';

        String word = "AAB";
        SevenNine sevenNine = new SevenNine();
        System.out.println(sevenNine.exist(board, word));
    }
}

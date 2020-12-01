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

//    public boolean exist(char[][] board, String word) {
//       for (int i = 0; i < board.length; i++) {
//           for (int j = 0; j < board[i].length; j++) {
//               if (exist(board, i, j, word, 0)) {
//                   return true;
//               }
//           }
//       }
//       return false;
//    }
//
//    private boolean exist(char[][] board, int i, int j, String word, int ind) {
//       if (ind == word.length()) {
//           return true;
//       }
//       if (i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] != word.charAt(ind)) {
//           return false;
//       }
//       board[i][j] = '*';
//       boolean result = exist(board, i - 1, j, word, ind++) || exist(board, i, j - 1, word, ind++) || exist(board, i + 1, j, word, ind++) || exist(board, i, j + 1, word, ind++);
//       board[i][j] = word.charAt(ind);
//       return result;
//    }

    //    private boolean helper(char[][] board, char[] w, int i, int j, int idx) {
//        if (idx == w.length) {
//            return true;
//        }
//        if (i < 0 || j < 0 || i == board.length || j == board[i].length) {
//            return false;
//        }
//        if (board[i][j] != w[idx]) {
//            return false;
//        }
//        board[i][j] = '*';
//        boolean exist = helper(board, w, i, j + 1, idx++) || helper(board, w, i + 1, j, idx++) || helper(board, w, i - 1, j, idx++) ||helper(board, w, i, j - 1, idx++);
//        board[i][j] = w[idx];
//        return exist;
//
//    }



    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) {
           return false;
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (dfs(board, word, 0, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        board[x][y] = '*';
        boolean flag = dfs(board, word, index + 1, x + 1, y) ||
                dfs(board, word, index + 1, x, y + 1) ||
                dfs(board, word, index + 1, x - 1, y) ||
                dfs(board, word, index + 1, x, y - 1);
        board[x][y] = word.charAt(index);
        return flag;
    }




    /**
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * Output: true
     * @param args
     */
    public static void main(String[] args) {
//        char[][] board = new char[3][3];
//        board[0][0] = 'C';
//        board[0][1] = 'A';
//        board[0][2] = 'A';
//
//        board[1][0] = 'A';
//        board[1][1] = 'A';
//        board[1][2] = 'A';
//
//        board[2][0] = 'B';
//        board[2][1] = 'C';
//        board[2][2] = 'D';
//
//        String word = "AAB";

        char[][] board = new char[4][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';


        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';


        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';


        SevenNine sevenNine = new SevenNine();
        System.out.println(sevenNine.exist(board, "SEE"));
    }
    /**
     * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     */





}

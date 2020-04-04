package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-01 21:07
 * @description: 289
 **/
public class TwoEightNine {
//    public void gameOfLife(int[][] board) {
//        int[] neighbors = {0, 1, -1};
//        int rows = board.length;
//        int cols = board[0].length;
//
//        int[][] copyBoard = new int[rows][cols];
//
//        // Create a copy of the original board
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                copyBoard[row][col] = board[row][col];
//            }
//        }
//
//        // Iterate through board cell by cell.
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                int liveNeighbors = 0;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; i++) {
//                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
//                            int r = (row + neighbors[i]);
//                            int c = (col + neighbors[j]);
//
//                            // Check the validity of the neighboring cell.
//                            // and whether it was originally a live cell.
//                            // The evaluation is done against the copy, since that is never updated
//                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (copyBoard[r][c] == 1)) {
//                                liveNeighbors += 1;
//                            }
//                        }
//                    }
//                }
//                // Rule 1 or Rule 3
//                if ((copyBoard[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
//                   board[row][col] = 0;
//                }
//                // Rule 4
//                if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
//                    board[row][col] = 1;
//                }
//            }
//        }
//    }

//    public void gameOfLife(int[][] board) {
//        //Neighbors array to find 8 neighboring cells for a given cell
//        int[] neighbors = {0, 1, -1};
//        int rows = board.length;
//        int cols = board[0].length;
//
//        //Iterate through board cell by cell
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                // For each cell count the number of live neighbors
//                int liveNeighbors = 0;
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
//                            int r = (row + neighbors[i]);
//                            int c = (col + neighbors[j]);
//
//                            // Check the validity of the neighboring cell.
//                            // and whether it was originally a live cell.
//                            if ((r < rows && r >= 0 ) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
//                                liveNeighbors += 1;
//                            }
//                        }
//                    }
//                }
//                // Rule 1 or Rule 3
//                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
//                    // -1signifies the cell is node dead but originally was live.
//                    board[row][col] = -1;
//                }
//                // Rule 4
//                if (board[row][col] == 0 && liveNeighbors == 3) {
//                    // 2 signifies the cell is now live but originally was dead.
//                    board[row][col] = 2;
//                }
//            }
//        }
//
//        // Get the final representation for the newly updated board.
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                if (board[row][col] > 0) {
//                    board[row][col] = 1;
//                } else {
//                    board[row][col] = 0;
//                }
//            }
//        }
//    }


    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1&& lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ----> 10
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
       int lives = 0;
       for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
           for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
               lives += board[x][y] & 1;
           }
       }
       lives -= board[i][j] & 1;
       return lives;
    }
}

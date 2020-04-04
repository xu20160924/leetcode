package com.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-03-29 13:20
 * @description: 994
 **/
public class NineNineFour {

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

//    public int orangesRotting(int[][] grid) {
//        int R = grid.length, C = grid[0].length;
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        Map<Integer, Integer> depth = new HashMap<>();
//        for (int r = 0; r < R; ++r) {
//            for (int c = 0; c < C; ++c) {
//               if (grid[r][c] == 2) {
//                   int code = r * C + c;
//                   queue.add(code);
//                   depth.put(code, 0);
//               }
//            }
//        }
//        int ans = 0;
//        while (!queue.isEmpty()) {
//            int code = queue.remove();
//            int r = code / C, c = code % C;
//            for (int k = 0; k < 4; k++) {
//                int nr = r + dr[k];
//                int nc = c + dc[k];
//                if (0 <= nr && nr < R && 0 <= nc && nc < C
//                    && grid[nr][nc] == 1) {
//                    grid[nr][nc] = 2;
//                    int ncode = nr * C + nc;
//                    queue.add(ncode);
//                    depth.put(ncode, depth.get(code) + 1);
//                    ans = depth.get(ncode);
//                }
//            }
//        }
//
//        for (int[] row : grid) {
//           for (int v : row) {
//               if (v == 1) {
//                   return -1;
//               }
//           }
//        }
//        return ans;
//    }

    public int orangesRotting(int[][] grid) {
        // pre check
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        // initial start
        Queue<int[]> queue = new LinkedList<>();
        int countFresh = 0;

        // put the position of all rotten oranges in queue
        // count the number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        // if count of fresh oranges is zero ——》 return 0
        if (countFresh == 0) {
            return 0;
        }
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // bfs starting from initially rotten oranges
        while (!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x < 0 || y < 0 || x >= rows || y >= cols ||
                            grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? count - 1 : -1;
    }

}

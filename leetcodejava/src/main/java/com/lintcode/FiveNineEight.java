package com.lintcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-03-29 08:59
 * @description: 598
 **/
public class FiveNineEight {
    class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    public int[] directionX = {1, 0, 0, -1};
    public int[] directionY = {0, 1, -1, 0};


//    public int zombie(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return -1;
//        }
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        // initialize the queue & count people
//        int people = 0;
//        Queue<Coordinate> queue = new LinkedList<>();
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == PEOPLE) {
//                    people++;
//                } else if (grid[i][j] == ZOMBIE) {
//                    queue.offer(new Coordinate(i, j));
//                }
//            }
//        }
//
//        // corner case
//        if (people == 0) {
//            return 0;
//        }
//
//        // bfs
//        int days = 0;
//        while (!queue.isEmpty()) {
//            days++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Coordinate zb = queue.poll();
//                for (int direction = 0; direction < 4; direction++) {
//                    Coordinate adj = new Coordinate(
//                            zb.x + directionX[direction],
//                            zb.y + directionY[direction]
//                            );
//                    if (!isPeople(adj, grid)) {
//                        continue;
//                    }
//                    grid[adj.x][adj.y] = ZOMBIE;
//                    people--;
//                    if (people == 0) {
//                        return days;
//                    }
//                    queue.offer(adj);
//                }
//            }
//        }
//        return -1;
//    }
//
//
//    private boolean isPeople(Coordinate coor, int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        if (coor.x < 0 || coor.x >= rows || coor.y < 0 || coor.y >= cols) {
//           return false;
//        }
//        return (grid[coor.x][coor.y] == PEOPLE);
//    }




//    private int zombie(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        int peopleCount = 0, days = 0;
//        int visited[][] = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (visited[i][j] == 0 && grid[i][j] == PEOPLE) {
//                    peopleCount++;
//                }
//                if (visited[i][j] == 0 && grid[i][j] == ZOMBIE) {
//                    visited[i][j] = 1;
//                    bfs(grid, i, j, peopleCount, visited);
//                    days++;
//                }
//                if (peopleCount == 0) {
//                    return days;
//                }
//            }
//        }
//        return -1;
//    }
//
//    private void bfs(int[][] grid, int x, int y, int people, int[][] visited) {
//        for (int i = 0; i < 4; i++) {
//            int nx = x + directionX[i];
//            int ny = y + directionY[i];
//            if (isPeople(nx, ny, grid)) {
//                grid[nx][ny] = ZOMBIE;
//                visited[nx][ny] = 1;
//                people--;
//            }
//        }
//    }
//
//    private boolean isPeople(int x, int y, int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        if (x < 0 || x >= rows || y < 0 || y >= cols) {
//           return false;
//        }
//        return (grid[x][y] == PEOPLE);
//    }

//    public int zombie(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int[] dx = {1, -1, 0, 0};
//        int[] dy = {0, 0, 1, -1};
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        Queue<Integer> qx = new LinkedList<>();
//        Queue<Integer> qy = new LinkedList<>();
//        boolean[][] v = new boolean[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 1) {
//                    qx.offer(i);
//                    qy.offer(j);
//                    v[i][j] = true;
//                }
//            }
//        }
//
//        int dist = 0;
//        while (!qx.isEmpty()) {
//            dist++;
//            int size = qx.size();
//            for (int i = 0; i < size; i++) {
//                int cx = qx.poll();
//                int cy = qy.poll();
//                for (int k = 0; k < 4; k++) {
//                    int nx = cx + dx[k];
//                    int ny = cy + dy[k];
//                    if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length
//                            && grid[nx][ny] == 0 && !v[nx][ny]) {
//                        qx.offer(nx);
//                        qy.offer(ny);
//                        v[nx][ny] = true;
//                    }
//                }
//            }
//        }
//        dist--;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == 0 && !v[i][j]) {
//                    return -1;
//                }
//            }
//        }
//        return dist;
//    }

    private static int minDays(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt = 0, res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    cnt++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (cnt == target) {
                return res;
            }
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length
                            && grid[ni][nj] == 0) {
                       cnt++;
                       queue.offer(new int[] {ni, nj});
                       grid[ni][nj] = 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 2, 0, 0}, {1, 0, 0, 2, 1}, {0, 1, 0, 0, 0}};
//        FiveNineEight fiveNineEight = new FiveNineEight();
//        System.out.println(fiveNineEight.zombie(grid));
    }
}

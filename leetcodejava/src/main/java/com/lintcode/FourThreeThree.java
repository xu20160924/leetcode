package com.lintcode;

/**
 * @author: John
 * @date: 2020-03-28 12:48
 * @description: 433
 **/
public class FourThreeThree {
//    class Coordinate {
//        int x, y;
//
//        public Coordinate(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public int numIslands(boolean[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int n = grid.length;
//        int m = grid[0].length;
//        int isLands = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j]) {
//                    bfs(grid, i, j);
//                    isLands++;
//                }
//            }
//        }
//        return isLands;
//    }
//
//    private void bfs(boolean[][] grid, int x, int y) {
//        int[] directionX = {0, 1, -1, 0};
//        int[] directionY = {1, 0, 0, -1};
//
//        Queue<Coordinate> queue = new LinkedList<>();
//        queue.offer(new Coordinate(x, y));
//        grid[x][y] = false;
//
//        while (!queue.isEmpty()) {
//            Coordinate coor = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                Coordinate adj = new Coordinate(coor.x + directionX[i], coor.y + directionY[i]);
//                if (!isBound(adj, grid)) {
//                    continue;
//                }
//                if (grid[adj.x][adj.y]) {
//                    grid[adj.x][adj.y] = false;
//                    queue.offer(adj);
//                }
//            }
//        }
//    }

//    private boolean isBound(Coordinate coor, boolean[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
//    }

    class UnionFind {
        private int[] father = null;
        private int count;

        private int find(int x) {
            if (father[x] == x) {
                return x;
            }
            return father[x] = find(father[x]);
        }

        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }

        public int query() {
            return count;
        }

        public void setCount(int total) {
            count = total;
        }
    }

    public int numIslands(boolean[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        if (grid == null || n == 0 || m == 0) {
            return 0;
        }

        UnionFind uf = new UnionFind(n * m);
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    total++;
                }
            }
        }
        uf.setCount(total);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        uf.connect(i * m + j, (i - 1) * m + j);
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        uf.connect(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        uf.connect(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        uf.connect(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return uf.query();
    }

}

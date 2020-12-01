package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-02-13 12:48
 * @description: 200
 **/
public class TwoZeroZero {
//    int[][] distance = {{1,0},{0,1}};
//    public int numIslands(char[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        UF uf = new UF(grid);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    for (int [] d: distance) {
//                        int x = i+d[0];
//                        int y = j+d[1];
//                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
//                            int id1 = i*m+j;
//                            int id2 = x*m+y;
//                            uf.union(id1, id2);
//                        }
//                    }
//                }
//            }
//        }
//        return uf.count;
//    }
//
//    class UF {
//        int[] parent;
//        int[] rank;
//        int count = 0;
//
//        UF(char[][] grid) {
//            int m = grid.length;
//            int n = grid[0].length;
//            parent = new int[m*n];
//            rank = new int[m*n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (grid[i][j] == '1') {
//                        parent[i * n + j] = i * n + j;
//                        rank[i * n + j] = 0;
//                        count++;
//                    }
//                }
//            }
//        }
//
//        void union(int x, int y) {
//            int i = find(x);
//            int j = find(y);
//            if (i==j) {
//                return;
//            }
//            if (rank[i] > rank[j]) {
//                parent[i] = parent[j];
//            } else if (rank[i] < rank[j]) {
//                parent[j] = parent[i];
//            } else {
//                parent[j] = parent[i];
//                rank[i]++;
//            }
//            count--;
//        }
//        int find(int x) {
//            if (x != parent[x]) {
//                parent[x] = find(parent[x]);
//            }
//            return parent[x];
//        }
//        boolean connected(int x, int y) {
//            return find(x) == find(y);
//        }
//    }


//    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
//            return 0;
//        }
//        UnionFind uf = new UnionFind(grid);
//        int rows = grid.length;
//        int cols = grid[0].length;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (grid[i][j] == '1') {
//                    for (int[] d : distance) {
//                        int x = i + d[0];
//                        int y = j + d[1];
//                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
//                            int id1 = i*cols+j;
//                            int id2 = x*cols+y;
//                            uf.union(id1, id2);
//                        }
//                    }
//                }
//            }
//        }
//        return uf.count;
//    }
//
//    class UnionFind {
//        int[] father;
//        int m, n;
//        int count = 0;
//        UnionFind(char[][] grid) {
//            m = grid.length;
//            n = grid[0].length;
//            father = new int[m*n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (grid[i][j] == '1') {
//                        int id = i * n + j;
//                        father[id] = id;
//                        count++;
//                    }
//                }
//            }
//        }
//        public void union(int node1, int node2) {
//            int find1 = find(node1);
//            int find2 = find(node2);
//            if(find1 != find2) {
//                father[find1] = find2;
//                count--;
//            }
//        }
//        public int find (int node) {
//            if (father[node] == node) {
//                return node;
//            }
//            father[node] = find(father[node]);
//            return father[node];
//        }
//    }

//    int[] par;
//    int count = 0;
//    public int numIslands(char[][] a) {
//        if (a.length == 0) {
//            return 0;
//        }
//        int n = a.length, m = a[0].length;
//        par = new int[n*m];
//        Arrays.fill(par, -1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (a[i][j] ==  '1') {
//                    par[i*m+j] = i*m+j;
//                    count++;
//                    if (i > 0 && a[i-1][j] == '1') {
//                        union(i*m+j, (i-1)*m+j);
//                    }
//                    if (j > 0 && a[i][j-1] == '1') {
//                        union(i*m+j, i*m+(j-1));
//                    }
//                }
//            }
//        }
//        return count;
//    }
//
//    int find(int x) {
//        if (x != par[x]) {
//            par[x] = find(par[x]);
//        }
//        return par[x];
//    }
//
//    void union(int x, int y) {
//        int id1 = find(x);
//        int id2 = find(y);
//        if (id1 != id2) {
//            par[id1] = par[id2];
//            count--;
//        }
//    }

//    private int n;
//    private int m;
//
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        n = grid.length;
//        if (n == 0) {
//            return 0;
//        }
//        m = grid[0].length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    DFSMarking(grid, i, j);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    private void DFSMarking(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
//            return;
//        }
//        grid[i][j] = '0';
//        DFSMarking(grid, i - 1, j);
//        DFSMarking(grid, i, j - 1);
//        DFSMarking(grid, i + 1, j);
//        DFSMarking(grid, i, j + 1);
//
//    }


//    private int n;
//    private int m;
//    public int numIslands(char[][] grid) {
//        int count = 0;
//        n = grid.length;
//        if (n == 0) {
//            return 0;
//        }
//        m = grid[0].length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == '1') {
//                    DFSMarking(grid, i, j);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//    private void DFSMarking(char[][] grid, int i, int j) {
//        if (i < 0 || j< 0 || i >= n || j>= m || grid[i][j] !='1') {
//            return;
//        }
//        grid[i][j] = '0';
//        DFSMarking(grid, i - 1, j);
//        DFSMarking(grid, i, j -1);
//        DFSMarking(grid, i+1, j);
//        DFSMarking(grid, i, j+1);
//    }

    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = i + d[1];
                        if (x >= 0 && x < rows & y >= 0 && y < cols && grid[x][y] == '1') {
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

    class UnionFind {
        int[] father;
        int m, n;
        int count = 0;
        UnionFind(char[][] grid) {
           m = grid.length;
           n = grid[0].length;
           father = new int[m*n];
           for (int i = 0; i < m; i++) {
               for (int j = 0; j < n; j++) {
                  if (grid[i][j] == '1') {
                      int id = i * n + j;
                      father[id] = id;
                      count++;
                  }
               }
           }
        }

        public int find(int node) {
            if (father[node] == node) {
               return node;
            }
            father[node] = find(father[node]);
            return father[node];
        }

        public void union(int node1, int node2) {
            int find1 = find(father[node1]);
            int find2 = find(father[node2]);
            if (find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
    }


    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        TwoZeroZero twoZeroZero = new TwoZeroZero();
        System.out.println(twoZeroZero.numIslands(grid));
    }
}

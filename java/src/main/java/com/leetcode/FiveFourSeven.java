package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-02-07 17:46
 * @description: 547
 **/
public class FiveFourSeven {

    /**
     * dfs
     * @param M
     * @param visited
     * @param i
     */
//    public static void dfs(int[][] M, int[] visited, int i) {
//        for (int j = 0; j < M.length; j++) {
//            if (M[i][j] == 1 && visited[j] == 0) {
//                visited[j] = 1;
//                dfs(M, visited, j);
//            }
//        }
//    }
//
//    public static int findCircleNum(int[][] M) {
//        int[] visited = new int[M.length];
//        int count = 0;
//        for (int i = 0; i < M.length; i++) {
//            if (visited[i] == 0) {
//                dfs(M, visited, i);
//                count++;
//            }
//        }
//        return count;
//    }

    /**
     * bfs
     */
//    public static int findCircleNum(int[][] M) {
//        int[] visited = new int[M.length];
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i = 0; i < M.length; i++) {
//            if (visited[i] == 0) {
//                queue.add(i);
//                while(!queue.isEmpty()) {
//                    int s = queue.remove();
//                    visited[s] = 1;
//                    for (int j = 0; j < M.length; j++) {
//                        if (M[s][j] == 1 && visited[j] == 0) {
//                            queue.add(j);
//                        }
//                    }
//                }
//                count++;
//            }
//        }
//        return count;
//    }

    int find(int parent[], int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset) {
            parent[xset] = yset;
        }
    }

    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }



    public static void main(String[] args) {
        int[][] nums = {{1,1,0}, {1,1,0}, {0,0,1}};
//        int[][] nums = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1},{1,0,1,1}};
        FiveFourSeven solution = new FiveFourSeven();
        System.out.println(solution.findCircleNum(nums));
    }

}

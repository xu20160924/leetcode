package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-10 19:29
 * @description: 13
 **/
public class OneThree {
    int m, n, k;
    boolean[][] visited;

    /**
     * dfs
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) +
                dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }


    //    public int movingCount(int m, int n, int k) {
//        boolean[][] visited = new boolean[m][n];
//        int res = 0;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[] {0, 0, 0, 0});
//        while (queue.size() > 0) {
//            int[] x = queue.poll();
//            int i = x[0], j = x[1], si = x[2], sj = x[3];
//            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
//                continue;
//            }
//            visited[i][j] = true;
//            res++;
//            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
//            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
//        }
//        return res;
//    }
    public static void main(String[] args) {
        OneThree oneThree = new OneThree();
        System.out.println(oneThree.movingCount(20, 20, 9));
        System.out.println(oneThree.movingCount(20, 13, 9));
    }
}

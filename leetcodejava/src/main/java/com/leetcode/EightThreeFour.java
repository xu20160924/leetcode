package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-10-16 10:39
 * @description: 834
 **/
public class EightThreeFour {
//    int[] ans, count;
//    List<Set<Integer>> graph;
//    int N;
//    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        this.N = N;
//        graph = new ArrayList<>();
//        ans = new int[N];
//        count = new int[N];
//        Arrays.fill(count, 1);
//
//        for (int i = 0; i < N; ++i) {
//            graph.add(new HashSet<>());
//        }
//        for (int[]  edge : edges) {
//            graph.get(edge[0]).add(edge[1]);
//            graph.get(edge[1]).add(edge[0]);
//        }
//        dfs(0, - 1);
////        dfs2(0, -1);
//        return ans;
//    }
//
//    private void dfs(int node, int parent) {
//        for (int child : graph.get(node)) {
//            if (child != parent) {
//                dfs(child, node);
//                count[node] += count[child];
//                ans[node] += ans[child] + count[child];
//            }
//        }
//    }

//    private void dfs2(int node, int parent) {
//        for (int child : graph.get(node)) {
//            if (child != parent) {
//                ans[child] = ans[node] - count[child] + N - count[child];
//                dfs2(child, node);
//            }
//        }
//    }

//    int[] result = new int[N];
//    int[] count = new int[N];
//    int[] result, count;
//    List<Set<Integer>> graph = new ArrayList<>();
//    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        result = new int[N];
//        count = new int[N];
//        Arrays.fill(count, 1);
//        for (int i = 0; i < N; i++) {
//            graph.add(new HashSet<>());
//        }
//        for (int[] edge : edges) {
//            graph.get(edge[0]).add(edge[1]);
//            graph.get(edge[1]).add(edge[0]);
//        }
////        helper(1, 0);
//
//        for (int[] edge : edges) {
//            helper(edge[1], edge[0]);
//        }
//        return result;
//    }
//
//    private void helper(int node, int parent) {
//        for (int child : graph.get(node)) {
//            if (child != parent) {
//                helper(child, node);
//                count[node] += count[child];
//                result[node] += result[child] + count[child];
//            }
//            if (child == parent) {
//                System.out.println("sdafasd");
//            }
//        }
//    }

//    int[] res, count;
//    List<Set<Integer>> tree;
//
//    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        tree = new ArrayList<>();
//        res = new int[N];
//        count = new int[N];
//        for (int i = 0; i < N; i++) {
//            tree.add(new HashSet<>());
//        }
//        for (int[] e : edges) {
//            tree.get(e[0]).add(e[1]);
//            tree.get(e[1]).add(e[0]);
//        }
//    }

    //    int[] res, count;
//    List<Set<Integer>> tree;
//
//    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        tree = new ArrayList<>();
//        res = new int[N];
//        count = new int[N];
//        for (int i = 0; i < N; i++) {
//            tree.add(new HashSet<>());
//        }
//        for (int[] e : edges) {
//            tree.get(e[0]).add(e[1]);
//            tree.get(e[1]).add(e[0]);
//        }
////        for (int[] edge : edges) {
////            dfs(edge[0], edge[1]);
////           1 dfs(edge[1], edge[0]);
////        }
//
//        dfs(0, -1);
//
//        return res;
//    }
//
//    private void dfs(int root, int pre) {
//        for (int i : tree.get(root)) {
//            if (i == pre) {
//                continue;
//            }
//            dfs(i, root);
//            count[root] += count[i];
//            res[root] += res[i] + count[i];
//        }
//        count[root]++;
//    }
//






//    int[] res, count;
//    ArrayList<HashSet<Integer>> tree;
//    public int[] sumOfDistancesInTree(int N, int[][] edges) {
//        tree = new ArrayList<HashSet<Integer>>();
//        res = new int[N];
//        count = new int[N];
//        for (int i = 0; i < N ; ++i)
//            tree.add(new HashSet<Integer>());
//        for (int[] e : edges) {
//            tree.get(e[0]).add(e[1]);
//            tree.get(e[1]).add(e[0]);
//        }
//        dfs(0, -1);
//        dfs2(0,-1);
////        dfs(1, 0);
////        dfs(2, 0);
////        dfs(3, 2);
////        dfs(4, 2);
////        dfs(5, 2);
//
//
//
////        dfs2(0, -1);
//        return res;
//    }
//
//    public void dfs(int root, int pre) {
//        for (int i : tree.get(root)) {
//            if (i == pre) continue;
//            dfs(i, root);
//            count[root] += count[i];
//            res[root] += res[i] + count[i];
//        }
//        count[root]++;
//    }
//
//    private void dfs2(int root, int pre) {
//        for (int i : tree.get(root)) {
//            if (i == pre) {
//                continue;
//            }
//            res[i] = res[root] - count[i] + count.length - count[i];
//            dfs2(i, root);
//        }
//    }


    int[] res, count;
    List<Set<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[N];
        count = new int[N];

        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);
        return res;

    }

    private void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) {
                continue;
            }
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }
    private void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) {
                continue;
            }
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }








//
//    private void dfs2(int root, int pre) {
//        for (int i : tree.get(root)) {
//
//        }
//    }


    public static void main(String[] args) {
        EightThreeFour eightThreeFour = new EightThreeFour();
        int[] a = eightThreeFour.sumOfDistancesInTree(6, new int[][]{{0,1}, {0,2}, {2,3}, {2,4}, {2,5}});
        System.out.println("");
    }


}

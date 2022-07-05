package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Denial.AO
 * @date: 2020-12-03 16:57
 * @description: 797
 **/
public class SevenNineSeven {
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        if (graph == null) {
//            return new LinkedList<>();
//        }
//
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < graph.length; i++) {
//
//            Queue<int[]> queue = new LinkedList<>();
//            queue.offer(graph[i]);
//
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                List<Integer> list = res.get(i);
//                if () {
//
//                }
//            }
//        }
//    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        // begin from zero
        path.add(0);
        dfs(graph, 0, res, path);
        return res;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SevenNineSeven sevenNineSeven = new SevenNineSeven();

    }
}

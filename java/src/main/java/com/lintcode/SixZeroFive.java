package com.lintcode;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-27 20:34
 * @description: 605
 **/
public class SixZeroFive {

//    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        Map<Integer, Integer> indegree = new HashMap<>();
//
//        for (int num : org) {
//            map.put(num, new HashSet<>());
//            indegree.put(num, 0);
//        }
//
//        int n = org.length;
//        int count = 0;
//        for (int[] seq : seqs) {
//            count += seq.length;
//            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
//                return false;
//            }
//            for (int i = 1; i < seq.length; i++) {
//                if (seq[i] <= 0 || seq[i] > n) {
//                   return false;
//                }
//                if (map.get(seq[i - 1]).add(seq[i])) {
//                   indegree.put(seq[i], indegree.get(seq[i]) + 1);
//                }
//            }
//        }
//
//        if (count < n) {
//           return false;
//        }
//        Queue<Integer> queue = new ArrayDeque<>();
//        for (int key : indegree.keySet()) {
//            if (indegree.get(key) == 0) {
//               queue.add(key);
//            }
//        }
//        int cnt = 0;
//        while (queue.size() == 1) {
//            int element = queue.poll();
//            for (int next : map.get(element)) {
//                indegree.put(next, indegree.get(next) - 1);
//                if (indegree.get(next) == 0) {
//                    queue.add(next);
//                }
//            }
//            if (element != org[cnt]) {
//                return false;
//            }
//            cnt++;
//        }
//        return cnt == org.length;
//    }

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        // build up the map
        for (int[] seq : seqs) {
            for (int i = 0; i < seq.length; i++) {
                graph.putIfAbsent(seq[i], new ArrayList<>());
                indegree.putIfAbsent(seq[i], 0);
                if (i > 0) {
                    graph.get(seq[i - 1]).add(seq[i]);
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }

        int index = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (org[index++] != cur) {
                return false;
            }
            for (int neighbor : graph.get(cur)) {
               indegree.put(neighbor, indegree.get(neighbor) - 1);
               if (indegree.get(neighbor) == 0) {
                   queue.add(neighbor);
               }
            }
        }
        return index == org.length;
    }


}

package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-02-25 16:09
 * @description: 210
 **/
public class TwoOneZero {
//    static int WHITE = 1;
//    static int GRAY = 2;
//    static int BLACK = 3;
//    boolean isPossible;
//    Map<Integer, Integer> color;
//    Map<Integer, List<Integer>> adjList;
//    List<Integer> topologicalOrder;
//    private void init(int numCourses) {
//        this.isPossible = true;
//        this.color = new HashMap<>();
//        this.adjList = new HashMap<>();
//        this.topologicalOrder = new ArrayList<>();
//        for (int i = 0; i < numCourses; i++) {
//            this.color.put(i, WHITE);
//        }
//    }
//
//    private void dfs(int node) {
//         if (!this.isPossible) {
//             return;
//         }
//         this.color.put(node, GRAY);
//         for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
//             if (this.color.get(neighbor) == WHITE) {
//                 this.dfs(neighbor);
//             } else if (this.color.get(neighbor) == GRAY) {
//                this.isPossible = false;
//             }
//         }
//         this.color.put(node, BLACK);
//         this.topologicalOrder.add(node);
//    }
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        this.init(numCourses);
//        for (int i = 0; i < prerequisites.length; i++) {
//            int dest = prerequisites[i][0];
//            int src  = prerequisites[i][1];
//            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
//            lst.add(dest);
//            adjList.put(src, lst);
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            if (this.color.get(i) == WHITE) {
//                this.dfs(i);
//            }
//        }
//        int[] order;
//        if (this.isPossible) {
//            order = new int[numCourses];
//            for (int i = 0; i < numCourses; i++) {
//                order[i] = this.topologicalOrder.get(numCourses - i - 1);
//            }
//        }  else {
//            order = new int[0];
//        }
//        return order;
//    }

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] incLinkCounts = new int[numCourses];
//        List<List<Integer>> adjs = new ArrayList<>();
//
//    }
//
//    private void initialliseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
//        int n = incLinkCounts.length;
//        while (n-- > 0) {
//            adjs.add(new ArrayList<>());
//        }
//        for (int[] edge : prerequisites) {
//            incLinkCounts[edge[0]]++;
//            adjs.get(edge[1]).add(edge[0]);

//        }
//    }
//

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] incLinkCounts = new int[numCourses];
//        List<List<Integer>> adjs = new ArrayList<>(numCourses);
//        initialiseGraph(incLinkCounts, adjs, prerequisites);
//        return solveByDFS(adjs);
//    }
//
//    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites) {
//        int n = incLinkCounts.length;
//        while (n-- > 0) {
//            adjs.add(new ArrayList<>());
//        }
//        for (int[] edge : prerequisites) {
//            incLinkCounts[edge[0]]++;
//            adjs.get(edge[1]).add(edge[0]);
//        }
//    }
//
//    private int[] solveByDFS(List<List<Integer>> adjs) {
//        BitSet hasCycle = new BitSet(1);
//        BitSet visited = new BitSet(adjs.size());
//        BitSet onStack = new BitSet(adjs.size());
//        Deque<Integer> order = new ArrayDeque<>();
//        for (int i = adjs.size() - 1; i >= 0; i--) {
//            if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) {
//                return new int[0];
//            }
//        }
//        int[] orderArray = new int[adjs.size()];
//        for (int i = 0; !order.isEmpty(); i++) {
//            orderArray[i] = order.pop();
//        }
//        return orderArray;
//    }
//    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
//       visited.set(from);
//       onStack.set(from);
//       for (int to : adjs.get(from)) {
//           if (visited.get(to) == false) {
//               if (hasOrder(to, adjs, visited, onStack, order) == false) {
//                    return false;
//               }
//           } else if (onStack.get(to) == true) {
//                return false;
//           }
//       }
//       onStack.clear(from);
//       order.push(from);
//       return true;
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);

            indegree[dest] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }
        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        int[][] courses = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] prerequisites = {{1, 0}};

        TwoOneZero twoOneZero = new TwoOneZero();
        twoOneZero.findOrder(2, prerequisites);

    }
}

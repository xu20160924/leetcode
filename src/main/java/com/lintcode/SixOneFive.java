package com.lintcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-28 09:33
 * @description: 615
 **/
public class SixOneFive {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        // write your code here
//        if (numCourses == 0) {
//            return false;
//        }
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < numCourses; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        int[] indegree = new int[numCourses];
//        for (int i = 0; i < prerequisites.length; i++) {
//            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
//            indegree[prerequisites[i][0]]++;
//        }
//        for (int i = 0; i < numCourses; i++) {
//            int j = 0;
//            for (; j < numCourses; j++) {
//                if (indegree[j] == 0) {
//                    break;
//                }
//            }
//            if (j == numCourses) {
//                return false;
//            }
//            indegree[j]--;
//            for (int v : graph.get(j)) {
//                indegree[v]--;
//            }
//        }
//        return true;
//    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
           degree[prerequisites[i][0]]++;
           edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
           if (degree[i] == 0) {
               queue.add(i);
           }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int pointer = (int) edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }
        return count == numCourses;
    }


    public static void main(String[] args) {
        int[][] prerequisites = new int[8][2];
        prerequisites[0][0] = 5;
        prerequisites[0][1] = 8;

        prerequisites[1][0] = 3;
        prerequisites[1][1] = 5;

        prerequisites[2][0] = 1;
        prerequisites[2][1] = 9;

        prerequisites[3][0] = 4;
        prerequisites[3][1] = 5;

        prerequisites[4][0] = 0;
        prerequisites[4][1] = 2;

        prerequisites[5][0] = 1;
        prerequisites[5][1] = 9;

        prerequisites[6][0] = 7;
        prerequisites[6][1] = 8;

        prerequisites[7][0] = 4;
        prerequisites[7][1] = 9;



        SixOneFive sixOneFive = new SixOneFive();
        System.out.println(sixOneFive.canFinish(10, prerequisites));
    }
}

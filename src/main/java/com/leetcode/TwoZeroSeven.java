package com.leetcode;

import java.util.LinkedList;

/**
 * @author: John
 * @date: 2020-02-25 11:54
 * @description: 207
 **/
public class TwoZeroSeven {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] req: prerequisites) {
                if (req[1] != pre) {
                    continue;
                }
                if (--indegrees[req[0]] == 0) {
                    queue.add(req[0]);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 0}, {0, 1}};
        TwoZeroSeven twoZeroSeven = new TwoZeroSeven();
        twoZeroSeven.canFinish(2, nums);
    }
}

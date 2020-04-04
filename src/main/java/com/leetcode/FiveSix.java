package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-17 13:29
 * @description: 56
 **/
public class FiveSix {
//    private Map<int[], List<int[]>> graph;
//    private Map<Integer, List<int[]>> nodesInComp;
//    private Set<int[]> visited;
//
//    // return whether two intervals overlap (inclusive)
//    private boolean overlap(int[] a, int[] b) {
//        return a[0] <= b[1] && b[0] <= a[1];
//    }
//
//    // build a graph where an undirected edge between intervals u and v exists
//    // if u and v overlap
//    private void buildGraph(int[][] intervals) {
//        graph = new HashMap<>();
//        for (int[] interval : intervals) {
//            graph.put(interval, new LinkedList<>());
//        }
//
//        for (int[] interval1 : intervals) {
//            for (int[] interval2 : intervals) {
//                if (overlap(interval1, interval2)) {
//                    graph.get(interval1).add(interval2);
//                    graph.get(interval2).add(interval1);
//                }
//            }
//        }
//    }
//
//    // merge all of the nodes in this connected component into one interval
//    private int[] mergeNodes(List<int[]> nodes) {
//        int minStart = nodes.get(0)[0];
//        for (int[] node : nodes) {
//           minStart = Math.min(minStart, node[0]);
//        }
//        int maxEnd = nodes.get(0)[1];
//        for (int[] node : nodes) {
//           maxEnd = Math.max(maxEnd, node[1]);
//        }
//        return new int[] {minStart, maxEnd};
//    }
//
//    // use depth-first search to mark all nodes in the same connected Component
//    // with the same integer.
//    private void markComponentDFS(int[] start, int compNumber) {
//        Stack<int[]> stack = new Stack<>();
//        stack.add(start);
//        while (!stack.isEmpty()) {
//            int[] node = stack.pop();
//            if (!visited.contains(node)) {
//               visited.add(node);
//                if (nodesInComp.get(compNumber) == null) {
//                    nodesInComp.put(compNumber, new LinkedList<>());
//                }
//                nodesInComp.get(compNumber).add(node);
//                for (int[] child : graph.get(node)) {
//                   stack.add(child);
//                }
//            }
//        }
//    }

//    private class IntervalComparator implements Comparator<int[]> {
//
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            return o1[0] < o2[0] ? -1 : o1[0] == o2[0] ? 0 : 1;
//        }
//
//        public int[][] merge(int[][] intervals) {
//            Collections.sort(Arrays.asList(intervals), new IntervalComparator());
//            LinkedList<int[]> merged = new LinkedList<>();
//            for (int[] interval : intervals) {
//                // if the list of merged intervals is empty or if the current
//                // interval does ot overlap with previous, simply append it
//                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
//                    merged.add(interval);
//                }
//                // otherwise, there is overlap, so we merge the current and previous and intervals
//                else {
//                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
//                }
//            }
//            return merged.toArray(new int[merged.size()][]);
//        }
//    }

//    public int[][] merge(int[][] intervals) {
//        if (intervals.length <= 1) {
//            return intervals;
//        }
//        // Sort by ascending starting point
//        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
//        List<int[]> result = new ArrayList<>();
//        int[] newInterval = intervals[0];
//        result.add(newInterval);
//        for (int[] interval : intervals) {
//            if (interval[0] <= newInterval[1]) { //overlapping intervals, move the end if needed
//                newInterval[1] = Math.max(newInterval[1], interval[1]);
//            } else { // Disjoint intervals, add the new interval to the list
//                newInterval = interval;
//                result.add(newInterval);
//            }
//        }
//        return result.toArray(new int[result.size()][]);
//    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[0] = Math.max(interval[1], newInterval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3}, {2,6}, {8,10}, {15,18}};
        FiveSix fiveSix = new FiveSix();
        fiveSix.merge(matrix);
    }
}

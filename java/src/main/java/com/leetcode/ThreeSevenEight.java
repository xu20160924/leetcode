package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-03-04 08:25
 * @description: 378
 **/
public class ThreeSevenEight {

    // Binary search
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
               lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


//    public int kthSmallest(int[][] matrix, int k) {
//        // num of rows and cols in matrix
//        int rows = matrix.length, cols = matrix[0].length;
//        // get the lowest and highest possible num, will shrink search space according to the two nums
//        // [lo, hi] is our initial search range
//        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1];
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int count = 0, maxNum = lo;
//            // for each row, we are going to find #of nums < mid in that row
//            for (int r = 0, c = cols - 1; r < rows; r++) {
//                while (c >= 0 && matrix[r][c] > mid) {
//                    c--; // this row's c has to be smaller than the c found in last row due to the sorted property of the matrix
//                }
//            }
//            // adjust search range
//            if (count == k) {
//                return maxNum;
//            } else if (count < k) {
//               lo = mid + 1;
//            } else {
//                hi = mid - 1;
//            }
//        }
//        // 1) Q: Why we return lo at the end:
//        //    A: Here lo=hi+1, for hi, we found <k elems, for lo, we found >=k elem, lo must have duplicates in matrix, return lo
//        // 2) Q: Why lo exist in the matrix
//        //    A: for lo which is only 1 more than hi, we could find some extra nums in matrix so that there r >=k elems, so lo it self must exist in the matrix to meet the requirement
//        return lo;
//    }



    // min heap
//    public int KthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        PriorityQueue<Tuple> pq = new PriorityQueue<>();
//        for (int j = 0; j <= n - 1; j++) {
//            pq.offer(new Tuple(0, j, matrix[0][j]));
//        }
//        for (int i = 0; i < k - 1; i++) {
//            Tuple t = pq.poll();
//            if (t.x == n - 1) {
//                continue;
//            }
//            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
//        }
//        return pq.poll().val;
//    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        ThreeSevenEight threeSevenEight = new ThreeSevenEight();
        threeSevenEight.kthSmallest(matrix, 2);
    }
}

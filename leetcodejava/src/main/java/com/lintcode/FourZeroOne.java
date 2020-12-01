package com.lintcode;

import java.util.PriorityQueue;

/**
 * @author: John
 * @date: 2020-04-27 11:41
 * @description: 401
 **/
public class FourZeroOne {
//    public int kthSmallest(int[][] matrix, int k) {
//        // write your code here
//        if (matrix == null || matrix.length <= 1) {
//            return -1;
//        }
//
//        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
//
//        for (int i = 0; i <= matrix.length - 1; i++) {
//            pq.offer(new Tuple(0, i, matrix[0][i]));
//        }
//
//        for (int i = 0; i < k - 1; i++) {
//            Tuple t = pq.poll();
//            if (t.x == matrix.length - 1) {
//                continue;
//            }
//            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
//        }
//        return pq.poll().value;
//    }
//
//    class Tuple implements Comparable<Tuple> {
//        int x, y, value;
//
//        public Tuple(int x, int y, int value) {
//            this.x = x;
//            this.y = y;
//            this.value = value;
//        }
//
//        @Override
//        public int compareTo(Tuple t) {
//            return this.value - t.value;
//        }
//    }


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for (int j = 0; j <= m - 1; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == n - 1) {
                continue;
            }
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;

    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[7][];
        int[] m1 = new int[]{1};
        int[] m2 = new int[]{2};
        int[] m3 = new int[]{3};
        int[] m4 = new int[]{100};
        int[] m5 = new int[]{101};
        int[] m6 = new int[]{1000};
        int[] m7 = new int[]{9999};
        matrix[0] = m1;
        matrix[1] = m2;
        matrix[2] = m3;
        matrix[3] = m4;
        matrix[4] = m5;
        matrix[5] = m6;
        matrix[6] = m7;


//        int[][] matrix = new int[3][];
//        int[] m1 = new int[]{1, 5, 7};
//        int[] m2 = new int[]{3, 7, 8};
//        int[] m3 = new int[]{4, 8, 9};
//        matrix[0] = m1;
//        matrix[1] = m2;
//        matrix[2] = m3;


        FourZeroOne fourZeroOne = new FourZeroOne();
        System.out.println(fourZeroOne.kthSmallest(matrix, 4));
    }
}

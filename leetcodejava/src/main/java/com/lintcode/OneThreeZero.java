package com.lintcode;

/**
 * @author: John
 * @date: 2020-04-17 12:32
 * @description: 130
 **/
public class OneThreeZero {
    private void siftDown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
               son = k * 2 + 2;
            }
            if (A[son] >= A[k]) {
                break;
            }

            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    public void heapify(int[] A) {
       for (int i = (A.length - 1) / 2; i >= 0; i--) {
           siftDown(A, i);
       }
        System.out.println("");
    }

    public static void main(String[] args) {
        OneThreeZero oneThreeZero = new OneThreeZero();
        oneThreeZero.heapify(new int[]{3,2,1,4,5});
    }
}

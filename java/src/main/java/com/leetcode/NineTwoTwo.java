package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-06 10:31
 * @description: 922
 **/
public class NineTwoTwo {
//    public static int[] sortArrayByParity(int[] A) {
//        int[] res = new int[A.length];
//        int j = 0, k = 1;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] % 2 == 0) {
//                res[j] = A[i];
//                j += 2;
//            } else {
//                res[k] = A[i];
//                k += 2;
//            }
//        }
//        return res;
//    }

    public static int[] sortArrayByParity(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                     j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}

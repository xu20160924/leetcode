package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-06 09:23
 * @description: 905
 **/
public class NineZeroFive {

    public static int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[j] % 2 == 0) {
                i++;
            }
            if (A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] num = {3,1,2,4};
        NineZeroFive.sortArrayByParity(num);
    }
}

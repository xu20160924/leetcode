package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-23 20:31
 * @description: NC22
 **/
public class NcTwoTwo {
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}

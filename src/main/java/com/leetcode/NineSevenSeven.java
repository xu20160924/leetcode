package com.leetcode;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-02-06 11:02
 * @description: 977
 **/
public class NineSevenSeven {
//    public static int[] sortedSquares(int[] A) {
//        int N = A.length;
//        int[] ans = new int[N];
//        for (int i = 0; i < N; i++) {
//           ans[i] = A[i] * A[i];
//        }
//        Arrays.sort(ans);
//        return ans;
//    }
//    public static int[] sortedSquares(int[] A) {
//        int N = A.length;
//        int j = 0;
//        while (j < N && A[j] < 0) {
//            j++;
//        }
//        int i = j -1;
//        int[] ans = new int[N];
//        int t = 0;
//        while (i >= 0 && j < N) {
//            if (A[i] * A[i] < A[j] * A[j]) {
//                ans[t++] = A[i] * A[i];
//                i--;
//            } else {
//                ans[t++] = A[j] * A[j];
//                j++;
//            }
//        }
//        while (i >= 0) {
//            ans[t++] = A[i] * A[i];
//            i--;
//        }
//        while (j < N) {
//           ans[t++] = A[j] * A[j];
//           j++;
//        }
//        return ans;
//    }
    public static int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] result = new int[N];
        int i = 0, j = N - 1;
        for (int p = N - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        NineSevenSeven.sortedSquares(nums);
    }
}

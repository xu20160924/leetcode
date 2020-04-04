package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-06 14:15
 * @description: 852
 **/
public class EightFiveTwo {
//    public static int peakIndexInMountainArray(int[] A) {
//        int i = 0 ;
//        while (A[i] < A[i+1]) {
//            i++;
//        }
//        return i;
//    }

    public static int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length -1;
        while (lo < hi) {
            int mi = (lo + hi) /2;
            if (A[mi] < A[mi + 1]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
}

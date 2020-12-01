package com.nowcoder;

/**
 * @author: John
 * @date: 2020-11-22 21:06
 * @description: NC48
 **/
public class NcFourEight {
    public int search (int[] A, int target) {
        // write code here
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) >> 1;
            if (A[mid] == target) {
                return mid;
            }
            if (A[left] <= A[mid]) {  // 左边有序
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

package com.lintcode;

/**
 * @author: John
 * @date: 2020-03-20 14:56
 * @description: 463
 **/
public class TwoSixThree {
//    public void sortInteger(int[] A) {
//       if (A == null || A.length == 0) {
//           return;
//       }
//       int[] temp = new int[A.length];
//       mergeSort(A, 0, A.length - 1, temp);
//    }
//
//    private void mergeSort(int[] A, int start, int end, int[] temp) {
//        if (start >= end) {
//            return;
//        }
//        mergeSort(A, start, (start + end) / 2, temp);
//        mergeSort(A, (start + end) / 2 + 1, end, temp);
//        merge(A, start, end, temp);
//    }
//
//    private void merge(int[] A, int start, int end, int[] temp) {
//        int middle = (start + end) / 2;
//        int leftIndex = start;
//        int rightIndex = middle + 1;
//        int index = leftIndex;
//
//        while (leftIndex <= middle && rightIndex <= end) {
//            if (A[leftIndex] < A[rightIndex]) {
//                temp[index++] = temp[leftIndex++];
//            } else {
//                temp[index++] = temp[rightIndex++];
//            }
//        }
//
//        while (leftIndex <= middle) {
//            temp[index++] = A[leftIndex++];
//        }
//        while (rightIndex <= end) {
//            temp[index++] = A[rightIndex++];
//        }
//
//        for (int i = 0; i <= end; i++) {
//            A[i] = temp[i];
//        }
//    }

    public void sortInteger(int[] A) {
       if (A == null || A.length == 0) {
           return;
       }
       quickSort(A, 0, A.length - 1);
    }
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) {
           return;
        }
        int left = start, right = end;
        // 1. pivot, A[start] A[end]
        // get vlaue not index
        int pivot = A[(start + end) / 2];
        // 2. left <= right not left < right
        while (left <= right) {
            // 3. A[left] < pivot not <=
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
    }



    public static void main(String[] args) {
        int[] nums = new int[]{19,-10,-2,40,3,36,57,25,66,51,5,40,-8,43,9,-5,0,4,55,28,63,67,-2,35,57,0,0,30,17,55,22,34,-4,42,57,52,4,65,6,-2,8,12,31,43,26,34,31,19,-3,36,34,11,58,23,13,7,17,10,33,-5,10,53,14,56,18,8,-6,-2,37,7};
        TwoSixThree twoSixThree = new TwoSixThree();
        twoSixThree.sortInteger(nums);
    }
}

package com.leetcode;

/**
 * @author: John
 * @date: 2020-09-24 09:16
 * @description: 912
 **/
public class NineOneTwo {
    public void sort(int arr[]) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
        quickSort(arr, 0, arr.length - 1);
    }



    public void quickSort(int[] arr, int l, int r) {
        // 递归结束条件: l 大于等于 r
        if (l >= r) {
           return;
        }
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l;
        int j = r;

        while (i != j) {
            // 右指针左移
            while (i < j && arr[j] > pivot) {
                j--;
            }
            // 左指针右移
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            // swap element of l and r
            if (i < j) {
                int p = arr[i];
                arr[i] = arr[j];
                arr[j] = p;
            }
        }
        arr[l] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
//        int[] n = {5,2,3,1};
//        NineOneTwo nineOneTwo = new NineOneTwo();
//        nineOneTwo.sort(n);
////        System.out.println();
//        for (int i = 0; i < n.length; i++) {
//            System.out.println(n[i]);
//        }

        System.out.println( 1 << 30);
    }
}

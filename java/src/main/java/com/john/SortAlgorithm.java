package com.john;

import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-01-21 10:15
 * @description: Sort
 **/
public class SortAlgorithm {

    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = arr.length - 1; i > 0 ; --i) {
            for (int j = 0; j < i; j++) {
               if (arr[j] > arr[j + 1]) {
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
            }
        }
        return arr;
    }

    public int[] selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0, k = 0; i < len; i++, k = i) {
            // find minimum in this loop
            for (int j = i + 1; j < len; j++) {
               if (arr[k] > arr[j]) {
                   k = j;
               }
            }
            if (i != k) {
                int tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i];
            while (j > 0 && target < arr[j - 1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = target;
        }
        return arr;
    }
    public int[] insertionSort2(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

//    public static int partition(int[] arr, int left, int right) {
//        int pivotKey = arr[left];
//        int pivotPointer = left;
//        while (left < right) {
//            while (left < right && arr[right] >= pivotKey) {
//                right--;
//            }
//            while (left < right && arr[left] <= pivotKey) {
//                left++;
//            }
//            swap(arr, left, right);
//        }
//        swap(arr, pivotPointer, left);
//        return left;
//    }
//
//    public static void swap(int[] arr, int left, int right) {
//        int temp = arr[left];
//        arr[left] = arr[right];
//        arr[right] = temp;
//    }
//
//    public int[] quickSort(int[] arr, int left, int right) {
//        if (left >= right) {
//            return arr;
//        }
//        int pivotPos = partition(arr, left, right);
//        quickSort(arr, left, pivotPos - 1);
//        quickSort(arr, pivotPos + 1, right);
//        return arr;
//    }

    /**
     * quick sort after optimize
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivotKey) {
                right--;
            }
            // move mini to left
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivotKey) {
                left++;
            }
            // move max to right
            arr[right] = arr[left];
        }
        // final move pivot to middle
        arr[left] = pivotKey;
        return left;
    }

    /**
     * quick sort after optimize satisfy definition of big heap
     * @param arr
     * @param left
     * @param right
     */
    public int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return null;
        }
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos - 1);
        quickSort(arr, pivotPos + 1, right);
        return arr;
    }

    /**
     * screen heap, exlucde start  start ~ end
     * @param arr
     * @param start
     * @param end
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i <= end; i*=2) {
            if (i < end && arr[i] < arr[i+1]) {
                i++;
            }
            if (temp >= arr[i]) {
                break;
            }
            arr[start] = arr[i];
            start = i;
        }
        arr[start] = temp;
    }

    public int[] heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = arr.length/2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i - 1);
        }
        return arr;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }




    public static void main(String[] args) {
//        int[] arr = {5,3,25,7,2,4};
        int[] arr = {49,38,65,97,76,13,27,49};
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        Arrays.stream(sortAlgorithm.heapSort(arr)).forEach(x -> System.out.println(x));
    }
}

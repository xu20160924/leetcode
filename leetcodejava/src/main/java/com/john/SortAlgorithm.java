package com.john;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

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

//    /**
//     * screen heap, exlucde start  start ~ end
//     * @param arr
//     * @param start
//     * @param end
//     */
//    public static void heapAdjust(int[] arr, int start, int end) {
//        int temp = arr[start];
//        for (int i = 2 * start + 1; i <= end; i*=2) {
//            if (i < end && arr[i] < arr[i+1]) {
//                i++;
//            }
//            if (temp >= arr[i]) {
//                break;
//            }
//            arr[start] = arr[i];
//            start = i;
//        }
//        arr[start] = temp;
//    }
//
//    public int[] heapSort(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return null;
//        }
//        for (int i = arr.length/2; i >= 0; i--) {
//            heapAdjust(arr, i, arr.length - 1);
//        }
//        for (int i = arr.length - 1; i >= 0 ; i--) {
//            swap(arr, 0, i);
//            heapAdjust(arr, 0, i - 1);
//        }
//        return arr;
//    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex  要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        // temp 保存父节点值，用于最后的赋值
//        System.out.println(parentIndex);
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex]) {
                break;
            }
            // 无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序(升序)
     * @param array     待调整的堆
     */
    public static void heapSort(int[] array) {
        // 1.把无序数组构建成最大堆。
        for (int i = (array.length-2)/2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        // 2.循环交换集合尾部元素到堆顶，并调节堆产生新的堆顶。
        for (int i = array.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    /**
     * 计数排序
     * @param array
     * @return
     */
//    public static int[] countSort(int[] array) {
//        // 1. 得到数列的最大值
//        int max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] > max) {
//               max = array[i];
//            }
//        }
//        // 2. 根据数列最大值确定统计数组的长度
//        int[] countArray = new int[max + 1];
//        // 3. 遍历数列，填充统计数组
//        for (int i = 0; i < array.length; i++) {
//            countArray[array[i]]++;
//        }
//        // 4. 遍历统计数组， 输出结果
//        int index = 0;
//        int[] sortedArray = new int[array.length];
//        for (int i = 0; i < countArray.length; i++) {
//            for (int j = 0; j < countArray[i]; j++) {
//                sortedArray[index++] = i;
//            }
//        }
//        return sortedArray;
//    }

    /**
     * 优化后的计数排序
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        // 1. 得到数列的最大值和最小值，并算出差值d
        int max = array[0];
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
               max = array[i];
            }
            if (array[i] < min) {
               min = array[i];
            }
        }
        int d = max - min;
        // 2. 创建统计数组并统计对应元素的个数
        int[] countArray = new int[d + 1];
        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        // 3. 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 4. 倒序遍历原始数列, 从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[countArray[array[i] - min] - 1] = array[i];
            countArray[array[i] - min]--;
        }
        return sortedArray;
    }

    public static double[] bucketSort(double[] array) {
        // 1. 得到数列的最大值和最小值，并算出差值d
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] > min) {
                min = array[i];
            }
        }

        double d = max - min;

        // 2.  初始化桶
        int bucketNum = array.length;
        ArrayList<java.util.LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new java.util.LinkedList<Double>());
        }

        // 3. 比那里原始数组, 将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        // 4. 对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            // JDK 底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        // 5. 输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double element : list) {
               sortedArray[index] = element;
               index++;
            }
        }

        return sortedArray;
    }



    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));

//        array = new int[] {95,94,91,98,99,90,99,93,91,92};
//        sortedArray = countSort(array);
//        System.out.println(Arrays.toString(sortedArray));
    }



//    public static void main(String[] args) {
////        int[] arr = {5,3,25,7,2,4};
////        int[] arr = {49,38,65,97,76,13,27,49};
//        SortAlgorithm sortAlgorithm = new SortAlgorithm();
////        Arrays.stream(sortAlgorithm.heapSort(arr)).forEach(x -> System.out.println(x));
//        SortAlgorithm.heapSort(new int[]{3,2,1,4,5});
//    }
}

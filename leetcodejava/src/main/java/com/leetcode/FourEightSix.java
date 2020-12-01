package com.leetcode;

import javax.sql.rowset.BaseRowSet;

/**
 * @author: John
 * @date: 2020-04-25 19:23
 * @description: 486
 **/
public class FourEightSix {
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays.length == 0 || arrays == null) {
            return null;
        }

        int interval = 1;
        while (interval < arrays.length) {
            for (int i = 0; i + interval < arrays.length; i = i + interval * 2) {
                arrays[i] = mergeTwoArray(arrays[i], arrays[i + interval]);
            }
            interval *= 2;
        }
        return arrays[0];
    }

    public int[] mergeTwoArray(int[] array1, int[] array2) {
        int[] res = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                res[i + j] = array1[i];
                i++;
            } else {
                res[i + j] = array2[j];
                j++;
            }
        }

        if (i == array1.length) {
            while (j < array2.length) {
                res[i + j] = array2[j];
                j++;
            }
        }

        if (j == array2.length) {
            while (i < array1.length) {
                res[i + j] = array1[i];
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[3][];
        int[] array1 = {1,3,5,7};
        int[] array2 = {2,4,6};
        int[] array3 = {0,8,9,10,11};

        input[0] = array1;
        input[1] = array2;
        input[2] = array3;

        FourEightSix fourEightSix = new FourEightSix();
        int[] res = fourEightSix.mergekSortedArrays(input);
    }
}

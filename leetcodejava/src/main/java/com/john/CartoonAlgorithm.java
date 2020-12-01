package com.john;

/**
 * @author: John
 * @date: 2020-04-17 15:05
 * @description: Cartoon Algorithm
 **/
public class CartoonAlgorithm {
    public static int gcd(int a, int b) {
        if (a ==b ) {
           return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a>>1, b>>1) << 1;
        } else if ((a&1) == 0 && (b&1) != 0) {
            return gcd(a>>1, b);
        } else if ((a&1) != 0 && (b&1) == 0) {
            return gcd(a, b>>1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }

    public static int getMaxSortedDistance(int[] array) {
        // 1. 得到数列的最大值和最小值
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
        // 如果max 和 min 相等，说明数组所有元素都相等，返回0
        if (d == 0) {
            return 0;
        }

        // 2. 初始化桶
        int bucketNum = array.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 3. 遍历原始数组, 确定每个桶的最大最小值
        for (int i = 0; i < array.length; i++) {
            // 确定数组元素所归属的桶下标
            int index = ((array[i] - min) * (bucketNum - 1) / d);
            if (buckets[index].min == null || buckets[index].min > array[i]) {
                buckets[index].min = array[i];
            }
            if (buckets[index].max == null || buckets[index].max < array[i]) {
                buckets[index].max = array[i];
            }
        }

        // 4. 遍历桶， 找到最大差值
        int leftMax = buckets[0].max;
        int maxDistance = 0;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].min == null) {
                continue;
            }
            if (buckets[i].min - leftMax > maxDistance) {
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer min;
        Integer max;
    }
}

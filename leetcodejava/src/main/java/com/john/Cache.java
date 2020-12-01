package com.john;

/**
 * @author: John
 * @date: 2020-10-23 10:20
 * @description: CPU Cache & Cache Line
 **/
public class Cache {
    static long[][] arr;

    public static void main(String[] args) {
        arr = new long[1024 * 1024][8];
        // 横向遍历
        int sum = 0;
        long marked = System.currentTimeMillis();
        for (int i = 0; i < 1024 * 1024; i++) {
            for (int j = 0; j < 8; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("Loop times: " + (System.currentTimeMillis() - marked));

        marked = System.currentTimeMillis();
        // 纵向遍历
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 1024 * 1024; j++) {
                sum += arr[j][i];
            }
        }
        System.out.println("Loop times: " + (System.currentTimeMillis() - marked));
    }
}

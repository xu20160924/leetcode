package com.leetcode;

/**
 * @author: John
 * @date: 2020-10-22 15:35
 * @description: 190
 **/
public class OneNineZero {
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 4;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a <<= 1));
    }


}

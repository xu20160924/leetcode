package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-14 18:05
 * @description: 7
 **/
public class Seven {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Seven.reverse(1056389759);
    }
}

package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-25 15:29
 * @description: 28
 **/
public class TwoEight {
    public static int strStr(String haystack, String needle) {
        for (int i = 0;  ; i++) {
            for (int j = 0;  ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}

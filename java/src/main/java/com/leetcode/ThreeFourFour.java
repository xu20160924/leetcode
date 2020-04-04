package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-24 22:17
 * @description: 344
 **/
public class ThreeFourFour {
//    public void helper(char[] s, int left, int right) {
//        if (left >= right) {
//           return;
//        }
//        char tmp = s[left];
//        s[left++] = s[right];
//        s[right--] = tmp;
//        helper(s, left, right);
//    }
//    public void reverseString(char[] s) {
//       helper(s, 0, s.length - 1);
//    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }

}

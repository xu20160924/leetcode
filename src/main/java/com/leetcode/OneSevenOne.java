package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-28 12:11
 * @description: 171
 **/
public class OneSevenOne {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            System.out.println(s.charAt(i) - 'A' + 1);
            result = result * 26 + (s.charAt(i) - 'A' + 1);
            System.out.println(result);
        };
        return result;
    }

    public static void main(String[] args) {
        OneSevenOne oneSevenOne = new OneSevenOne();
        oneSevenOne.titleToNumber("AB");
    }
}

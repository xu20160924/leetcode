package com.leetcode;

public class FiveEight {
//    public int lengthOfLastWord(String s) {
//        String[] arr = s.split(" ");
//        int maxSize = Integer.MIN_VALUE;
//        return arr[arr.length - 1].length();
//    }

    public int lengthOfLastWord(String s) {
        int maxSize = 0;
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        while (s.charAt(index--) != ' ') {
            maxSize++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        FiveEight fiveEight = new FiveEight();
        fiveEight.lengthOfLastWord("a");
    }
}

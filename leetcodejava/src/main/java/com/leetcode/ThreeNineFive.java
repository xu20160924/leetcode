package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-08 10:04
 * @description: 395
 **/
public class ThreeNineFive {

    // two pointer not good code
//    public int longestSubstring(String s, int k) {
//        char[] str = s.toCharArray();
//        int[] counts = new int[26];
//        int h, i, j, idx, max = 0, unique, noLessThaK;
//
//        for (h = 1; h <= 26; h++) {
//            Arrays.fill(counts, 0);
//            i = 0;
//            j = 0;
//            unique = 0;
//            noLessThaK = 0;
//            while (j < str.length) {
//                if (unique <= h) {
//                    idx = str[j] - 'a';
//                    if (counts[idx] == 0) {
//                        unique++;
//                    }
//                    counts[idx]++;
//                    if (counts[idx] == k) {
//                        noLessThaK++;
//                    }
//                    j++;
//                } else {
//                    idx = str[i] - 'a';
//                    if (counts[idx] == k) {
//                        noLessThaK--;
//                    }
//                    counts[idx]--;
//                    if (counts[idx] == 0) {
//                        unique--;
//                    }
//                    i++;
//                }
//                if (unique == h && unique == noLessThaK) {
//                    max = Math.max(j - i, max);
//                }
//            }
//        }
//        return max;
//    }

    public int logestSubstring(String s, int k) {
        int d = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));
        }
        return d;
    }

    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] map = new int[128];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0, end = 0;
        int d = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)]++ == 0) {
                numUnique++;
            }
            if (map[s.charAt(end++)] == k) {
                numNoLessThanK++;
            }
            while (numUnique > numUniqueTarget) {
                if (map[s.charAt(begin)]-- == k) {
                    numNoLessThanK--;
                }
                if (map[s.charAt(begin++)] == 0) {
                    numUnique--;
                }
            }
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                d = Math.max(end - begin, d);
            }
        }
        return d;
    }

    public static void main(String[] args) {
        ThreeNineFive threeNineFive = new ThreeNineFive();
        threeNineFive.logestSubstring("aaabb", 3);
    }
}

package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: John
 * @date: 2020-03-22 20:44
 * @description: 242
 **/
public class TwoFourTwo {
//    public boolean isAnagram(String s, String t) {
//       if (s.length() != t.length()) {
//           return false;
//       }
//       char[] str1 = s.toCharArray();
//       char[] str2 = t.toCharArray();
//       Arrays.sort(str1);
//       Arrays.sort(str2);
//       return Arrays.equals(str1, str2);
//    }

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] counter = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            counter[s.charAt(i) - 'a']++;
//            counter[s.charAt(i) - 'a']--;
//        }
//        for (int count : counter) {
//            if (count != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
               return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TwoFourTwo twoFourTwo = new TwoFourTwo();
        twoFourTwo.isAnagram("anagram", "nagaram");
    }
}

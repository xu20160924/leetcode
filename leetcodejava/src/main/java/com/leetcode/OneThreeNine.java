package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-09-21 17:26
 * @description: 139
 **/
public class OneThreeNine {
//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] f = new boolean[s.length() + 1];
//        f[0] = true;
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (String str : wordDict) {
//                if (str.length() <= i) {
//                    if (f[i - str.length()]) {
//                        if (s.substring(i - str.length(), i).equals(str)) {
//                            f[i] = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return f[s.length()];
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        boolean[] f = new boolean[s.length() + 1];
//        f[0] = true;
//        for (int i = 1; i <= s.length(); i++) {
//            for (String word : wordDict) {
//                if (word.length() <= i) {
//                    if (f[i - word.length()]) {
//                        if (s.substring(i - word.length(), i).equals(word)) {
//                            f[i] = true;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return f[s.length()];
//    }



    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }


    public static void main(String[] args) {
        List<String> word = new ArrayList<>();
        word.add("leet");
        word.add("code");
        OneThreeNine oneThreeNine = new OneThreeNine();
        System.out.println(oneThreeNine.wordBreak("leetcode", word));
    }
}

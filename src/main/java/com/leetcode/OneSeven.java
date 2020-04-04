package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-05 19:45
 * @description: 17
 **/
public class OneSeven {
//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<>();
//        if (digits.isEmpty()) {
//            return ans;
//        }
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        for (int i = 0; i < digits.length(); i++) {
//            int x = Character.getNumericValue(digits.charAt(i));
//            while (ans.peek().length() == i) {
//                String t = ans.remove();
//                for (char s : mapping[x].toCharArray()) {
//                    ans.add(t + s);
//                }
//            }
//        }
//        return ans;
//    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        OneSeven oneSeven = new OneSeven();
        oneSeven.letterCombinations("23");
    }
}

package com.leetcode;

import java.util.*;

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

//    public List<String> letterCombinations(String digits) {
//        LinkedList<String> ans = new LinkedList<>();
//        if (digits.isEmpty()) {
//            return ans;
//        }
//        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        ans.add("");
//        while (ans.peek().length() != digits.length()) {
//            String remove = ans.remove();
//            String map = mapping[digits.charAt(remove.length()) - '0'];
//            for (char c : map.toCharArray()) {
//                ans.addLast(remove + c);
//            }
//        }
//        return ans;
//    }

//    Map<String, String> phone = new HashMap<String, String>() {{
//        put("2", "abc");
//        put("3", "def");
//        put("4", "ghi");
//        put("5", "jkl");
//        put("6", "mno");
//        put("7", "pqrs");
//        put("8", "tuv");
//        put("9", "wxyz");
//    }};
//
//
//    List<String> output = new ArrayList<>();
//    public void backtrack(String combination, String nextDigits) {
//        // no more digits to check
//        if (nextDigits.length() == 0) {
//            output.add(combination);
//        } else {
//            String digit = nextDigits.substring(0, 1);
//            String letters = phone.get(digit);
//            for (int i = 0; i < letters.length(); i++) {
//                String letter = phone.get(digit).substring(i , i + 1);
//                // append current letter to the combination
//                backtrack(combination + letter, nextDigits.substring(1));
//            }
//        }
//    }
//
//    public List<String> letterCombinations(String digits) {
//        if (digits.length() != 0) {
//            backtrack("", digits);
//        }
//        return output;
//    }




    Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return output;
        }
        backtrack("", digits);
        return output;
    }


    private void backtrack(String combination, String nextDigit) {
        if (nextDigit.equals("")) {
            output.add(combination);
        } else {
            String digit = nextDigit.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backtrack(combination + letters.charAt(i), nextDigit.substring(1));
            }
        }
    }


    public static void main(String[] args) {
        OneSeven oneSeven = new OneSeven();
        oneSeven.letterCombinations("23");
    }
}

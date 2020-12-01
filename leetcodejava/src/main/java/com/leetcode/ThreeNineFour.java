package com.leetcode;


import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-01-19 14:38
 * @description: 394
 **/
public class ThreeNineFour {

//    public String decodeString(String s) {
//        StringBuilder res = new StringBuilder();
//        int multi = 0;
//        LinkedList<Integer> stack_multi = new LinkedList<>();
//        LinkedList<String> stack_res = new LinkedList<>();
//        for (Character c : s.toCharArray()) {
//            if (c == '[') {
//                stack_multi.add(multi);
//                stack_res.addLast(res.toString());
//                multi = 0;
//                res = new StringBuilder();
//            } else if (c == ']') {
//                StringBuilder temp = new StringBuilder();
//                int cur_multi = stack_multi.removeLast();
//                for (int i = 0; i < cur_multi; i++) {
//                    temp.append(res);
//                }
//                res = new StringBuilder(stack_res.removeLast() + temp);
//            } else if (c >= '0' && c <= '9') {
//                multi = multi * 10 + Integer.parseInt(c + "");
//            } else {
//                res.append(c);
//            }
//        }
//        return res.toString();
//    }

    // recursion
//    public String decodeString(String s) {
//        return dfs(s, 0)[0];
//    }
//    private String[] dfs(String s, int i) {
//        StringBuilder res = new StringBuilder();
//        int multi = 0;
//        while (i < s.length()) {
//            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
//            } else if (s.charAt(i) == '[') {
//                String[] temp = dfs(s, i + 1);
//                i = Integer.parseInt(temp[0]);
//                while (multi > 0) {
//                    res.append(temp[1]);
//                    multi--;
//                }
//            } else if (s.charAt(i) == ']') {
//                return new String[] {String.valueOf(i), res.toString()};
//            } else {
//                res.append(String.valueOf(s.charAt(i)));
//            }
//            i++;
//        }
//        return new String[] {res.toString()};
//    }


    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k* 10 + c - '0';
            } else if (c == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) {
                   cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        String input = "3[a2[c]]";
        ThreeNineFour threeNineFour = new ThreeNineFour();
        System.out.println(threeNineFour.decodeString(input));
    }
}

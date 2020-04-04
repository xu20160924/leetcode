package com.leetcode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-01-19 11:57
 * @description: 20
 **/
public class Twenty {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
               stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
               return false;
            }
            return stack.isEmpty();
        }
        return stack.isEmpty();
    }
}

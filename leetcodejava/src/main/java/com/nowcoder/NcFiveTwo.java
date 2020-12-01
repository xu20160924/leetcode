package com.nowcoder;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-11-22 20:55
 * @description: NC52
 **/
public class NcFiveTwo {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
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
        }
        return stack.isEmpty();
    }
}

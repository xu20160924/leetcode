package com.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-05-21 08:09
 * @description: 31
 **/
public class ThreeOne {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            // num 入栈
            stack.push(num);
            // 循环判断与出栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

package com.john;

import java.util.Stack;

/**
 * @author: John
 * @date: 2019-12-17 10:17
 * @description:
 **/
public class SortStackByOnStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int  cur = stack.pop();
            while (!stack.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        // finally judge weather help stack is null and then push all item into stack; prevent help stack retain item
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}

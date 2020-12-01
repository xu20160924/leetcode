package com.leetcode.jianzhioffer;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-05-21 07:40
 * @description: 30
 **/
public class ThreeZero {
    Stack<Integer> A, B;

    public ThreeZero() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }


}

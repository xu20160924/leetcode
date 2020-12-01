package com.leetcode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-18 18:48
 * @description: 232
 **/
public class TwoThreeTwo {

    private int front;
    private Stack<Integer> s1, s2;
//    public void push(int x) {
//        if (s1.empty()) {
//            front = x;
//        }
//        while (!s1.isEmpty()) {
//            s2.push(s1.pop());
//        }
//        s2.push(x);
//        while (!s2.isEmpty()) {
//            s1.push(s2.pop());
//        }
//    }
//
//    public void pop() {
//        s1.pop();
//        if (!s1.empty()) {
//            front = s1.peek();
//        }
//    }
//
//    public boolean empty() {
//        return s1.isEmpty();
//    }
//
//    public int peek() {
//        return front;
//    }


    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        s1.push(x);
    }

    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        s2.pop();
    }
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
}

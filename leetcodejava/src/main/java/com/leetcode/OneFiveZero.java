package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-28 11:41
 * @description: 150
 **/
public class OneFiveZero {

//    public int evalRPN(String[] tokens) {
//        int a, b;
//        Stack<Integer> S = new Stack<>();
//        for (String s: tokens) {
//            if (s.equals("+")) {
//                S.add(S.pop()+ S.pop());
//            } else if (s.equals("/")) {
//                b = S.pop();
//                a = S.pop();
//                S.add(a / b);
//            } else if (s.equals("*")) {
//                S.add(S.pop() * S.pop());
//            } else if (s.equals("-")) {
//                b = S.pop();
//                a = S.pop();
//                S.add(a - b);
//            } else {
//                S.add(Integer.parseInt(s));
//            }
//        }
//        return S.pop();
//    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
                int right = deque.removeFirst();
                int left = deque.removeFirst();
                if (s.equals("*")) {
                    deque.addFirst(left * right);
                }
                if (s.equals("/")) {
                   deque.addFirst(left / right);
                }
                if (s.equals("+")) {
                    deque.addFirst(left + right);
                }
                if (s.equals("-")) {
                    deque.addFirst(left - right);
                }
            } else {
                deque.addFirst(Integer.valueOf(s));
            }
        }
        return deque.peekFirst();
    }
}

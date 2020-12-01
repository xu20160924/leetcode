package com.leetcode.jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-05-10 11:20
 * @description: 09
 **/
public class ZeroNine {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

//    public ZeroNine() {
//        stack1 = new Stack<>();
//        stack2 = new Stack<>();
//        size = 0;
//    }

//    public void appendTail(int value) {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//        stack1.push(value);
//        while (!stack2.isEmpty()) {
//            stack1.push(stack2.pop());
//        }
//        size++;
//    }
//
//    public int deleteHead() {
//        if (size == 0) {
//            return -1;
//        }
//        size--;
//        return stack1.pop();
//    }

    /**
     * 针对上一个的优化 把顺序操作放到deleteHead中去处理
     * @return
     */
//    public void appendTail(int value) {
//        stack1.push(value);
//        size++;
//    }
//
//    public int deleteHead() {
//        if (size == 0) {
//            return -1;
//        }
//        if (stack2.empty()) {
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//        }
//        size--;
//        return stack2.pop();
//    }


    /**
     *  通过LinkedList 来实现； 由于 Stack 底层通过数组实现  而LinkedList通过双向链表实现；
     *  所以通过LinkedList实现时会快很多，但是不符合题目要求
     */

    LinkedList<Integer> s1;
    LinkedList<Integer> s2;

    public ZeroNine() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        s1.add(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                stack2.add(s1.pop());
            }
            return stack2.pop();
        } else {
            return s2.pop();
        }
    }
}

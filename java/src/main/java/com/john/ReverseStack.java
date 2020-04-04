package com.john;

import java.util.Stack;

/**
 * @author: John
 * @date: 2019-12-16 17:10
 * @description: Reverse the stack
 * use stack and recursion function reverse the data
 **/
public class ReverseStack {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
        ReverseStack.getAndRemoveLastElement(stack);
//        reverse(stack);
//        System.out.println(stack.toString());
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stack.pop());
//        }
    }

//    public static void main(String[] args) {
//
//    }

}

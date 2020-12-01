package com.john;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-01-25 18:26
 * @description:
 **/
public class StackProblems {

    /**
     * from book
     * Using one stack to sort another stack
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    /**
     * just using iteration and stack reverse stack
      * @param stack
     * @return
     */
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
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }


    /**
     * getMin stack
     */
    class MinStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MinStack1() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }
        public void push(int newNum) {
            if (this.stackMin.isEmpty() || newNum <= getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    /**
     * getMin stack
     */
    public class MyStack2 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }
        public void push(int newNum) {
            if (this.stackMin.isEmpty() || newNum < this.getmin()) {
                this.stackMin.push(newNum);
            } else {
                this.stackMin.push(getmin());
            }
            this.stackData.push(newNum);
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            this.stackMin.pop();
            return this.stackData.pop();
        }

    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
           return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
               qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
               qmax.pollFirst();
            }
            if (i >= w - 1) {
               res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Stack<Integer> input = new Stack<>();
//        input.add(10);
//        input.add(6);
//        input.add(3);
//        input.add(11);
//        input.add(14);
//        input.add(1);
//        StackProblems.reverse(input);
        int[] input = {4,3,5,4,3,3,6,7};
        StackProblems.getMaxWindow(input, 3);
//        StackProblems.sortStackByStack(input);
    }
}

package com.john;

import java.util.Stack;

/**
 * @author: John
 * @date: 2019-12-12 20:58
 * @description:
 **/
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int num) {
        stackPush.push(num);
        pushToPop();
    }

    private void pushToPop() {
        if (stackPop.empty()) {
//            while (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Your Queen is empty");
        }
        pushToPop();
        return stackPop.pop();
    }
    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Your Queen is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

    public static void main(String[] args) {
//        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
//        for (int i = 1; i < 11; i++) {
////            int a = 11 - i;
//            System.out.println("add:" + i);
//            twoStacksQueue.add(i);
//        }
        Stack<Integer> test = new Stack<>();
        for (int i = 1; i < 11; i++) {
//            int a = 11 - i;
            System.out.println("add:" + i);
            test.add(i);
        }
        for (int i = 1; i < 11; i++) {
            System.out.println(            test.pop());
        }
//        for (int i = 1; i < 11; i++) {
//            System.out.println(twoStacksQueue.poll());
//        }

    }

}

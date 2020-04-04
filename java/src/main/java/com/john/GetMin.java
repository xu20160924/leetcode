package com.john;

import java.util.Stack;

/**
 * @author: John
 * @date: 2019-12-12 11:54
 * @description:
 **/
public class GetMin {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMin() {
        this.stackData = new Stack<Integer>();
        this.stackMin  = new Stack<Integer>();
    }
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        GetMin getMin = new GetMin();
        getMin.push(3);
        getMin.push(4);
        getMin.push(5);
        getMin.push(1);
        getMin.push(2);
        getMin.push(1);
        for (int i = 0; i < 7; i++) {
            System.out.println(getMin.pop());
        }
    }
}

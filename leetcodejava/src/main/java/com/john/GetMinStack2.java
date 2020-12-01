package com.john;

import java.util.Stack;

/**
 * @author: John
 * @date: 2019-12-12 19:48
 * @description:
 **/
public class GetMinStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMini;

    public GetMinStack2() {
        stackData = new Stack<Integer>();
        stackMini = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMini.isEmpty()) {
            this.stackMini.push(newNum);
        } else if (newNum <= getMin()) {
            this.stackMini.push(newNum);
        } else {
            newNum = this.stackMini.peek();
            this.stackMini.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackMini.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        this.stackData.pop();
        return this.stackMini.pop();
    }
    public int getMin() {
        if (this.stackMini.isEmpty()) {
            throw new RuntimeException("Your stackMini is empty");
        }
        return this.stackMini.peek();
    }

}

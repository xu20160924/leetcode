package com.interview;

import java.util.EmptyStackException;
import java.util.Random;

/**
 * @author
 * @date 2024/03/05 15:37
 * @description 栈型队列类
 * @version 1.0
 */
public class StackPipe {
    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;
    private static final int SNAKE_LENGTH = 10;
    private static final Random random = new Random();

    public StackPipe() {
        initializeSnake();
    }

    private void initializeSnake() {
        // 初始化10个节点
        for (int i = 0; i < SNAKE_LENGTH; i++) {
            push(i + 1);
        }
    }

    public void push(int value) {
        Node<Integer> current = new Node<>(value);
        if (head == null) {
            head = tail = current;
        } else {
            current.setDown(head);
            head.setUp(current);
            head = current;Q
        }
        size++;
    }

    public int pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        int value = head.getData();
        head = head.getDown();
        if (head != null) {
            head.setUp(null);
        } else {
            tail = null;
        }
        return value;
    }

    public int pop2() {
        if (tail == null) {
            throw new EmptyStackException();
        }
        int value = tail.getData();
        tail = tail.getUp();
        if (tail != null) {
            tail.setDown(null);
        } else {
            head = null;
        }
        return value;
    }

    public static void main(String[] args) {
        StackPipe stackPipe = new StackPipe();
        stackPipe.push(1);
        System.out.println("入栈: 1");
        stackPipe.push(2);
        System.out.println("入栈: 2");
        stackPipe.push(3);
        System.out.println("入栈: 3");

        System.out.println("出栈:");
        System.out.println(stackPipe.pop());

        System.out.println("从尾部出栈:");
        System.out.println(stackPipe.pop2());
    }
}

package com.interview;

/**
 * @author
 * @date 2024/03/05 15:37
 * @description 双向链表
 * @version 1.0
 */
public class Node<T> {
    private T data;
    private Node<T> up;
    private Node<T> down;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> up, Node<T> down) {
        this.data = data;
        this.up = up;
        this.down = down;
    }

    public Node<T> getDown() {
        return down;
    }

    public Node<T> getUp() {
        return up;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setDown(Node<T> down) {
        this.down = down;
    }

    public void setUp(Node<T> up) {
        this.up = up;
    }

    public static void main(String[] args) {
        // 创建链表
        Node<Integer> current = new Node<>(2);
        Node<Integer> up = new Node<>(1);
        Node<Integer> down = new Node<>(3);

        current.setUp(up);
        current.setDown(down);
        up.setDown(current);
        down.setUp(current);

        // 从头遍历链接
        Node<Integer> temp = up;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getDown();
        }

        System.out.println("--------------");

        temp = down;
        // 从结尾向前遍历链表
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getUp();
        }
    }
}


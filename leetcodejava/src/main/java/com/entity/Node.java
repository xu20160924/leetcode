package com.entity;

import java.util.List;

/**
 * @author: John
 * @date: 2020-03-22 08:39
 * @description: node
 **/
public class Node {
//    public int val;
//    public Node prev;
//    public Node next;
//    public Node child;
//
//    public Node(int val, Node prev, Node next, Node child) {
//        this.val = val;
//        this.prev = prev;
//        this.next = next;
//        this.child = child;
//    }
    public int val;
    public Node next;
    public Node prev;
    public boolean isEaten;

    public Node() {}

    public Node(int _val) {
        val = _val;
        isEaten = false;
    }

    public Node(int _val, Node _next, Node _prev) {
        val = _val;
        next = _next;
        prev = _prev;
        isEaten = false;
    }
}

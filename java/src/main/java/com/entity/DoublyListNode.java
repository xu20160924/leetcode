package com.entity;

/**
 * @author: John
 * @date: 2020-03-21 16:11
 * @description: DoublyListNode
 **/
public class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int val) {
       this.val = val;
       this.next = this.prev = null;
    }
}

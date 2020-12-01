package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-05 17:18
 * @description: 61
 **/
public class SixOne {

//    public ListNode rotateRight(ListNode head, int n) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode fast = dummy, slow = dummy;
//        int i;
//        for (i = 0; fast.next != null; i++) {
//            fast = fast.next;
//        }
//        for (int j = i-n%i; j>0; j--) {
//            slow = slow.next;
//        }
//        // there can generate infinite loop
//        fast.next = dummy.next;
////        System.out.println(dummy.next.val);
//        dummy.next = slow.next;
//        slow.next = null;
//        return dummy.next;
//    }

//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == null) {
//            return head;
//        }
//        ListNode old_tail = head;
//        int n;
//        for (n=1; old_tail.next != null; n++) {
//           old_tail = old_tail.next;
//        }
//        old_tail.next = head;
//        ListNode new_tail = head;
//        for (int i = 0; i < n-k%n-1; i++) {
//            new_tail = new_tail.next;
//        }
//        ListNode new_head = new_tail.next;
//        new_tail.next = null;
//        return new_head;
//    }

//    public ListNode rotateRight(ListNode head, int n) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode fast = dummy, slow = dummy;
//        int i;
//        for (i = 0; fast.next != null; i++) { // Get the total length
//            fast = fast.next;
//        }
//
//        for (int j = i - n % i; j > 0; j--) {   // get the i - n % i th node
//            slow = slow.next;
//        }
//        fast.next = dummy.next; // Do the rotation
//        dummy.next = slow.next;
//        slow.next = null;
//        return dummy.next;
//    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 1; // number of nodes
        ListNode newNode = head, tail = head;

        while (tail.next != null) { // get the number of nodes in the list
            tail = tail.next;
            len++;
        }
        tail.next = head; // circle the link

        if ((k %= len) > 0) {
           for (int i = 0; i < len - k; i++) {
              tail = tail.next; //  the tail node is the (len - k) th node(1st node is head)
           }
        }
        newNode = tail.next;
        tail.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        SixOne sixOne = new SixOne();
        sixOne.rotateRight(node1, 2);
    }
}

package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-05 20:22
 * @description: 24
 **/
public class TwoFour {
//    public static ListNode swapPairs(ListNode head) {
//        if ((head == null) || (head.next == null)) {
//            return head;
//        }
//        ListNode n = head.next;
//        head.next = swapPairs(head.next.next);
//        n.next = head;
//        return n;
//    }


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

//    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node3.next = node4;
//        node2.next = node3;
//        node1.next = node2;
//
//        ListNode result =  TwoFour.swapPairs(node1);
//    }
}

package com.leetcode;

import com.entity.ListNode;
import com.john.LinkedList;

/**
 * @author: John
 * @date: 2020-01-29 10:02
 * @description: 25
 **/
public class TwoFive {
    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    /**
     * recursion solution
     *
     * @param head
     * @param k
     * @return
     */
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode curr = head;
//        int count = 0;
//        while (curr != null && count != k) {
//           curr = curr.next;
//           count++;
//        }
//        if (count == k) {
//            curr = reverseKGroup(curr, k);
//            while (count-- > 0) {
//                ListNode tmp = head.next;
//                head.next = curr;
//                curr = head;
//                head = tmp;
//            }
//            head = curr;
//        }
//        return head;
//    }


//    public static ListNode reverseKGroup(ListNode head, int k) {
//        int n = 0;
//        for (ListNode i = head; i != null; n++, i = i.next) {};
//
//        ListNode dmy = new ListNode(0);
//        dmy.next = head;
//        for (ListNode prev = dmy, tail = head; n >= k; n -= k) {
//            for (int i = 1; i < k; i++) {
//                ListNode next = tail.next.next;
//                tail.next.next = prev.next;
//                prev.next = tail.next;
//                tail.next = next;
//            }
//            prev = tail;
//            tail = tail.next;
//        }
//        return dmy.next;
//    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i = 0;
        while (head != null) {
            i++;
            if (i% k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
    }

    public static ListNode reverse(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    public static void main(String[] args) {
//        Node node2 = new Node(0);
//        Node node3 = new Node(4);
//        Node node4 = new Node(5);
//        Node node5 = new Node(1);
//        Node node = new Node(1);
//        Node node2 = new Node(4);
//        Node node3 = new Node(3);
//        Node node4 = new Node(2);
//        Node node5 = new Node(5);
//        Node node6 = new Node(2);

//        Node node = new Node(7);
//        Node node2 = new Node(9);
//        Node node3 = new Node(1);
//        Node node4 = new Node(8);
//        Node node5 = new Node(5);
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        Node node6 = new Node(6);
//        Node node7 = new Node(7);
//        Node node8 = new Node(8);


        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        Node node = new Node(1).next
//                = new Node(2).next
//                = new Node(3).next
//                = new Node(4).next
//                = new Node(5).next
//                = new Node(6).next
//                = new Node(7).next
//                = new Node(8).next
//                = null;
//        Node result = linkedList.reverseKNodes1(node, 2);
      ListNode result =   TwoFive.reverseKGroup(node, 3);
    }
}

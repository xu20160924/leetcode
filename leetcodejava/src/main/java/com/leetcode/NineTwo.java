package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-05 13:29
 * @description: 92
 **/
public class NineTwo {
//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        for (int i = 0; i < m - 1; i++) {
//            pre = pre.next;
//        }
//        ListNode start = pre.next;
//        ListNode then = start.next;
//        for (int i = 0; i < n - m; i++) {
//            start.next = then.next;
//            then.next = pre.next;
//            pre.next = then;
//            then = start.next;
//        }
//        return dummy.next;
//    }

    private boolean stop;
    private ListNode left;

    /**
     * recursion and reback
     * @param
     * @param m
     * @param n
     * @return
     */
//    public void recurseAndReverse(ListNode right, int m, int n) {
//        if (n == 1) {
//            return;
//        }
//        if (m > 1) {
//            left = left.next;
//        }
//        right = right.next;
//        recurseAndReverse(right, m-1, n-1);
//        if (right==left || right.next==left) {
//            stop = true;
//        }
//        if (!stop) {
//            int temp = right.val;
//            right.val = left.val;
//            left.val = temp;
//            left = left.next;
//        }
//    }
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        this.left = head;
//        this.stop = false;
//        recurseAndReverse(head, m, n);
//        return head;
//    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = cur;
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = prev;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }


    /**
     * myself has problems
     * @param args
     */
//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode(0);
//        ListNode headDummy = head;
//        int index = 1;
//        while (head != null) {
//            if (index >= m && index <= n) {
//                dummy = head.next;
//                dummy.next = head;
//                head.next = dummy.next;
////                head.next = dummy;
//            }
//            index++;
//            head = head.next;
////            dummy = head;
//        }
//        return headDummy;
//    }

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        four.next = five;
        three.next = four;
        two.next = three;
        input.next = two;

        ListNode result = NineTwo.reverseBetween(input, 1, 5);
    }
}

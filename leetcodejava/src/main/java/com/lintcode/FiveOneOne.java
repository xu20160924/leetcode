package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-08 15:43
 * @description: 511
 **/
public class FiveOneOne {

    /**
     * 直接交换值 比较简单  但一般都要求交换节点
     */
//    public ListNode swapNodes(ListNode head, int v1, int v2) {
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode node1 = null, node2 = null;
//        while (head != null) {
//            if (head.val == v1) {
//                node1 = head;
//            }
//            if (head.val == v2) {
//                node2 = head;
//            }
//            head = head.next;
//        }
//
//        if (node1 == null || node2 == null) {
//            return dummy.next;
//        }
//        int temp = node1.val;
//        node1.val = node2.val;
//        node2.val = temp;
//
//        return dummy.next;
//    }

//    public ListNode swapNodes(ListNode head, int v1, int v2) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode node1Prev = null, node2Prev = null;
//        ListNode cur = dummy;
//        while (cur.next != null) {
//            if (cur.next.val == v1) {
//                node1Prev = cur;
//            } else if (cur.next.val == v2) {
//                node2Prev = cur;
//            }
//            cur = cur.next;
//        }
//        if (node1Prev == null || node2Prev == null) {
//            return head;
//        }
//        if (node2Prev.next == node1Prev) {
//            ListNode t = node1Prev;
//            node1Prev = node2Prev;
//            node2Prev = t;
//        }
//
//        ListNode node1 = node1Prev.next;
//        ListNode node2 = node2Prev.next;
//        ListNode node2Next = node2.next;
//        if (node1Prev.next == node2Prev) {
//            node1Prev.next = node2;
//            node2.next = node1;
//            node1.next = node2Next;
//        } else {
//            node1Prev.next = node2;
//            node2.next = node1.next;
//            node2Prev.next = node1;
//            node1.next = node2Next;
//        }
//        return dummy.next;
//    }
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }
        if (node1Prev == null || node2Prev == null) {
            return head;
        }
        if (node2Prev.next == node1Prev) {
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;
            node2Prev.next = node1;
            node1.next = node2Next;
        }

//        ListNode nextNext = node1Prev.next.next;
//        node1Prev.next.next = node2Prev.next.next;
//        node2Prev.next.next = nextNext;
//
//        ListNode next = node1Prev.next;
//        node1Prev.next = node2Prev.next;
//        node2Prev.next = next;
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        three.next = four;
//        two.next = three;
//        one.next = two;

        ListNode ten = new ListNode(10);
        ListNode eight = new ListNode(8);
        ListNode seven = new ListNode(7);
        ListNode six = new ListNode(6);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);

        four.next = three;
        six.next = four;
        seven.next = six;
        eight.next = seven;
        ten.next = eight;



        FiveOneOne fiveOneOne = new FiveOneOne();
        fiveOneOne.swapNodes(ten, 7, 8);
    }
}

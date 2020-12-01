package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-18 10:51
 * @description: 160
 **/
public class OneSixZero {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA == null || headB == null) {
           return null;
       }
       ListNode a = headA;
       ListNode b = headB;

       while (a != b) {
          a = a == null ? headB : a.next;
          b = b == null ? headA : b.next;
       }
       return a;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        ListNode l11 = new ListNode(5);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(8);
        ListNode l15 = new ListNode(4);
        ListNode l16 = new ListNode(5);

        l4.next = l5;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;

        l15.next = l16;
        l14.next = l15;
        l13.next = l14;
        l12.next = l13;
        l11.next = l12;

        OneSixZero oneSixZero = new OneSixZero();
        oneSixZero.getIntersectionNode(l1, l11);
    }
}

package com.leetcode.jianzhioffer;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-05-19 17:43
 * @description: 24
 **/
public class TwoFour {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head.next = head2;

        TwoFour twoFour = new TwoFour();
        twoFour.reverseList(head);
    }
}

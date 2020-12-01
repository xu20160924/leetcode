package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-08 13:08
 * @description: 36
 **/
public class ThreeSix {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}

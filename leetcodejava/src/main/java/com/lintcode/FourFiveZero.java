package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-07 17:06
 * @description: 450
 **/
public class FourFiveZero {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseNextKNodes(prev, k);
        }
        return dummy.next;
    }

    private ListNode reverseNextKNodes(ListNode head, int k) {
        ListNode curt = head;
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++) {
            curt = curt.next;
            if (curt == null) {
                return null;
            }
        }

        ListNode nk = curt;
        ListNode nkplus = curt.next;

        // reverse
        ListNode prev = head;
        curt = head.next;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }
}

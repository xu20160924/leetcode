package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-09 12:12
 * @description: 102
 **/
public class OneZeroTwo {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

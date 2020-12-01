package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-05 11:38
 * @description: 142
 **/
public class OneFourTwo {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                   slow = slow.next;
                   slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}

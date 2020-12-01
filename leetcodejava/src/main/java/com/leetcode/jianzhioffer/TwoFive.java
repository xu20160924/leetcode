package com.leetcode.jianzhioffer;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-05-19 19:52
 * @description: 25
 **/
public class TwoFive {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

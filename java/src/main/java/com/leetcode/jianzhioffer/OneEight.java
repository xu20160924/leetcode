package com.leetcode.jianzhioffer;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-05-19 15:53
 * @description: 18
 **/
public class OneEight {

    /**
     * 单指针
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 双指针
     * @param head
     * @param val
     * @return
     */
//    public ListNode deleteNode(ListNode head, int val) {
//        if (head.val == val) {
//           return head.next;
//        }
//        ListNode pre = head, cur = head.next;
//        while (cur != null && cur.val != val) {
//           pre = cur;
//           cur = cur.next;
//        }
//        if (cur != null) {
//            pre.next = cur.next;
//        }
//        return head;
//    }
}

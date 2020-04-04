package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-04 19:23
 * @description: 21
 **/
public class TwentyOne {
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
////        ListNode result = new ListNode(0);
////        ListNode head = result;
//
//        ListNode dummy = l1;
//        while (l1 != null && l2!= null) {
//            if (l1.val < l2.val) {
//                int temp = l1.val;
//                l1.next.val = l2.val;
//                l2.val = temp;
//                if (l1.next == l2) {
//                    l2 = l2.next;
//                }
//            }
//            l1 = l1.next;
//        }
//        return dummy;
//    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
       ListNode l1 = null;
       ListNode l2 = new ListNode(0);
       TwentyOne.mergeTwoLists(l1, l2);
    }
}

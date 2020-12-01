package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-01-28 15:34
 * @description: 86
 **/
public class EightSix {
//    public ListNode partition(ListNode head, int x) {
//        // before and after are the two pointers used to create the two list
//        // before_head and after_head are used to save the heads of the two lists
//        // All of these are initialized with the dummy nodes created
//        ListNode before_head = new ListNode(0);
//        ListNode before = before_head;
//        ListNode after_head = new ListNode(0);
//        ListNode after = after_head;
//
//        while (head != null) {
//            // If the original list node is lesser than the given x
//            // assign it to the before list
//            if (head.val < x) {
//                before.next = head;
//                before = before.next;
//            } else {
//                // If the original list node is greater or equal to the given x
//                after.next = head;
//                after = after.next;
//            }
//            // move ahead in the original list
//            head = head.next;
//        }
//
//        // Last node of "after" list would also be ending node of the reformed list
//        after.next = null;
//
//        // Once all the nodes are correctly assigned to the two lists
//        // combine them to form a signle list which would be returned
//        before.next = after_head.next;
//        return before_head.next;
//    }

    public ListNode partition(ListNode head, int x) {

        ListNode dummyLessHead = new ListNode(0);
        ListNode dummyLess = dummyLessHead;
        ListNode dummyGreaterHead = new ListNode(0);
        ListNode dummyGreater = dummyGreaterHead;

        if (head == null) {
           return head;
        }

        while (head != null) {
            if (head.val < x) {
                dummyLess.next = head;
                dummyLess = dummyLess.next;
            } else {
                dummyGreater.next = head;
                dummyGreater = dummyGreater.next;
            }
            head = head.next;
        }
        dummyGreater.next = null;

        dummyLess.next = dummyGreaterHead.next;
        return dummyLessHead.next;
    }

//    public ListNode partition(ListNode head, int x) {
//       // before and after are the two pointers used to create the two list
//       // before_head and after_head are used to save the heads of the two lists.
//       // All of these are initialized with the dummy nodes created.
//       ListNode before_head = new ListNode(0);
//
//    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode five = new ListNode(5);
        ListNode twotwo = new ListNode(2);
        five.next = twotwo;
        two.next = five;
        three.next = two;
        four.next = three;
        one.next = four;

        EightSix eightSix = new EightSix();
        eightSix.partition(one, 3);
    }
}

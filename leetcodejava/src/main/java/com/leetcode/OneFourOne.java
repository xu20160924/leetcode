package com.leetcode;

import com.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-01-30 14:02
 * @description: 141
 **/
public class OneFourOne {

//    public static boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }
//
//    public static boolean hasCycleTwoPointer(ListNode head) {
//        if (head == null || head.next == null) {
//            return false;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next;
//        while (slow != fast) {
//            if (fast == null || fast.next == null) {
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }
//
//    public static boolean hasCycyleTwoPointer2(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                return true;
//            }
//        }
//        return false;
//    }

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

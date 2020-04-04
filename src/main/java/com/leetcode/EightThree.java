package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-17 11:42
 * @description: 83
 **/
public class EightThree {

    public ListNode deleteDuplicates(ListNode head) {
       ListNode current = head;
       while (current != null && current.next != null) {
           if (current.next.val == current.val) {
               current.next = current.next.next;
           } else {
               current = current.next;
           }
       }
       return head;
    }
}

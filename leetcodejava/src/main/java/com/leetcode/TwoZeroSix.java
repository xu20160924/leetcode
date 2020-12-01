package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-07 16:03
 * @description: 206
 **/
public class TwoZeroSix {

//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }

//    public ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        while (head != null) {
//            ListNode temp = head.next;
//            head.next = prev;
//            prev = head;
//            head = temp;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
          return head;
       }
       ListNode p = reverseList(head.next);
       head.next.next = head;
       head.next = null;
       return p;
    }



    public static void main(String[] args) {
        TwoZeroSix twoZeroSix = new TwoZeroSix();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        twoZeroSix.reverseList(head);
    }
}

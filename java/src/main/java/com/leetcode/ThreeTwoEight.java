package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-03-24 21:33
 * @description: 328
 **/
public class ThreeTwoEight {
    //    public ListNode oddEvenList(ListNode head) {
//        ListNode firstHead = head;
//        ListNode secondHead = head.next;
//        while (head.next.next != null && head.next.next.next != null) {
//            head.next.next = head.next.next.next;
//            head.next = head.next.next;
//        }
//        if (head.next.next == null) {
//           head.next.next = secondHead;
//        }
//        if (head.next.next == null) {
//            head.next = head.next.next.next;
//            head.next = secondHead;
//        }
//        return firstHead;
//    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        four.next = five;
        three.next = four;
        two.next = three;
        one.next = two;

        ThreeTwoEight threeTwoEight = new ThreeTwoEight();
        threeTwoEight.oddEvenList(one);
    }
}

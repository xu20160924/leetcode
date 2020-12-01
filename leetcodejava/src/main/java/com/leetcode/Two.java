package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-14 16:46
 * @description: 2
 **/
public class Two {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) {
//                p = p.next;
//            }
//            if (q != null) {
//                q = q.next;
//            }
//        }
//        if  (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy1 = l1, dummy2 = l2;
        while ((l1 != null && l2 != null) || carry > 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
//            l1.val = l2.val = sum % 10;
            if (l1 != null) {
                l1.val = sum % 10;
            }
            if (l2 != null) {
                l2.val = sum % 10;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (l1 == null) {
            return dummy2;
        }
        return dummy1;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l111 = new ListNode(9);
        ListNode l1111 = new ListNode(9);
        ListNode l11111 = new ListNode(9);
        ListNode l111111 = new ListNode(9);
        ListNode l1111111 = new ListNode(9);
        l111111.next = l1111111;
        l11111.next = l111111;
        l1111.next = l11111;
        l111.next = l1111;
        l11.next = l111;
        l1.next = l11;

        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l222 = new ListNode(9);
        ListNode l2222 = new ListNode(9);
//        ListNode l222 = new ListNode(4);
        l222.next = l2222;
        l22.next = l222;
        l2.next = l22;

        Two two = new Two();
        ListNode a = two.addTwoNumbers(l1, l2);
    }
}

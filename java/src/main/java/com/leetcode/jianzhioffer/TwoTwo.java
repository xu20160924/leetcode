package com.leetcode.jianzhioffer;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-05-19 16:26
 * @description: 22
 **/
public class TwoTwo {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int t = 0;
        while (fast != null) {
            // 保持快慢指针之间相差k个, 即倒数
            if (t >= k) {
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head.next = head2;

        TwoTwo twoTwo = new TwoTwo();
        twoTwo.getKthFromEnd(head, 2);
    }

//    public ListNode getKthFromEnd(ListNode head, int k) {
//       ListNode former = head, latter = head;
//       for (int i = 0; i < k; i++) {
//           former = former.next;
//       }
//       while (former != null) {
//           former = former.next;
//           latter = latter.next;
//       }
//       return latter;
//    }
}

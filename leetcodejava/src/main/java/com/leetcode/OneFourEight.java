package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-01-28 09:40
 * @description: 148
 **/
public class OneFourEight {
//    public ListNode sortList(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int n = 0;
//        while (head != null) {
//            head = head.next;
//            n++;
//        }
//
//        for (int step = 1; step < n; step <<= 1) {
//            ListNode prev = dummy;
//            ListNode cur = dummy.next;
//            while (cur != null) {
//                ListNode left = cur;
//                ListNode right = split(left, step);
//                cur = split(right, step);
//                prev = merge(left, right, prev);
//            }
//        }
//        return dummy.next;
//    }
//
//    private ListNode split(ListNode head, int step) {
//        if (head == null) {
//           return null;
//        }
//        for (int i = 1; head.next!=null && i < step; i++) {
//            head = head.next;
//        }
//        ListNode right = head.next;
//        head.next = null;
//        return right;
//    }
//    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
//        ListNode cur = prev;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                cur.next = left;
//                left = left.next;
//            } else {
//                cur.next = right;
//                right = right.next;
//            }
//            cur = cur.next;
//        }
//        if (left != null) {
//            cur.next = left;
//        } else if (right != null) {
//            cur.next = right;
//        }
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        return cur;
//    }


//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // step 1. cut the list to two halves
//        ListNode prev = null, slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//           prev = slow;
//           slow = slow.next;
//           fast = fast.next.next;
//        }
//
//        prev.next = null;
//
//        // step 2. sort each half
//        ListNode l1 = sortList(head);
//        ListNode l2 = sortList(slow);
//
//        // step 3. merge l1 and l2
//        return merge(l1, l2);
//    }
//
//    public ListNode merge(ListNode l1, ListNode l2) {
//       ListNode l = new ListNode(0), p = l;
//       while (l1 != null && l2 != null) {
//          if (l1.val < l2.val) {
//              p.next = l1;
//              l1 = l1.next;
//          } else {
//              p.next = l2;
//              l2 = l2.next;
//          }
//          p = p.next;
//       }
//
//       if (l1 != null) {
//          p.next = l1;
//       }
//       if (l2 != null) {
//          p.next = l2;
//       }
//       return l.next;
//    }

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
           head = head.next;
           n++;
        }

        for (int step = 1; step < n; step <<= 1) {
           ListNode prev = dummy;
           ListNode cur = dummy.next;
           while (cur != null) {
              ListNode left = cur;
              ListNode right = split(left, step);
              cur = split(right, step);
              prev = merge(left, right, prev);
           }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int step) {
       if (head == null) {
            return null;
       }
       for (int i = 1; head.next != null && i < step; i++) {
           head = head.next;
       }
       ListNode right = head.next;
       head.next = null;
       return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
       ListNode cur = prev;
       while (left != null && right != null) {
          if (left.val < right.val) {
              cur.next = left;
              left = left.next;
          } else {
              cur.next = right;
              right = right.next;
          }
       }
       cur.next = (left != null) ? left : right;
       while (cur.next != null) {
          cur = cur.next;
       }
       return cur;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        OneFourEight oneFourEight = new OneFourEight();
        oneFourEight.sortList(listNode);
    }
}

package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-09 16:02
 * @description: 98
 **/
public class NineEight {
    // merge sort
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode mid = findMiddle(head);
//        ListNode right = sortList(mid.next);
//        mid.next = null;
//        ListNode left = sortList(head);
//
//        return merge(left, right);
//    }
//
//    private ListNode merge(ListNode head1, ListNode head2) {
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        while (head1 != null && head2 != null) {
//            if (head1.val < head2.val) {
//                tail.next = head1;
//                head1 = head1.next;
//            } else {
//                tail.next = head2;
//                head2 = head2.next;
//            }
//            tail = tail.next;
//        }
//
//        if (head1 != null) {
//            tail.next = head1;
//        } else {
//            tail.next = head2;
//        }
//        return dummy.next;
//    }
//
//
//    private ListNode findMiddle(ListNode head) {
//        ListNode slow = head, fast = head.next;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }

    /**
     * quick sort
     * @param head
     * @return
     */
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode mid = findMedian(head);
//
//        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
//        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
//        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
//
//        while (head != null) {
//            if (head.val < mid.val) {
//                leftTail.next = head;
//                leftTail = head;
//            } else if (head.val > mid.val) {
//                rightTail.next = head;
//                rightTail = head;
//            } else {
//                middleTail.next = head;
//                middleTail = head;
//            }
//            head = head.next;
//        }
//
//        leftTail.next = null;
//        middleTail.next = null;
//        rightTail.next = null;
//
//        ListNode left = sortList(leftDummy.next);
//        ListNode right = sortList(rightDummy.next);
//        return concat(left, middleDummy.next, right);
//    }
//
//    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
//        ListNode dummy = new ListNode(0), tail = dummy;
//
//        tail.next = left; tail = getTail(tail);
//        tail.next = middle; tail = getTail(tail);
//        tail.next = right; tail = getTail(tail);
//        return dummy.next;
//    }
//
//    private ListNode getTail(ListNode head) {
//       if (head == null) {
//          return null;
//       }
//       while (head.next != null) {
//          head = head.next;
//       }
//       return head;
//    }
//
//    private ListNode findMedian(ListNode head) {
//        ListNode slow = head, fast = head.next;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }


    /**
     * quick sort 2
     */
    class Pair {
        public ListNode first, second;

        public Pair(ListNode first, ListNode second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * The head of linked list.
     *
     * @param head
     * @return You should return the head of the sorted linked list，using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMedian(head); // O(n)
        Pair pair = partition(head, mid.val);  // O(n)

        ListNode left = sortList(pair.first);
        ListNode right = sortList(pair.second);

        getTail(left).next = right;  // O(n)
        return left;
    }
    // 1->2->3 return 2
    // 1->2 return 1
    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //
    private Pair partition(ListNode head, int value) {
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode equalDummy = new ListNode(0), equalTail = equalDummy;

        while (head != null) {
            if (head.val < value) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > value) {
                rightTail.next = head;
                rightTail = head;
            } else {
                equalTail.next = head;
                equalTail = head;
            }
            head = head.next;
        }

        leftTail.next = null;
        rightTail.next = null;
        equalTail.next = null;

        if (leftDummy.next == null && rightDummy.next == null) {
            ListNode mid = findMedian(equalDummy.next);
            leftDummy.next = equalDummy.next;
            rightDummy.next = mid.next;
            mid.next = null;
        } else if (leftDummy.next == null) {
            leftTail.next = equalDummy.next;
        } else {
            rightTail.next = equalDummy.next;
        }
        return new Pair(leftDummy.next, rightDummy.next);
    }

    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

//        ListNode two = new ListNode(2);
//        ListNode one = new ListNode(-1);
//        ListNode zero = new ListNode(0);
//        one.next = zero;
//        two.next = one;

        NineEight oneFourEight = new NineEight();
        ListNode result = oneFourEight.sortList(listNode);
        System.out.println("");
    }
}

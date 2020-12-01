package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-05 13:29
 * @description: 92
 **/
public class NineTwo {
//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        for (int i = 0; i < m - 1; i++) {
//            pre = pre.next;
//        }
//        ListNode start = pre.next;
//        ListNode then = start.next;
//        for (int i = 0; i < n - m; i++) {
//            start.next = then.next;
//            then.next = pre.next;
//            pre.next = then;
//            then = start.next;
//        }
//        return dummy.next;
//    }


    /**
     * recursion and reback
     * @param
     * @param m
     * @param n
     * @return
     */
//    public void recurseAndReverse(ListNode right, int m, int n) {
//        if (n == 1) {
//            return;
//        }
//        if (m > 1) {
//            left = left.next;
//        }
//        right = right.next;
//        recurseAndReverse(right, m-1, n-1);
//        if (right==left || right.next==left) {
//            stop = true;
//        }
//        if (!stop) {
//            int temp = right.val;
//            right.val = left.val;
//            left.val = temp;
//            left = left.next;
//        }
//    }
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        this.left = head;
//        this.stop = false;
//        recurseAndReverse(head, m, n);
//        return head;
//    }

//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode cur = head, prev = null;
//        while (m > 1) {
//            prev = cur;
//            cur = cur.next;
//            m--;
//            n--;
//        }
//        ListNode con = prev, tail = cur;
//        ListNode third = null;
//        while (n > 0) {
//            third = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = prev;
//            n--;
//        }
//
//        if (con != null) {
//            con.next = prev;
//        } else {
//            head = prev;
//        }
//        tail.next = cur;
//        return head;
//    }


    /**
     * myself has problems
     * @param args
     */
//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null) {
//            return null;
//        }
//        ListNode dummy = new ListNode(0);
//        ListNode headDummy = head;
//        int index = 1;
//        while (head != null) {
//            if (index >= m && index <= n) {
//                dummy = head.next;
//                dummy.next = head;
//                head.next = dummy.next;
////                head.next = dummy;
//            }
//            index++;
//            head = head.next;
////            dummy = head;
//        }
//        return headDummy;
//    }


    /**
     * myself
     *
     * @param args
     */
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prev = null;
//        int j = 0;
//        for (int i = 0; i <= n; i++) {
//            j++;
//            if (j >= m) {
//                prev = head;
//                prev.next = null;
//                head.next.next = prev;
//                prev = head.next;
//            }
//            head = head.next;
//        }
//        return dummy.next;
//    }

    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

//    public void recurseAndReverse(ListNode right, int m, int n) {
//        // base case. Dont proceed any further.
//        if (n == 1) {
//           return;
//        }
//
//        // Keep moving the right pointer one step forward until (n == 1)
//        right = right.next;
//
//        // Keep moving left pointer to the right until we reach the proper node
//        // from where the reversal is to start.
//        if (m > 1) {
//            this.left = this.left.next;
//        }
//
//        // Recurse with m and n reduced.
//        this.recurseAndReverse(right, m - 1, n - 1);
//
//        // In case both the pointers cross each other or become equal,
//        // we stop i.e. dont swap data any further. We are dont reversing at this point.
//        if (this.left == right || right.next == this.left) {
//            this.stop = true;
//        }
//
//        // Until the boolean stop is false， swap data between the two pointers
//        if (!this.stop) {
//            int t  = this.left.val;
//            this.left.val = right.val;
//            right.val = t;
//
//            // Move left one step to the right.
//            // The right pointer moves one step back via backtracking.
//            this.left = this.left.next;
//        }
//    }
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//       this.left = head;
//       this.stop = false;
//       this.recurseAndReverse(head, m, n);
//       return head;
//    }




//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        // Empty list
//        if (head == null) {
//            return null;
//        }
//        // Move the two pointers until they reach the proper starting point
//        // in the list.
//        ListNode cur = head, prev = null;
//        while (m > 1) {
//            prev = cur;
//            cur = cur.next;
//            m--;
//            n--;
//        }
//
//        // The two pointers that will fix the final connections.
//        ListNode con = prev, tail = cur;
//
//        // Iteratively reverse the nodes until n becomes 0.
//        ListNode third = null;
//        while (n > 0) {
//           third = cur.next;
//           cur.next = prev;
//           prev = cur;
//           cur = third;
//           n--;
//        }
//
//        // Adjust the final connections as explained in the algorithm
//        if (con == null) {
//            con.next = prev;
//        } else {
//            head = prev;
//        }
//        tail.next = cur;
//        return head;
//    }

//    ListNode successor = null;
//    public ListNode reverseN(ListNode head, int n) {
//        if (n == 1) {
//            successor = head.next;
//            return head;
//        }
//        ListNode last = reverseN(head.next, n - 1);
//        head.next.next = head;
//        head.next = successor;
//        return last;
//    }
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (m == 1) {
//            return reverseN(head, n);
//        }
//        head.next = reverseBetween(head.next, m -1, n - 1);
//        return head;
//    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);  // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to thebeginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1-2-3-4-5 ;  m = 2; n = 4 ----> pre = 1, start = 2, then = 3
        // dummy -> 1-> 2-> 3 -> 4 -> 5
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy -> 1 - 3- 2 -4 -5; pre = 1, start = 2, then = 4
        // second reversing: dunmmy -> 1 - 4- 3 - 2 - 5; pre = 1, start = 2, then 5 (finish)
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode input = new ListNode(1);
//        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//
//        four.next = five;
//        three.next = four;
//        two.next = three;
//        input.next = two;
//
//        NineTwo nineTwo = new NineTwo();
//        ListNode result = nineTwo.reverseBetween(input, 2, 4);
        ListNode seven = new ListNode(7);
        ListNode nine = new ListNode(9);
        ListNode two = new ListNode(2);
        ListNode ten = new ListNode(10);
        ListNode one = new ListNode(1);
        ListNode eight = new ListNode(8);
        ListNode six = new ListNode(6);

        eight.next = six;
        one.next = eight;
        ten.next = one;
        two.next = ten;
        nine.next = two;
        seven.next = nine;

        NineTwo nineTwo = new NineTwo();
        ListNode result = nineTwo.reverseBetween(seven, 3, 6);
    }
}

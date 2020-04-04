package com.leetcode;

import com.entity.ListNode;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-17 17:16
 * @description: 234
 **/
public class TwoThreeFour {
//    public boolean isPalidrome(ListNode head) {
//        List<Integer> vals = new ArrayList<>();
//        ListNode currentNode = head;
//        while (currentNode != null) {
//            vals.add(currentNode.val);
//            currentNode = currentNode.next;
//        }
//
//        int front = 0;
//        int back = vals.size() - 1;
//        while (front < back) {
//            if (!vals.get(front).equals(vals.get(back))) {
//                return false;
//            }
//            front++;
//            back--;
//        }
//        return true;
//    }

//    private ListNode frontPointer;
//    private boolean recursivelyCheck(ListNode currentNode) {
//        if (currentNode != null) {
//            if (!recursivelyCheck(currentNode.next)) {
//                return false;
//            }
//            if (frontPointer.val != currentNode.val) {
//                return false;
//            }
//            this.frontPointer = this.frontPointer.next;
//        }
//        return true;
//    }
//    public boolean isPalindrome(ListNode head) {
//        frontPointer = head;
//        return recursivelyCheck(head);
//    }



    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
           if (p1.val != p2.val) {
               result = false;
           }
           p1 = p1.next;
           p2 = p2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
           ListNode nextTemp = curr.next;
           curr.next = prev;
           prev = curr;
           curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
        three.next = four;
        two.next = three;
        one.next = two;
        TwoThreeFour solution = new TwoThreeFour();
        solution. isPalindrome(one);
    }
}

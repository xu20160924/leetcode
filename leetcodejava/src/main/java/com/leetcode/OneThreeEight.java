package com.leetcode;

import com.entity.RandomListNode;

import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * @author: John
 * @date: 2020-04-08 19:14
 * @description: 138
 **/
public class OneThreeEight {

//    public RandomListNode copyRandomList(RandomListNode head) {
//       RandomListNode iter = head, next;
//
//       // First round: make copy of each node,
//        // and link them together side-by-side in a single list.
//        while (iter != null) {
//            next = iter.next;
//            RandomListNode copy = new RandomListNode(iter.val);
//            iter.next = copy;
//            copy.next = next;
//
//            iter = next;
//        }
//
//        // Second round: assign random pointers for the copy nodes.
//        iter = head;
//        while (iter != null) {
//            if (iter.random != null) {
//                iter.next.random = iter.random.next;
//            }
//            iter = iter.next.next;
//        }
//
//        // Third round: restore the original list, and extract the copy list.
//        iter = head;
//        RandomListNode pseudoHead = new RandomListNode(0);
//        RandomListNode copy, copyIter = pseudoHead;
//
//        while (iter != null) {
//            next = iter.next.next;
//
//            // extract the copy
//            copy = iter.next;
//            copyIter.next = copy;
//            copyIter = copy;
//
//            // restore the original list
//            iter.next = next;
//            iter = next;
//        }
//
//        return pseudoHead.next;
//    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode c = head;
        while (c != null) {
            RandomListNode next = c.next;
            c.next = new RandomListNode(c.val);
            c.next.next = next;
            c = next;
        }

        c = head;
        while (c != null) {
            if (c.random != null) {
                c.next.random = c.random.next;
            }
            c = c.next.next;
        }

        c = head;
        RandomListNode copyHead = head.next;
        RandomListNode copy = copyHead;
        while (copy.next != null) {
            c.next = c.next.next;
            c = c.next;

            copy.next = copy.next.next;
            copy = copy.next;
        }
        c.next = c.next.next;
        return copyHead;
    }

    public static void main(String[] args) {
        RandomListNode seven = new RandomListNode(7);
        RandomListNode thirteen = new RandomListNode(13);
        RandomListNode eleven = new RandomListNode(11);
        RandomListNode ten = new RandomListNode(10);
        RandomListNode one = new RandomListNode(1);

        ten.next = one;
        eleven.next = ten;
        thirteen.next = eleven;
        seven.next = thirteen;

        thirteen.random = seven;
        eleven.random = one;
        ten.random = eleven;
        one.random = seven;

        OneThreeEight oneThreeEight = new OneThreeEight();
        oneThreeEight.copyRandomList(seven);

    }
}

package com.leetcode;

import com.entity.Node;

/**
 * @author: John
 * @date: 2020-03-22 08:36
 * @description: 430
 **/
public class FourThreeZero {

    // top-down traversa
//    public Node flatten(Node head) {
//        if (head == null) {
//            return head;
//        }
//        Node p = head;
//        while (p != null) {
//            // case 1. if no child proceed
//            if (p.child == null) {
//                p = p.next;
//                continue;
//            }
//
//            // case 2 got child, find the tail of the child and link it to p.next
//            Node temp = p.child;
//            // Find the tail of the child
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//            // Connect tail with p.next, if it is not null
//            temp.next = p.next;
//            if (p.next != null) {
//                p.next.prev = temp;
//            }
//            p.next = p.child;
//            p.child.prev = p;
//            p.child = null;
//        }
//        return head;
//    }

//    public Node flatten(Node head) {
//        Node res =flattentail(head);
//        return res;
//    }
    // Five situations
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next -flatten the child, connect it with the next, go next
//    private Node flattentail(Node head) {
//        if (head == null) { // case 1
//            return head;
//        }
//        if (head.child == null) {
//            if (head.next == null) {  // case 2
//                return head;
//            }
//            return flattentail(head.next); // case3
//        } else {
//            Node child = head.child;
//            head.child = null;
//            Node next = head.next;
//            Node childtail = flattentail(child);
//            head.next = child;
//            child.prev = head;
//            if (next != null) { // case 5
//                childtail.next = next;
//                next.prev = childtail;
//                return flattentail(next);
//            }
//            return childtail;
//        }
//    }


}

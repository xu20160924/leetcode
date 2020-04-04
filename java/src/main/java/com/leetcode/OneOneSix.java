package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-19 19:50
 * @description: 116
 **/
public class OneOneSix {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

}

package com.leetcode;


import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class OneOneSeven {

    static class Node {
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

//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        Node prev = root;
//        while (!queue.isEmpty()) {
//            Node node;
//            if (queue.peek() == null) {
//                node = queue.poll();
//                node.next = null;
//            }
//            node = queue.poll();
//            prev.next = node;
//            prev = node;
//            System.out.println(node.val);
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
////            boolean s = node.left == null ? queue.offer(null) : queue.offer(node.left);
////            boolean a = node.right == null ? queue.offer(null) : queue.offer(node.right);
//
//        }
//        return null;
//    }

//    public void connect(Node root) {
//        Node head = null;
//        Node prev = null;
//        Node cur = root;
//
//        while (cur != null) {
//            while (cur != null) { // iterate on the current level
//                // left child
//                if (cur.left != null) {
//                    if (prev != null) {
//                        prev.next = cur.left;
//                    } else {
//                        head = cur.left;
//                    }
//                    prev = cur.left;
//                }
//                if (cur.right != null) {
//                    if (prev != null) {
//                        prev.next = cur.right;
//                    } else {
//                        head = cur.right;
//                    }
//                    prev = cur.right;
//                }
//                cur = cur.next;
//            }
//            cur = head;
//            head = null;
//            prev = null;
//        }
//    }

    public Node connect(Node root) {
        helper(root);
        return root;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        Node cur = root;
        Node nextHead = new Node(0);
        Node prev = nextHead;
        while (cur != null) {
            if (cur.left != null) {
                prev.next = cur.left;
                prev = prev.next;
            }
            if (cur.right != null) {
                prev.next = cur.right;
                prev = prev.next;
            }

            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = nextHead.next;
                nextHead.next = null;
                prev = nextHead;
            }

        }

    }


    public static void main(String[] args) {
        Node two = new Node(2, new Node(4), new Node(5), null);
        Node three = new Node(3, null, new Node(7), null);
        Node root = new Node(1, two, three, null);
        OneOneSeven oneOneSeven = new OneOneSeven();
        Node a = oneOneSeven.connect(root);
        System.out.println("");
    }
}

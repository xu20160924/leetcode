package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FourTwoNine {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        helper(root, list, 0);
        return list;
    }

    private void helper(Node root, List<List<Integer>> list, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new LinkedList<>());
        }
        list.get(level).add(root.val);

        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, list, level + 1);
            }
        }
    }

    public static void main(String[] args) {
        FourTwoNine fourTwoNine = new FourTwoNine();
        List<Node> list = new ArrayList<>();
        List<Node> list1 = new ArrayList<>();
        list1.add(new Node(5, null));
        list1.add(new Node(6, null));
        Node three = new Node(3, list1);
        list.add(three);
        list.add(new Node(2, null));
        list.add(new Node(4, null));
        Node root = new Node(1, list);
        List<List<Integer>> a = fourTwoNine.levelOrder(root);
        System.out.println("");
    }
//    class Node {
//        public int val;
//        public List<Node> children;
//
//        public Node() {}
//
//        public Node(int _val) {
//            val = _val;
//        }
//
//        public Node(int _val, List<Node> _children) {
//            val = _val;
//            children = _children;
//        }
//    };
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//    }
//
//    private void helper(Node root, List<List<Integer>> list) {
//
//    }
}

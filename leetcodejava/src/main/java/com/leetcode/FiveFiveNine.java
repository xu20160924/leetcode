package com.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-10-18 09:21
 * @description: 559
 **/
public class FiveFiveNine {
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
    };

//    Integer maxDepth;
//    public int maxDepth(Node root) {
//        maxDepth = Integer.MIN_VALUE;
//        helper(root, 0);
//        return maxDepth;
//    }
//
//    private void helper(Node root, int depth) {
//
//        if (root == null) {
//            return;
//        }
//        for (Node node : root.children) {
//            helper(node, depth + 1);
//        }
//
//        maxDepth = Math.max(maxDepth, depth);
//    }


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            int value = maxDepth(child);
            if (value > max) {
                max = value;
            }
        }
        return max + 1;
    }


    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(5, new ArrayList<>()));
        list.add(new Node(6, new ArrayList<>()));

        List<Node> list2 = new ArrayList<>();
        list2.add(new Node(3, list));
        list2.add(new Node(2, new ArrayList<>()));
        list2.add(new Node(4, new ArrayList<>()));

        Node root = new Node(1, list2);

        FiveFiveNine fiveFiveNine = new FiveFiveNine();
        fiveFiveNine.maxDepth(root);

    }

}

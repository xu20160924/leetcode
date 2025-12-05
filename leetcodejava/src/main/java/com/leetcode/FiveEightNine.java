package com.leetcode;


import com.entity.Node;

import java.util.*;

/**
 * @author: John
 * @date: 2020-10-19 11:23
 * @description: 589
 **/
public class FiveEightNine {
//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        helper(root, list);
//        return list;
//    }
//
//    private void helper(Node root, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        list.add(root.val);
//        for (Node node : root.children) {
//            helper(node, list);
//        }
//    }

//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
////            int size = queue.size();
//            Node node = queue.poll();
//            for (Node n : node.children) {
//                queue.add(n);
//            }
//            list.add(node.val);
//        }
//
//        return list;
//    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return list;
    }


    public static void main(String[] args) {
    }
}

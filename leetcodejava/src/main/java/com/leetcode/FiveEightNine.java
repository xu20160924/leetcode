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
        FiveEightNine fiveEightNine = new FiveEightNine();

        Node root = new Node(1);
        List<Node> list1 = new ArrayList<>();
        Node node3 = new Node(3);
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);

        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        List<Node> list2 = new ArrayList<>();
        list2.add(node5);
        list2.add(node6);

        node3.children = list2;
        root.children = list1;

        fiveEightNine.preorder(root);
    }
}

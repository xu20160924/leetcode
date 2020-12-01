package com.leetcode;

import com.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-20 17:27
 * @description: 590
 **/
public class FiveNineZero {
//    public List<Integer> postorder(Node root) {
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
//        for (Node n : root.children) {
//            helper(n, list);
//        }
//        list.add(root.val);
//    }


//    public List<Integer> postorder(Node root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//        Stack<Node> stack = new Stack<>();
//        stack.add(root);
//        Stack<Node> stack2 = new Stack<>();
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            for (Node n : node.children) {
//                stack.push(n);
//            }
//            stack2.push(node);
//        }
//        while (!stack2.isEmpty()) {
//            list.add(stack2.pop().val);
//        }
//        return list;
//    }


//    public List<Integer> postorder(Node root) {
//        List<Integer> list = new LinkedList<>();
//        if (root == null) {
//            return list;
//        }
//        Stack<Node> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            for (Node n : node.children) {
//                stack.push(n);
//            }
//            list.add(0, node.val);
//        }
//
//        return list;
//    }


    public static void main(String[] args) {
        FiveNineZero fiveNineZero = new FiveNineZero();
        Node five = new Node(5, new ArrayList<>());
        Node six = new Node(6, new ArrayList<>());
        List<Node> l1 = new ArrayList<>();
        l1.add(five);
        l1.add(six);
        Node node = new Node(3, l1);

        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());

        List<Node> l2 = new ArrayList<>();
        l2.add(node);
        l2.add(two);
        l2.add(four);
        Node root = new Node(1, l2);

//        fiveNineZero.postorder(root);

    }
}

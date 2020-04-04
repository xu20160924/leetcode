package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-01 13:05
 * @description: 94
 **/
public class NineFour {
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//    public static void helper(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//            helper(root.left, res);
//        res.add(root.val);
//            helper(root.right, res);
//    }

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()) {
//           while (curr != null) {
//               stack.push(curr);
//               curr = curr.left;
//           }
//           curr = stack.pop();
//           res.add(curr.val);
//           curr = curr.right;
//        }
//        return res;
//    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);

        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;
        root.left = two;
        root.right = six;
        NineFour.inorderTraversal(root);
    }
}

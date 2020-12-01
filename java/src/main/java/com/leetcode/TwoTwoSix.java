package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-04 17:46
 * @description: 226
 **/
public class TwoTwoSix {
    // recursive
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode right = invertTree(root.right);
//        TreeNode left = invertTree(root.left);
//        root.left = right;
//        root.right = left;
//        return root;
//    }

    // iterative
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }

//    private void helper(TreeNode root) {
//        if (root.left == null && root.right == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            return;
//        }
//        helper(root.left);
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//        helper(root.right);
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;
        root.left = two;
        root.right = seven;
        TwoTwoSix twoTwoSix = new TwoTwoSix();
        twoTwoSix.invertTree(root);
    }
}

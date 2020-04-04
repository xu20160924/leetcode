package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-01 18:38
 * @description: 145
 **/
public class OneFourFive {
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
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
        OneFourFive.postorderTraversal(root);

    }

}

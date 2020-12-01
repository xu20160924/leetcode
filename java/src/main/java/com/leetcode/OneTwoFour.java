package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-02-23 16:28
 * @description: 124
 **/
public class OneTwoFour {

//    public int maxPathSum(TreeNode root) {
//        int[] max = new int[1];
//        max[0] = Integer.MIN_VALUE;
//        maxPathSum(max, root);
//        return max[0];
//    }
//
//    private int maxPathSum(int[] max, TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftMax = Math.max(0, maxPathSum(max, root.left));
//        int rightMax = Math.max(0, maxPathSum(max, root.right));
//        max[0] = Math.max(max[0], root.val + leftMax + rightMax);
//        return root.val + Math.max(leftMax, rightMax);
//    }

    int maxValue = Integer.MIN_VALUE;

//    public int maxPathSum(TreeNode root) {
//
//    }
//
//    private int helper(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int left = Math.max(0, helper(node.left));
//        int right = Math.max(0, helper(node.right));
//        maxValue = Math.max(maxValue, left + right + node.val);
//        return Math.max(left, right) + node.val;
//    }

//    public static void main(String[] args) {
//        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        one.left = two;
//        one.right = three;
//        OneTwoFour oneTwoFour = new OneTwoFour();
//        oneTwoFour.maxPathSum(one);
//    }
}

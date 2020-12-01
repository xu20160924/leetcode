package com.leetcode;

import com.entity.TreeNode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-02 19:08
 * @description: 230
 **/
public class TwoThreeZero {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-20 18:10
 * @description: 701
 **/
public class SevenZeroOne {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        helper(root, val, root);
        return root;
    }
    private void helper(TreeNode root, int val, TreeNode par) {
        if (root == null) {
            return;
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            }
            helper(root.left, val, root);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            }
            helper(root.right, val, root);
        }
    }
}

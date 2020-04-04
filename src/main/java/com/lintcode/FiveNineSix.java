package com.lintcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-03-21 09:29
 * @description: 596
 **/
public class FiveNineSix {
    private int subtreeSum = Integer.MAX_VALUE;
    private TreeNode subtree = null;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    //1. return root's sum
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // divide + conquer + merge
        int sum = helper(root.left) + helper(root.right) + root.val;

        if (sum < subtreeSum) {
            subtreeSum = sum;
            subtree = root;
        }
        return sum;
    }
}

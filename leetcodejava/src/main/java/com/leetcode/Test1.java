package com.leetcode;

/**
 * @author: John
 * @date: 2020-09-17 13:18
 * @description:
 **/
public class Test1 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        if (k == 0) {
            return root.left == null ? root.right.val : root.left.val;
        }
        return kthSmallest(root.left != null ? root.left : root.right, k--);
    }
}

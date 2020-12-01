package com.leetcode;

import com.entity.TreeNode;

public class NineNine {
    public void morrisTraversal(TreeNode root) {
        TreeNode temp = null;
        while (root != null) {
            if (root.left != null) {
                // connect threading for root
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                // the threading already exists
                if (temp.right != null) {
                    temp.right = null;

                } else {
                    temp.right = root;
                    root = root.left;
                }
            }
        }
    }

}

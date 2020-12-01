package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-05-20 17:04
 * @description: 28
 **/
public class TwoEight {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
             return true;
        }
        if (L == null || R == null || !L.val.equals(R.val)) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}

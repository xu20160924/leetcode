package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-30 14:09
 * @description: 965
 **/
public class NineSixFive {
//    public boolean isUnivalTree(TreeNode root) {
//       helper(root, root.val);
//       return flag;
//    }
//
//    boolean flag = true;
//    private void helper(TreeNode root, int par) {
//        if (root == null) {
//            return;
//        }
//        if (root.val != par) {
//            flag = false;
//        }
//        helper(root.left, root.val);
//        helper(root.right, root.val);
//    }

    public boolean isUnivalTree(TreeNode root) {
        boolean leftCorrect = (root.left == null || root.val == root.left.val && isUnivalTree(root.left));
        boolean rightCorrect = (root.right == null || root.val == root.right.val && isUnivalTree(root.right));
        return leftCorrect && rightCorrect;
    }

}

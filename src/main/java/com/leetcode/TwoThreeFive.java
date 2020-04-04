package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-02-21 12:14
 * @description: 235
 **/
public class TwoThreeFive {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        int parentVal = root.val;
//        int pVal = p.val;
//        int qVal = q.val;
//        if (pVal > parentVal && qVal > parentVal) {
//            return lowestCommonAncestor(root.right, p, q);
//        } else if (pVal < parentVal && qVal < parentVal) {
//            return lowestCommonAncestor(root.left, p, q);
//        } else {
//            return root;
//        }
//    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null) {
            if (pVal < node.val && qVal < node.val) {
                node = node.right;
            } else if (pVal > node.val && qVal > node.val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}

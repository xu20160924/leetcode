package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-20 18:01
 * @description: 700
 **/
public class SevenZeroZero {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
           return root;
        }
//        if (val > root.val) {
//           return searchBST(root.right, val);
//        } else {
//           return searchBST(root.left, val);
//        }
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }

    public static void main(String[] args) {
        SevenZeroZero sevenZeroZero = new SevenZeroZero();
        TreeNode root = TreeNode.getTreeNode(new Integer[]{4,2,7,1,3});
        TreeNode a = sevenZeroZero.searchBST(root, 2);
        System.out.println("");
        /**
         *
         * 2
         */
    }
}

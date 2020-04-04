package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-01-20 18:01
 * @description: 156
 **/
public class OneFiveSix {
    /**
     * recursion
     * @param root
     * @return
     */
//    public static TreeNode upsideDownBinaryTree(TreeNode root) {
//        if (root == null || root.left == null) {
//            return root;
//        }
//        TreeNode newRoot = upsideDownBinaryTree(root.left);
//        root.left.left = root.right;
//        root.left.right = root;
//        root.left = null;
//        root.right = null;
//        return newRoot;
//    }

    /**
     * iterative
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode tmp = null;
        TreeNode next = null;
        while (cur != null) {
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;

            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

//        TreeNode newTreeNode = upsideDownBinaryTree(treeNode);

    }
}

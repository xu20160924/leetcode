package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-16 09:44
 * @description: 814
 **/
public class EightOneFour {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        System.out.println(root.val);

        if (root.val == 0) {
            if (root.left != null || root.right != null) {
                return root;
            } else {
                return null;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        EightOneFour eightOneFour = new EightOneFour();
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,0,1,0,0,0,1});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,null,0,0,1});
        TreeNode root = TreeNode.getTreeNode(new Integer[]{0,null,0,1,1,null,1,null,1,null,null,null,null});
        TreeNode a = eightOneFour.pruneTree(root);
        System.out.println("");
    }
}

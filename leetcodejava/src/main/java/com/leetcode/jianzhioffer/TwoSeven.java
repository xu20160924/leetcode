package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-05-20 11:20
 * @description: 27
 **/
public class TwoSeven {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;
        root.left = two;
        root.right = seven;

        TwoSeven twoSeven = new TwoSeven();
        twoSeven.mirrorTree(root);
    }
}

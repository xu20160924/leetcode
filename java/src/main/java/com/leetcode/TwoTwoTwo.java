package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-01-31 17:27
 * @description: 222
 **/
public class TwoTwoTwo {
    public static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
//    public int countNodes(TreeNode root) {
//        int h = height(root);
//        return h < 0 ? 0 :
//                height(root.right) == h - 1 ?
//                        (1 << h) + countNodes(root.right) :
//                        (1 << h - 1) + countNodes(root.left);
//    }

    public static void main(String[] args) {
        System.out.println(1 << 3);
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }
    public static int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            root = root.left;
            level++;
        }
        return level;
    }
}

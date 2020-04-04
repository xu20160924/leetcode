package com.lintcode;

import com.entity.TreeNode;
import com.leetcode.Four;

/**
 * @author: John
 * @date: 2020-03-21 16:37
 * @description: 453
 **/
public class FourFiveThree {

    private TreeNode lastNode = null;

//    public void flatten(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (lastNode != null) {
//           lastNode.left = null;
//           lastNode.right = root;
//        }
//        lastNode = root;
//        TreeNode right = root.right;
//        flatten(root.left);
//        flatten(right);
//    }

//    public void flatten(TreeNode root) {
//        helper(root);
//
//    }
//
//    private TreeNode helper(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode leftLast = helper(root.left);
//        TreeNode rightLast = helper(root.right);
//
//        if (leftLast != null) {
//            leftLast.right = root.right;
//            root.right = root.left;
//            root.left = null;
//        }
//
//        if (rightLast != null) {
//            return rightLast;
//        }
//        if (leftLast != null) {
//            return leftLast;
//        }
//        return root;
//    }


    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        five.right = six;
        two.left = three;
        two.right = four;
        root.left = two;
        root.right = five;

        FourFiveThree fourFiveThree = new FourFiveThree();
        fourFiveThree.flatten(root);
        System.out.println("ss");
    }
}

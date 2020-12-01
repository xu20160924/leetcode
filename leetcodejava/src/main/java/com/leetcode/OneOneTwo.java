package com.leetcode;

import com.entity.TreeNode;

import java.util.TreeMap;

/**
 * @author: John
 * @date: 2020-02-12 13:14
 * @description: 112
 **/
public class OneOneTwo {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if ( sum-root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode rightFour = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        eleven.left = seven;
        eleven.right = two;
        rightFour.right = one;
        four.left = eleven;
        eight.left = thirteen;
        eight.right = rightFour;
        root.left = four;
        root.right = eight;

        OneOneTwo a = new OneOneTwo();
        System.out.println(a.hasPathSum(root, 22));
    }
}

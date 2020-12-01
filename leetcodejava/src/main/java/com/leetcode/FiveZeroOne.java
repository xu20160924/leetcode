package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-02-20 14:01
 * @description: 501
 **/
public class FiveZeroOne {
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes;
    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null) {
               modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode twotwo = new TreeNode(2);
//        two.left = twotwo;
//        root.right = two;

        TreeNode root = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode zero = new TreeNode(0);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);
        TreeNode twotwo = new TreeNode(2);
        TreeNode eighteight = new TreeNode(8);

        zero.left = twotwo;
        zero.right = eighteight;
        two.left = zero;
        two.right = four;
        eight.left = seven;
        eight.right = nine;
        root.left = two;
        root.right = eight;

        FiveZeroOne fiveZeroOne = new FiveZeroOne();
        int[] res = fiveZeroOne.findMode(root);
        System.out.println(res);
    }

}

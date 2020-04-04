package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-02-19 14:26
 * @description: 108
 **/
public class OneZeroEight {


    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
           return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}

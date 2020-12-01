package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-13 12:32
 * @description: 530
 **/
public class FiveThreeZero {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }

        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;
}

package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-02-03 09:49
 * @description: 543
 **/
public class FiveFourThree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}

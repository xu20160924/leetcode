package com.lintcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-03-21 08:05
 * @description: 97
 **/
public class NineSeven {
//    private int depth;
//    public int maxDepoth(TreeNode root) {
//        depth = 0;
//        helper(root, depth);
//        return depth;
//    }
//
//    private void helper(TreeNode node, int curtDepth) {
//        if (node == null) {
//            return;
//        }
//        if (curtDepth > depth) {
//            depth = curtDepth;
//        }
//        helper(node.left, curtDepth + 1);
//        helper(node.right, curtDepth + 1);
//    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

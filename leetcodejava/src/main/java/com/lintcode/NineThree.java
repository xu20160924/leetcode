package com.lintcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-03-21 09:49
 * @description: 93
 **/
public class NineThree {
    class ResultType {
        public boolean isBalanced;
        public int maxDepth;

        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

//    public boolean isBalanced(TreeNode root) {
//        return helper(root).isBalanced;
//    }
//
//    private ResultType helper(TreeNode root) {
//        if (root == null) {
//            return new ResultType(true, 0);
//        }
//        ResultType left = helper(root.left);
//        ResultType right = helper(root.right);
//
//        if (!left.isBalanced || right.isBalanced) {
//            return new ResultType(false, -1);
//        }
//
//        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
//            return new ResultType(false, -1);
//        }
//        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
//    }

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    private int maxDepth(TreeNode node) {
       if (node == null) {
           return 0;
       }
       int left = maxDepth(node.left);
       int right = maxDepth(node.right);
       if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
           return -1;
       }
       return Math.max(left, right) + 1;
    }
}

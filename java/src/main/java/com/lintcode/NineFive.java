package com.lintcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-03-21 15:12
 * @description: 95
 **/
public class NineFive {
    class ResultType {
        boolean is_bst;
        int maxValue, minValue;

        public ResultType(boolean is_bst, int maxValue, int minValue) {
            this.is_bst = is_bst;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }

    }
//    public boolean isValidBST(TreeNode root) {
//        ResultType resultType = validateHelper(root);
//        return resultType.is_bst;
//    }
//
//    private ResultType validateHelper(TreeNode root) {
//        if (root == null) {
//            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        }
//        ResultType left = validateHelper(root.left);
//        ResultType right = validateHelper(root.right);
//        if (!left.is_bst || !right.is_bst) {
//            return new ResultType(false, 0, 0);
//        }
//        if (root.left != null && left.maxValue >= root.val ||
//            root.right != null && right.minValue <= root.val) {
//            return new ResultType(false, 0, 0);
//        }
//        return new ResultType(true,
//                                Math.max(root.val, right.maxValue),
//                                Math.min(root.val, left.minValue));
//    }

    public boolean isValidBST(TreeNode root) {
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divConq(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return divConq(root.left, min, Math.min(root.val, max)) &&
                divConq(root.right, Math.max(min, root.val), max);
    }

    public static void main(String[] args) {
    }
}

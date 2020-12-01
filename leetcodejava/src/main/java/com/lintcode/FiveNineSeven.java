package com.lintcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-03-21 10:20
 * @description: 597
 **/
public class FiveNineSeven {
    private class ResultType {
        public int sum, size;

        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode maxAveSubtree = null;
    private ResultType subtreeResult = null;

    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxAveSubtree; 
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        ResultType rootResult = new ResultType(
                left.sum + right.size + root.val,
                left.size + right.size + 1
        );

        if (maxAveSubtree == null ||
                // Here because division is exact divide, dont include decimal,
                // so use cross multiplication to convert
                // subtreeResult.sum / subtreeResult.size < rootResult.sum / rootResult.size
            subtreeResult.sum * rootResult.size < rootResult.sum * subtreeResult.size) {
            maxAveSubtree = root;
            subtreeResult = rootResult;
        }
        return rootResult;
    }
}

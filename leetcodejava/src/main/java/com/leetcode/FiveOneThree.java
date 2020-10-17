package com.leetcode;

import com.entity.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class FiveOneThree {
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0, false);
        return maxLeft;
    }

    int maxLeft = 0, maxDepth = 0;

    private void helper(TreeNode root, int depth, boolean isLeft) {
        if (root.left == null && root.right == null && root != null) {
            maxLeft = root.val;
        }
        if (root == null) {
            return;
        }

        depth = depth + 1;
        maxDepth = Math.max(depth, maxDepth);
        helper(root.left, depth,true);
        helper(root.right, depth, false);
        if (isLeft && depth >= maxDepth) {
            maxLeft = root.val;
        }
    }

    public int findLeftMostNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }

    //    public int findBottomLeftValue(TreeNode root) {
//        maxLeft = root.val;
//        helper(root, 0);
//        return maxLeft;
//    }
//
//    int maxDepth = 0, maxLeft;
//    private void helper(TreeNode root, int depth) {
//        if (root == null) {
//            return;
//        }
//        if (depth >= maxDepth) {
//            maxLeft = root.val;
//        }
//        depth =  depth + 1;
//        maxDepth = Math.max(depth, maxDepth);
//        helper(root.left, depth);
//        helper(root.right, depth);
//    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        FiveOneThree fiveOneThree = new FiveOneThree();
        System.out.println(fiveOneThree.findBottomLeftValue(root));
    }
}

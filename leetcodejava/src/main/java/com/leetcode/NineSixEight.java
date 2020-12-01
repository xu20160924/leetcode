package com.leetcode;

import com.entity.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: John
 * @date: 2020-02-14 13:17
 * @description: 968
 **/
public class NineSixEight {
//    public int minCameraCover(TreeNode root) {
//        int[] ans = solve(root);
//        return Math.min(ans[1], ans[2]);
//    }
//
//    private int[] solve(TreeNode node) {
//        if (node == null) {
//            return new int[]{0, 0, 99999};
//        }
//        int[] L = solve(node.left);
//        int[] R = solve(node.right);
//        int mL12 = Math.min(L[1], L[2]);
//        int mR12 = Math.min(R[1], R[2]);
//
//        int d0 = L[1] + R[1];
//        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
//        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
//        return new int[]{d0, d1, d2};
//    }


//    public int minCameraCover(TreeNode root) {
//        helper(root, false);
//        return min;
//    }
//
//    int min = 0;
//    private void helper(TreeNode root, boolean flag) {
//       if (root == null) {
//           return;
//       }
//       if (flag) {
//           min += 1;
//       }
//        helper(root.left, !flag);
//        helper(root.right, !flag);
//    }


    /**
     * dp
     * @param root
     * @return
     */
//    public int minCameraCover(TreeNode root) {
//        int[] ans = solve(root);
//        return Math.min(ans[1], ans[2]);
//    }
//
//    // 0: Strict ST; All nodes below this are covered, but not this one
//    // 1: Normal ST; All nodes below and incl this are covered - no camera
//    // 2: Placed camera; All nodes below this are covered, plus camera here
//    private int[] solve(TreeNode node) {
//        if (node == null) {
//            return new int[]{0,0,99999};
//        }
//        int[] L = solve(node.left);
//        int[] R = solve(node.right);
//
//        int mL12 = Math.min(L[1], L[2]);
//        int mR12 = Math.min(R[1], R[2]);
//
//        int d0 = L[1] + R[1];
//        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
//        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
//        return new int[]{d0, d1, d2};
//    }


    /**
     * greedy
     *
     * @param root
     * @return
     */
//    int res;
//    Set<TreeNode> covered;
//
//    public int minCameraCover(TreeNode root) {
//        res = 0;
//        covered = new HashSet<>();
//        covered.add(null);
//
//        helper(root, null);
//        return res;
//    }
//
//    private void helper(TreeNode root, TreeNode par) {
//        if (root != null) {
//            helper(root.left, root);
//            helper(root.right, root);
//
////            if (par == null &&
////                    !covered.contains(root) ||
////                    !covered.contains(root.left) ||
////                    !covered.contains(root.right)) {
//            if ((par == null && !covered.contains(root))
//                    || !covered.contains(root.left) || !covered.contains(root.right) ) {
//                res++;
//                covered.add(root);
//                covered.add(par);
//                covered.add(root.left);
//                covered.add(root.right);
//            }
//        }
//    }

    int res;
    public int minCameraCover(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == 0 || right == 0) {
            res++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }
        if (left == 2 && right == 2) {
            return 0;
        }
        return -1;
    }


    public static void main(String[] args) {
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{0,0,null,0,0});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{0,0,null,0,null,0,null,null,0});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8});
        TreeNode root = TreeNode.getTreeNode(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        NineSixEight nineSixEight = new NineSixEight();
        System.out.println(nineSixEight.minCameraCover(root));
    }
}

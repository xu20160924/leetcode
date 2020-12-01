package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-15 15:40
 * @description: 687
 **/
public class SixEightSeven {
//    public int longestUnivaluePath(TreeNode root) {
//        return helper(root);
//    }
//
//    private int helper(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//
////        res = Math.max(res, helper(root.left) + helper(root.right));
//        int left = helper(root.left);
//        int right = helper(root.right);
//
//        int res = 0;
//        if (root.left != null && root.left.val == root.val) {
//            res += 1;
//        }
//        if (root.right != null && root.right.val == root.val) {
//            res += 1;
//        }
//        if (root.right != null && root.left != null && root.right.val == root.left.val && root.left.val == root.val) {
//            return left + right;
//        }
//
////        return (root.left.val == root.right.val && root.left.val == root.val) ?  Math.max(res + left, res + right) : res + left + right;
//        return Math.max(res + left, res + right);
////        return left + right + res;
//    }

//    int ans;
//    public int longestUnivaluePath(TreeNode root) {
//        ans = 0;
//        arrowLength(root);
//        return ans;
//    }
//
//    private int arrowLength(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        int left = arrowLength(node.left);
//        int right = arrowLength(node.right);
//        int arrowLeft = 0, arrowRight = 0;
//        if (node.left != null && node.left.val == node.val) {
//            arrowLeft += left + 1;
//            left++;
//        }
//        if (node.right != null && node.right.val == node.val) {
//            arrowRight += right + 1;
//            right++;
//        }
//        ans = Math.max(ans, left + right);
//        return Math.max(left, right);
//    }

//    int len = 0;
//    public int longestUnivaluePath(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        getLen(root, root.val);
//        return len;
//    }
//
//    private int getLen(TreeNode node, int val) {
//        if (node == null) {
//            return 0;
//        }
//        int left = getLen(node.left, node.val);
//        int right = getLen(node.right, node.val);
//        len = Math.max(len, left + right);
//        if (val == node.val) {
//            return Math.max(left, right) + 1;
//        }
//        return 0;
//    }

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) {
            dfs(root, res);
        }
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0;
        int r = node.right != null ? dfs(node.right, res) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.left != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }





//    public int longestUnivaluePath(TreeNode root) {
//        return helper(root);
//    }
//    int ans = 0;
//    private int helper(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int left = helper(root.left);
//        int right = helper(root.right);
//        if (root.left != null && root.left.val == root.val) {
//            left++;
//        }
//        if (root.right != null && root.right.val == root.val) {
//            right++;
//        }
//        ans = Math.max(ans, left + right);
//        return Math.max(left,  right);
//    }



    public static void main(String[] args) {
        SixEightSeven sixEightSeven = new SixEightSeven();
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,null,1,1,1,1,1,1});
        TreeNode root = TreeNode.getTreeNode(new Integer[]{5,4,5,4,4,5,3,4,4,null,null,null,4,null,null,4,null,null,4,null,4,4,null,null,4,4});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,4,5,4,4,5});
        System.out.println(sixEightSeven.longestUnivaluePath(root));
    }
}

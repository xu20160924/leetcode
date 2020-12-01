package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-09-08 08:37
 * @description: 129
 **/
public class OneTwoNine {

//    private static int sum = 0;
//
//    public int sumNumbers(TreeNode root) {
//        dfs(root, 0);
//        return sum;
//    }
//
//    private void dfs(TreeNode root, int val) {
//        if (root == null) {
//           return;
//        }
//        int k = (val * 10 + root.val);
//
//        if (root.left == null && root.right == null) {
//            sum += k;
//        }
//        dfs(root.left, val);
//        dfs(root.right, val);
//    }

//    private static int sum = 0;
//
//    public int sumNumbers(TreeNode root) {
//        dfs(root, 0);
//        return sum;
//    }
//
//    private void dfs(TreeNode root, int val) {
//        if (root == null) {
//            return;
//        }
//        val =  (val * 10 + root.val);
//
//        if (root.left == null && root.right == null) {
//            sum += val;
//        }
//        dfs(root.left, val);
//        dfs(root.right, val);
//    }

//    private static int sum = 0;
//
//    public int sumNumbers(TreeNode root) {
//        childSum(0, root);
//        return sum;
//    }
//
//    public static void childSum(int val, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        val = (val * 10 + root.val);
//        if (root.left == null && root.right == null) {
//            sum += val;
//        }
//        childSum(val, root.left);
//        childSum(val, root.right);
//    }

//    static int sum;
//    public int sumNumbers(TreeNode root) {
//        sum = 0;
//        childSum(0, root);
//        return sum;
//    }
//    public static void  childSum(int val, TreeNode root) {
//        if(root == null) return;
//        int k = (val * 10 + root.val) ;
//        if(root.left == null && root.right == null) {
//            sum += k;
//        }
//        childSum(k, root.left);
//        childSum(k, root.right);
//    }


    //    static int sum;
//    public int sumNumbers(TreeNode root) {
//        sum = 0;
//        childSum(0, root);
//        return sum;
//    }
//    public static void childSum(int val, TreeNode root) {
//       if (root == null) {
//           return;
//       }
//       int k = (val * 10 + root.val);
//       if (root.left == null && root.right == null) {
//           sum += k;
//       }
//       childSum(k, root.left);
//       childSum(k, root.right);
//    }

//    public int sumNumbers(TreeNode root) {
//
//    }
//
//    private int sum(TreeNode n, int s) {
//        if (n == null) {
//            return 0;
//        }
//        if (n.right == null && n.left == null) {
//            return s * 10 + n.val;
//        }
//        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
//    }
//
//    public static void main(String[] args) {
////        TreeNode root = new TreeNode(1);
////        root.left = new TreeNode(2);
////        root.right = new TreeNode(3);
//
//        TreeNode root = new TreeNode(4);
//
//        TreeNode nine = new TreeNode(9);
//        nine.left = new TreeNode(5);
//        nine.right = new TreeNode(1);
//
//        root.left = nine;
//        root.right = new TreeNode(0);
//        OneTwoNine oneTwoNine = new OneTwoNine();
//        System.out.println(oneTwoNine.sumNumbers(root));
//    }
}


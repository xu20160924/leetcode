package com.leetcode;

import com.entity.TreeNode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-13 14:10
 * @description: 538
 **/
public class FiveThreeEight {
//    public TreeNode converBST(TreeNode root) {
//
//        helper(root);
//        return root;
//    }
//    int prev = 0;
//    private void helper(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        helper(root.right);
//
//        prev += root.val;
//        System.out.println("cur:" + root.val + "-- prev:" + prev);
//        root.val = prev;
//
////        System.out.println("prev:" + prev);
//        helper(root.left);
//    }

//    public TreeNode convertBST(TreeNode root) {
//        dfs(root, 0);
//        return root;
//    }
//    public int dfs(TreeNode root, int val) {
//        if (root == null) {
//            return val;
//        }
//        int right = dfs(root.right, val);
//        int left = dfs(root.left, (root.val += right));
//        return left;
//    }

//    public TreeNode convertBST(TreeNode root) {
//        dfs(root, 0);
//        return root;
//    }
//    public int dfs(TreeNode root, int val) {
//        if(root == null) return val;
//        int right = dfs(root.right, val);
//        int left = dfs(root.left, root.val + right);
//        root.val = root.val + right;
//        return left;
//    }

//    public TreeNode convertBST(TreeNode root) {
//        int sum = 0;
//        TreeNode node = root;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//
//        while (!stack.isEmpty() || node != null) {
//            while (node != null) {
//                stack.add(node);
//                node = node.right;
//            }
//            node = stack.pop();
//            sum += node.val;
//            node.val = sum;
//            node = node.left;
//        }
//        return root;
//    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }
        return root;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode one = new TreeNode(1);
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        seven.right = eight;
        six.left = five;
        six.right = seven;
        two.right = three;
        one.right = two;
        one.left = zero;
        root.left = one;
        root.right = six;

        FiveThreeEight fiveThreeEight = new FiveThreeEight();
        TreeNode a = fiveThreeEight.convertBST(root);
        System.out.println("");
    }

}

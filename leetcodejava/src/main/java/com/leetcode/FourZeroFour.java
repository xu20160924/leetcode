package com.leetcode;

import com.entity.TreeNode;

import javax.crypto.spec.PSource;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-12 11:09
 * @description: 404
 **/
public class FourZeroFour {

//    int sum = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        helper(root);
//        return sum;
//    }
//
//    private void helper(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            helper(root.left);
//            sum += root.val;
//        }
//        sum -= root.val;
////        if (root.left == null && root.right == null) {
////            sum += root.val;
////        }
//        if (root.right != null) {
//            helper(root.right);
//        }
//    }


//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int res = 0;
//        if (root.left != null && root.left.left == null && root.left.right == null) {
//            res += root.left.val;
//        }
//        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
//    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int ans = 0;
//        if (root.left != null) {
//            if (root.left.left == null && root.left.right == null) {
//                ans += root.left.val;
//            } else {
//                ans += sumOfLeftLeaves(root.left);
//            }
//        }
//
//        ans += sumOfLeftLeaves(root.right);
//        return ans;
//    }

//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root == null) return 0;
//        int ans = 0;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//
//        while(!stack.empty()) {
//            TreeNode node = stack.pop();
//            if(node.left != null) {
//                if (node.left.left == null && node.left.right == null)
//                    ans += node.left.val;
//                else
//                    stack.push(node.left);
//            }
//            if(node.right != null) {
//                if (node.right.left != null || node.right.right != null)
//                    stack.push(node.right);
//            }
//        }
//        return ans;
//    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                if (node.left.left == null && node.right.left == null) {
                    ans += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left = four;
        two.right = five;
        root.left = two;
        root.right = three;


        FourZeroFour fourZeroFour = new FourZeroFour();
        System.out.println(fourZeroFour.sumOfLeftLeaves(root));

    }
}

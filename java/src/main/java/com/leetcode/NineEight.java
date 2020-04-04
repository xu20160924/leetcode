package com.leetcode;

import com.entity.TreeNode;

import java.nio.file.ClosedWatchServiceException;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-02 19:17
 * @description: 98
 **/
public class NineEight {

//    public static boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode pre = null;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (pre != null && pre.val > root.val) {
//                return false;
//            }
//            pre = root;
//            root = root.right;
//        }
//        return true;
//    }

//    LinkedList<TreeNode> stack = new LinkedList<>();
//    LinkedList<Integer> uppers = new LinkedList<>(), lowers = new LinkedList<>();
//
//    public void update(TreeNode root, Integer lower, Integer upper) {
//        stack.add(root);
//        lowers.add(lower);
//        uppers.add(upper);
//    }
//    public boolean isValidBST(TreeNode root) {
//        Integer lower = null, upper = null, val;
//        update(root, lower, upper);
//
//        while (!stack.isEmpty()) {
//            root = stack.poll();
//            lower = lowers.poll();
//            upper = uppers.poll();
//            if (root == null) {
//                continue;
//            }
//            val = root.val;
//            if (lower != null && val <= lower) {
//                return false;
//            }
//            if (upper != null && val >= upper) {
//                return false;
//            }
//            update(root.left, lower, val);
//            update(root.right, val, upper);
//        }
//        return true;
//    }


    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int inorder = Integer.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.add(root.left);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}

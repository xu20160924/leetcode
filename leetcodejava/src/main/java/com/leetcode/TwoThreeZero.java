package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: John
 * @date: 2020-02-02 19:08
 * @description: 230
 **/
public class TwoThreeZero {
//    public static int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (--k == 0) {
//                break;
//            }
//            root = root.right;
//        }
//        return root.val;
//    }

//    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
//        if (root == null) {
//            return arr;
//        }
//        inorder(root.left, arr);
//        arr.add(root.val);
//        inorder(root.right, arr);
//        return arr;
//    }
//
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
//        return nums.get(k - 1);
//    }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
               stack.add(root);
               root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

}

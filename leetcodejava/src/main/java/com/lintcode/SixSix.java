package com.lintcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-20 21:38
 * @description: 66
 **/
public class SixSix {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> preorder = new ArrayList<>();
//        if (root == null) {
//           return preorder;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            preorder.add(node.val);
//            if (root.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }
//        return preorder;
//    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traverse(root, res);
//        return res;
//    }
//    private void traverse(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        result.add(root.val);
//        traverse(root.left, result);
//        traverse(root.right, result);
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}

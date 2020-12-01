package com.leetcode;

import com.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-02-01 16:37
 * @description: 144
 **/
public class OneFourFour {
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        LinkedList<Integer> output = new LinkedList<>();
//        TreeNode node = root;
//        while (node != null) {
//            if (node.left == null) {
//                output.add(node.val);
//                node = node.right;
//            } else {
//                TreeNode predecessor = node.left;
//                while (predecessor.right != null && predecessor.right != node) {
//                    predecessor = predecessor.right;
//                }
//                if (predecessor.right == null) {
//                    output.add(node.val);
//                    predecessor.right = node;
//                    node = node.left;
//                } else {
//                    predecessor.right = null;
//                    node = node.right;
//                }
//            }
//        }
//        return output;
//    }

//    public List<Integer> preorderTraversal(TreeNode node) {
//        List<Integer> list = new LinkedList<>();
//        Stack<TreeNode> rights = new Stack<>();
//        while (node != null) {
//           list.add(node.val);
//           if (node.right != null) {
//               rights.push(node.right);
//           }
//           node = node.left;
//           if (node == null && !rights.isEmpty()) {
//               node = rights.pop();
//           }
//        }
//        return list;
//    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//       List<Integer> result = new LinkedList<>();
//       Deque<TreeNode> stack = new LinkedList<>();
//       stack.push(root);
//       while (!stack.isEmpty()) {
//           TreeNode node = stack.pop();
//           if (node != null) {
//               result.add(node.val);
//               stack.push(node.right);
//               stack.push(node.left);
//           }
//       }
//       return result;
//    }

    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer> result = new LinkedList<>();
       Deque<TreeNode> stack = new LinkedList<>();
       TreeNode node = root;
       while (node != null || !stack.isEmpty()) {
           if (node != null) {
               result.add(node.val);
               stack.push(node.right);
               node = node.left;
           } else {
               node = stack.pop();
           }
       }
       return result;
    }

}

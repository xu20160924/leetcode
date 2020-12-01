package com.leetcode;

import com.entity.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-10-10 16:26
 * @description: 106
 **/
public class OneZeroSix {
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
//            return null;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
//        TreeNode result = root;
//        int length = (int) (postorder.length - Math.ceil(postorder.length / 2));
//        for (int i = postorder.length - 1; i >= length; i--) {
//            if (i != postorder.length - 1) {
//                if (map.get(postorder[i]) > map.get(postorder[i + 1])) {
//                    root.right = new TreeNode(postorder[i]);
//                    root = root.right;
//                } else {
//                    root.left = new TreeNode(postorder[i]);
//                    root = root.left;
//                }
//            }
//            TreeNode left = map.get(postorder[i]) - 1 < 0 ? null : new TreeNode(inorder[map.get(postorder[i]) - 1]);
//            TreeNode right = map.get(postorder[i]) + 1 > inorder.length - 1 ? null : new TreeNode(inorder[map.get(postorder[i]) + 1]);
//            root.left = left;
//            root.right = right;
//        }
//        return result;
//    }

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
//            return null;
//        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
//    }
//
//    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
//        if (postStart > postEnd || inStart > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(postorder[postEnd]);
//        int index = map.get(postorder[postEnd]);
//        root.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart + index - inStart - 1, map);
//        root.right = helper(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1, map);
//        return root;
//
//    }

//    int pInorder;
//    int pPostorder;
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        pInorder = inorder.length - 1;
//        pPostorder = postorder.length - 1;
//        return buildTree(inorder, postorder, null);
//    }
//
//    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
//
//        if (pPostorder < 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(postorder[pPostorder--]);
//
//        // if right node exist, create right subtree
//        if (inorder[pInorder] != root.val) {
//            root.right = buildTree(inorder, postorder, root);
//        }
//        pInorder--;
//        // if left node exist, create left subtree
//        if ((end == null) || (inorder[pInorder] != end.val)) {
//            root.left = buildTree(inorder, postorder, end);
//        }
//        return root;
//    }

//    int[] postorder;
//    int[] inorder;
//    Map<Integer, Integer> map = new HashMap<>();
////    int postIdx;
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
////        postIdx = postorder.length - 1;
//
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i], i);
//        }
//        return helper(0, postorder.length - 1, postorder.length - 1, postorder);
//    }
//
//    private TreeNode helper(int left, int right, int postIdx, int[] postorder) {
//        if (left > right) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(postorder[postIdx]);
//        int index = map.get(postorder[postIdx]);
//        root.right = helper(index + 1, right, postIdx--, postorder);
//        root.left = helper(left, index - 1, postIdx, postorder);
//        return root;
//    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

//    Map<Integer, Integer> map = new HashMap<>();
//    int postidx;
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//        for (int i = 0; i < postorder.length; i++) {
//            map.put(postorder[i], i);
//        }
//        postidx = postorder.length - 1;
//        return helper(0, postorder.length - 1,  postorder);
//    }
//
//    private TreeNode helper(int left, int right, int[] postorder) {
//        if (left > right) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(postorder[postidx]);
//        int index = map.get(postorder[postidx]);
//        postidx--;
//        root.right = helper(index + 1, right,  postorder);
//        root.left = helper(left, index - 1,   postorder);
//        return root;
//    }





    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
//        int[] inorder = {3,2,1};
//        int[] postorder = {3,2,1};
        OneZeroSix oneZeroSix = new OneZeroSix();
        TreeNode s = oneZeroSix.buildTree(inorder, postorder);
        System.out.println("");
    }

}

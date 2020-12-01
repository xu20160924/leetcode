package com.leetcode;

import com.entity.TreeNode;

import java.util.HashMap;
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

    int postIdx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        postIdx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder) {
            map.put(val, idx++);
        }
        return helper(0, postorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);

        int index = map.get(rootVal);
        postIdx--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }




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

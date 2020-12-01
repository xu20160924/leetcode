package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-05-04 16:17
 * @description: 07
 **/
public class ZeroSeven {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
                              Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        // 这里inRoot - 1 + 1 分别是将左边的节点以及右边的节点 给让出来
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(0, 0, inorder.length - 1, preorder, inorder);
//    }
//
//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart > preorder.length - 1 || inStart > inEnd) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[preStart]);
//        // Index of current root in inorder
//        int inIndex = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val) {
//                inIndex = i;
//            }
//        }
//        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
//        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
//        return root;
//    }

    public static void main(String[] args) {
        ZeroSeven zeroSeven = new ZeroSeven();
        zeroSeven.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9,3,15,20,7});
    }
}

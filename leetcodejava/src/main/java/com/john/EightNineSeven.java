package com.john;

import com.entity.TreeNode;
import com.lintcode.Eight;

import java.util.ArrayList;
import java.util.List;

public class EightNineSeven {
//    TreeNode dummy = new TreeNode(0);
//    TreeNode root = dummy;
//
//    public TreeNode increasingBST(TreeNode root) {
//        helper(root);
//        return dummy.right;
//    }
//
//    private void helper(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        helper(node.left);
//        root.right = new TreeNode(node.val);
//        root = root.right;
//        helper(node.right);
//    }

//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode newNode = new TreeNode(Integer.MIN_VALUE);
//        TreeNode result = newNode;
//        helper(root, newNode, root);
//        return result;
//    }
//
//    private void helper(TreeNode node, TreeNode newNode, TreeNode par) {
//        if (node == null) {
//            return;
//        }
//        helper(node.left, newNode, node);
//        if (newNode.val == Integer.MIN_VALUE) {
//            newNode.val = node.val;
//        }
//        while (newNode.right != null) {
//            newNode = newNode.right;
//        }
//        newNode.right = new TreeNode(par.val);
//        newNode = newNode.right;
//        helper(node.right, newNode, node);
//    }

//    public TreeNode increasingBST(TreeNode root) {
//        List<Integer> vals = new ArrayList<>();
//        inorder(root, vals);
//        TreeNode ans = new TreeNode(0), cur = ans;
//        for (int v : vals) {
//            cur.right = new TreeNode(v);
//            cur = cur.right;
//        }
//        return ans.right;
//    }
//
//    private void inorder(TreeNode node, List<Integer> vals) {
//       if (node == null) {
//           return;
//       }
//       inorder(node.left, vals);
//       vals.add(node.val);
//       inorder(node.right, vals);
//    }

//    TreeNode cur;
//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode ans = new TreeNode(0);
//        cur = ans;
//        inorder(root);
//        return ans.right;
//    }
//
//    private void inorder(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        inorder(node.left);
//        node.left = null;
//        cur.right = node;
//        cur = node;
//        inorder(node.right);
//    }

    public TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }




    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9});
        EightNineSeven eightNineSeven = new EightNineSeven();
        TreeNode a = eightNineSeven.increasingBST(root);
        System.out.println("");
    }
}

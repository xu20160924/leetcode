package com.leetcode;

import com.entity.TreeNode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-13 17:16
 * @description: 617
 **/
public class SixOneSeven {
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) {
//            return t2;
//        }
//        if (t2 == null) {
//            return t1;
//        }
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
//    }

//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) {
//            return t2;
//        }
//
//        Stack<TreeNode[]> stack = new Stack<>();
//        stack.push(new TreeNode[]{t1, t2});
//        while (!stack.isEmpty()) {
//            TreeNode[] t = stack.pop();
//            if (t[0] == null || t[1] == null) {
//                continue;
//            }
//            t[0].val += t[1].val;
//            if (t[0].left == null) {
//                t[0].left = t[1].left;
//            } else {
//                stack.push(new TreeNode[]{t[0].left, t[1].left});
//            }
//
//            if (t[0].right == null) {
//                t[0].right = t[1].right;
//            } else {
//                stack.push(new TreeNode[]{t[0].right, t[1].right});
//            }
//        }
//        return t1;
//    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);
        newNode.left = mergeTrees(t1 == null ? null : t1.left,
                t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right,
                t2 == null ? null : t2.right);
        return newNode;
    }



    public static void main(String[] args) {
        TreeNode t1 = TreeNode.getTreeNode(new Integer[]{1,3,2,5});
        TreeNode t2 = TreeNode.getTreeNode(new Integer[]{2,1,3,null,4,null,7});

        SixOneSeven sixOneSeven = new SixOneSeven();
        TreeNode a = sixOneSeven.mergeTrees(t1, t2);
        System.out.println("");
    }
}

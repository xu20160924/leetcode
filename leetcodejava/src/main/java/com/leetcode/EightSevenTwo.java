package com.leetcode;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-10-18 09:52
 * @description: 872
 **/
public class EightSevenTwo {
//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        List<Integer> leaves1 = new ArrayList<>();
//        List<Integer> leaves2 = new ArrayList<>();
//        dfs(root1, leaves1);
//        dfs(root2, leaves2);
//        return leaves1.equals(leaves2);
//    }
//
//    public void dfs(TreeNode node, List<Integer> leafValues) {
//        if (node != null) {
//            if (node.left == null && node.right == null) {
//                leafValues.add(node.val);
//            }
//            dfs(node.left, leafValues);
//            dfs(node.right, leafValues);
//        }
//    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        s1.push(root1); s2.push(root2);
        while (!s1.empty() && !s2.empty()) {
            if (dfs(s1) != dfs(s2)) {
                return false;
            }
        }
        return s1.empty() && s2.empty();
    }


    private int dfs(Stack<TreeNode> s) {
        while (true) {
            TreeNode node = s.pop();
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
            if (node.left == null && node.right == null) {
                return node.val;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        EightSevenTwo eightSevenTwo = new EightSevenTwo();
        eightSevenTwo.leafSimilar(root1, root2);
    }

//    private List<Integer> getLeaves(TreeNode root) {
//
//        List<Integer> list = new LinkedList<>();
//        if (root == null) {
//            return list;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//
//        }
//    }

}

package com.leetcode;

import com.entity.ListNode;
import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-20 21:35
 * @description: 95
 **/
public class NineFive {
//    public LinkedList<TreeNode> generate_trees(int start, int end) {
//        LinkedList<TreeNode> all_tress = new LinkedList<>();
//        if (start > end) {
//            all_tress.add(null);
//            return all_tress;
//        }
//        for (int i = start; i <= end; i++) {
//            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
//            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
//            for (TreeNode l : left_trees) {
//                for (TreeNode r : right_trees) {
//                    TreeNode current_tree = new TreeNode(i);
//                    TreeNode left = l, right = r;
//                    current_tree.left = l;
//                    current_tree.right = r;
//                    all_tress.add(current_tree);
//                }
//            }
//        }
//        return all_tress;
//    }
//
//    public List<TreeNode> generateTrees(int n) {
//        if (n == 0) {
//            return new LinkedList<>();
//        }
//        return generate_trees(1, n);
//    }

//    private TreeNode clone(TreeNode n, int offset) {
//        if (n == null) {
//            return null;
//        }
//        TreeNode node = new TreeNode(offset);
//        n.left = clone(n.left, offset);
//        n.right = clone(n.right, offset);
//        return node;
//    }
//
//    public List<TreeNode> generateTrees(int num) {
//        List<TreeNode>[] dp = new ArrayList[num+1];
//        dp[0] = new ArrayList<>();
//        if (num == 0) {
//            return dp[0];
//        }
//        dp[0].add(null);
//        for (int len = 1; len <= num; len++) {
//            dp[len] = new ArrayList<>();
//            for (int root = 1; root <= len; root++) {
//                int left = root - 1;
//                int right = len - root;
//                for (TreeNode leftTree : dp[left]) {
//                    for (TreeNode rightTree : dp[right]) {
//                        TreeNode treeRoot = new TreeNode(root);
//                        treeRoot.left = leftTree;
//                        treeRoot.right = rightTree;
//                        treeRoot.right = clone(rightTree, root);
//                        dp[len].add(treeRoot);
//                    }
//                }
//            }
//        }
//        return dp[num];
//    }

    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode root : pre) {
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root);
                    TreeNode right = root_copy;
                    int k = 0;
                    for (; k < j; k++) {
                        if (right == null) {
                            break;
                        }
                        right = right.right;
                    }
                    if (right == null) {
                        break;
                    }
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert;
                    insert.left = rightTree;
                    cur.add(root_copy);
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        NineFive nineFive = new NineFive();
        nineFive.generateTrees(3);
    }
}

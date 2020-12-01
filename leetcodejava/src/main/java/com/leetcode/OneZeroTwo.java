package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-28 14:46
 * @description: 102
 **/
public class OneZeroTwo {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (--size >= 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        OneZeroTwo oneZeroTwo = new OneZeroTwo();
        TreeNode root = TreeNode.getTreeNode(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> a = oneZeroTwo.levelOrder(root);
        System.out.println("");
    }
}

package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-02-02 20:56
 * @description: 958
 **/
public class NineFiveEight {
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (true) {
            TreeNode node = bfs.poll();
            if (node.left == null) {
                if (node.right != null) {
                    return false;
                }
                break;
            }
            bfs.offer(node.left);
            if (node.right == null) {
                break;
            }
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty()) {
            TreeNode node = bfs.poll();
            if (node.left != null || node.right != null) {
                return false;
            }
        }
        return true;
    }
}

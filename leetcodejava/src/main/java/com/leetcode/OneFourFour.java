package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-01 16:37
 * @description: 144
 **/
public class OneFourFour {
    public static List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }
}

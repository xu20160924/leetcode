package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-28 17:56
 * @description:
 **/
class CBTInserter {

    TreeNode root = null;
    Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> tQueue = new LinkedList<>();
        tQueue.add(root);
        queue.add(root);
        while (!tQueue.isEmpty()) {
            int size = tQueue.size(), num = size;
            queue = new LinkedList<>(tQueue);
            for (int i = 0; i < size; i++) {
                TreeNode node = tQueue.poll();
                if (node.left != null) {
                    tQueue.add(node.left);
                }
                if (node.right != null) {
                    tQueue.add(node.right);
                    queue.add(node.right);
                }
            }
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        while (node.left != null && node.right != null) {
            node = queue.poll();
        }
        TreeNode vNode = new TreeNode(v);
        if (node.left == null) {
            node.left = vNode;
        } else if (node.right == null) {
            node.right = vNode;
        }
        queue.add(vNode);
        return node.val;
    }

//    public static void main(String[] args) {
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6});
//        CBTInserter nineOneNine = new CBTInserter(root);
//        nineOneNine.insert(7);
//        nineOneNine.insert(8);
//        System.out.println(nineOneNine.get_root().val);
//
//    }
}
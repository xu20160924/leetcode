package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-05-21 08:53
 * @description: 32
 **/
public class ThreeTwo {

    /**
     * z 打印
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // 偶数层  队列头部
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else { // 奇数层 队列尾部
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 分层输出
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        if (root != null) {
//            queue.add(root);
//        }
//        while (!queue.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                tmp.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(tmp);
//        }
//        return res;
//    }

//    public int[] levelOrder(TreeNode root) {
//        if (root == null) {
//            return new int[0];
//        }
//        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
//            add(root);
//        }};
//        ArrayList<Integer> ans = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            ans.add(node.val);
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }
//        int[] res = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++) {
//            res[i] = ans.get(i);
//        }
//        return res;
//    }
}

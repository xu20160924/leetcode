package com.lintcode;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-26 09:43
 * @description: 69
 **/
public class SixNine {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 1. put start node into queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 2. while queue is not empty
        while (!queue.isEmpty()) {
            // 3. level
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                list.add(head.val);

                if (head.left != null) {
                    queue.add(head.left);
                }

                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            res.add(list);
        }
//        return res;
        Collections.reverse(res);
        return res;
    }
}

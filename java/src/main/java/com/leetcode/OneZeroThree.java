package com.leetcode;

import com.entity.TreeNode;
import com.sun.xml.internal.rngom.parse.compact.UCode_UCodeESC_CharStream;

import java.awt.font.GlyphVector;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-02-23 21:26
 * @description: 103
 **/
public class OneZeroThree {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> sol = new ArrayList<>();
//        travel(root, sol, 0);
//        return sol;
//    }
//    private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
//        if (curr == null) {
//            return;
//        }
//        if (sol.size() <= level) {
//           List<Integer> newLevel = new LinkedList<>();
//           sol.add(newLevel);
//        }
//        List<Integer> collection = sol.get(level);
//        if (level % 2 == 0) {
//            collection.add(curr.val);
//        } else {
//            collection.add(0, curr.val);
//        }
//        travel(curr.left, sol, level + 1);
//        travel(curr.right, sol, level + 1);
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
            zigzag = !zigzag;
        }
        return res;
    }

}

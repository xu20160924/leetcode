package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-14 12:05
 * @description: 637
 **/
public class SixThreeSeven {
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> list = new LinkedList<>();
//        if (root == null) {
//            return list;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            long size = queue.size();
//            long dividend = size, sum = 0;
//            while (size-- > 0) {
//                TreeNode node = queue.poll();
//                sum += node.val;
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            list.add((double)sum / (double)dividend);
//
//        }
//        return list;
//    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    private void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }




    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode(new Integer[]{3,9,20,15,7});
        SixThreeSeven sixThreeSeven = new SixThreeSeven();
        List<Double> s = sixThreeSeven.averageOfLevels(root);
        System.out.println("");
    }
}

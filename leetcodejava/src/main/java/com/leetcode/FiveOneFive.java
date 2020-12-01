package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-13 11:36
 * @description: 515
 **/
public class FiveOneFive {
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//
//        int curMax = Integer.MIN_VALUE;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                root = queue.poll();
//                curMax = Math.max(curMax, root.val);
//                if (root.left != null) {
//                    queue.add(root.left);
//                }
//                if (root.right != null) {
//                    queue.add(root.right);
//                }
//            }
//
//            list.add(curMax);
//            curMax = Integer.MIN_VALUE;
//        }
//        return list;
//    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int d) {
       if (root == null) {
           return;
       }
        if (d == res.size()) {
            res.add(root.val);
        } else {
            res.set(d, Math.max(res.get(d), root.val));
        }
        System.out.println(root.val);
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode nine = new TreeNode(9);
        TreeNode threee = new TreeNode(3);
        TreeNode five = new TreeNode(5);


        three.left = five;
        three.right = threee;
        two.right = nine;
        root.left = three;
        root.right = two;

        FiveOneFive fiveOneFive = new FiveOneFive();
        List<Integer> list = fiveOneFive.largestValues(root);

        System.out.println("");
    }
}

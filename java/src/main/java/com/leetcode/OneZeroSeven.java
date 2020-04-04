package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-02-01 19:38
 * @description: 107
 **/
public class OneZeroSeven {

    /**
     * bfs
     * @param root
     * @return
     */
//    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> wrapList = new LinkedList<>();
//        if (root == null ) {
//            return wrapList;
//        }
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int levelNum = queue.size();
//            List<Integer> subList = new LinkedList<>();
//            for (int i = 0; i < levelNum; i++) {
//                if (queue.peek().left != null) {
//                    queue.offer(queue.peek().left);
//                }
//                if (queue.peek().right != null) {
//                    queue.offer(queue.peek().right);
//                }
//                subList.add(queue.poll().val);
//            }
//            wrapList.add(0, subList);
//        }
//        return wrapList;
//    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);

        two.left = one;
        two.right = three;
        six.left = five;
        six.right = seven;
        root.left = two;
        root.right = six;
        OneZeroSeven.levelOrderBottom(root);
    }
}

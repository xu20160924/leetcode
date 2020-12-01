package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-10-14 14:24
 * @description: 652
 **/
public class SixFiveTwo {

//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        List<TreeNode> list = new ArrayList<>();
//        helper(root);
////        int left = helper(root.left);
////        int right = helper(root.right);
////        if (left == right) {
////            System.out.println(left);
////        }
//        return list;
//    }
//
//    private int helper(TreeNode node) {
//        if (node == null) {
//            return Integer.MIN_VALUE;
//        }
//
//        helper(node.left);
//        helper(node.right);
//        System.out.println(node.val);
//        return node.val;
//    }


//    Map<String, Integer> count;
//    List<TreeNode> ans;
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        count = new HashMap<>();
//        ans = new ArrayList<>();
//        helper(root);
//        return ans;
//    }
//
//    private String helper(TreeNode node) {
//        if (node == null) {
//            return "#";
//        }
//        String serial = node.val + "," + helper(node.left) + "," + helper(node.right);
//        count.put(serial, count.getOrDefault(serial, 0) + 1);
//        if (count.get(serial) == 2) {
//            ans.add(node);
//        }
//        return serial;
//    }

//    int t;
//    Map<String, Integer> trees;
//    Map<Integer, Integer> count;
//    List<TreeNode> ans;
//
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        t = 1;
//        trees = new HashMap<>();
//        count = new HashMap<>();
//        ans = new ArrayList<>();
//        lookup(root);
//        return ans;
//    }
//
//    private int lookup(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        String serial = node.val + "," + lookup(node.left) + lookup(node.right);
//        int uid = trees.computeIfAbsent(serial, x-> t++);
//        count.put(uid, count.getOrDefault(uid, 0) + 1);
//        if (count.get(uid) == 2) {
//            ans.add(node);
//        }
//        return uid;
//        //        count.put()
//    }

    List<TreeNode> list = new ArrayList<>();
    Map<Integer, int[]> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return list;

    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        System.out.println(root.val);
        helper(root.right);
    }


    public static void main(String[] args) {
        SixFiveTwo sixFiveTwo = new SixFiveTwo();
        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,2,3,4,null,2,4,null,null,4});
        List<TreeNode> a = sixFiveTwo.findDuplicateSubtrees(root);
        System.out.println("");
    }

    /**
     * 4 7 8 5 2 6 3 1
     */

}

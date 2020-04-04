package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-22 17:10
 * @description: 113
 **/
public class OneOneThree {
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root != null) {
//            dfs(root, res, new ArrayList<>(), sum, 0);
//        }
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum, int curVal) {
//        if (root == null) {
//            return;
//        }
//        if ((curVal += root.val) <= sum) {
//            list.add(root.val);
//        } else {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            if (curVal == sum) {
//               res.add(list);
//            }
//        }
//        dfs(root.left, res, list, sum, curVal);
//        dfs(root.right, res, list, sum, curVal);
//    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root, sum, cur, ret);
        return ret;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
           ret.add(new ArrayList<>(cur));
        } else {
            pathSum(root.left, sum - root.val, cur, ret);
            pathSum(root.right, sum - root.val, cur, ret);
        }
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eight = new TreeNode(8);
        TreeNode eleven = new TreeNode(11);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourfour = new TreeNode(4);
        TreeNode fivefive = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);

        fourfour.left = fivefive;
        fourfour.right = one;
        eleven.left = seven;
        eleven.right = two;
        eight.left = thirteen;
        eight.right = fourfour;
        four.left = eleven;
        five.left = four;
        five.right = eight;

        OneOneThree oneOneThree = new OneOneThree();
        List<List<Integer>> list = oneOneThree.pathSum(five, 22);
    }
}

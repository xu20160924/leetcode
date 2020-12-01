package com.leetcode;

import com.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-10-12 13:41
 * @description: 437
 **/
public class FourThreeSeven {

    int count = 0;

//    public int pathSum(TreeNode root, int sum) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//        helper(root, 0, sum, map);
//        return count;
//    }
//
//    private void helper(TreeNode root, int curr, int target, Map<Integer, Integer> map) {
//        if (root == null) {
//            return;
//        }
//
//        curr += root.val;
//
//        if (map.containsKey(curr - target)) {
//            count += map.get(curr - target);
//        }
//
//        if (!map.containsKey(curr)) {
//            map.put(curr, 1);
//        } else {
//            map.put(curr, map.get(curr) + 1);
//        }
//
//        helper(root.left, curr, target, map);
//        helper(root.right, curr, target, map);
//        map.put(curr, map.get(curr) - 1);
//    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);
    }

    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }

        sum += curr.val;
        int numPathToCur = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int res = numPathToCur + findPathSum(curr.left, sum, target, map) + findPathSum(curr.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode at = new TreeNode(-3);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);

        TreeNode at2 = new TreeNode(3);
        TreeNode at1 = new TreeNode(3);
        TreeNode two2 = new TreeNode(-2);
        TreeNode one = new TreeNode(1);
        at1.left = at2;
        at1.right = two2;

        two.right = one;
        five.left = at1;
        five.right = two;

        at.right = eleven;

        root.left = five;
        root.right = at;

        FourThreeSeven fourThreeSeven = new FourThreeSeven();
        fourThreeSeven.pathSum(root, 8);

    }
}

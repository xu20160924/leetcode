package com.leetcode;

import com.entity.TreeNode;

import java.util.*;

public class FiveZeroEight {
//    public int[] findFrequentTreeSum(TreeNode root) {
//        if (root == null) {
//            return new int[]{};
//        }
//        Map<Integer, Integer> map = new TreeMap<>();
//        helper(root, map);
//        List<Integer> list = new LinkedList<>();
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() >= most) {
//                list.add(entry.getKey());
//            }
//        }
//
//        return list.stream().mapToInt(i->i).toArray();
//    }
//    int most = 0;
//    private int helper(TreeNode root, Map<Integer, Integer> map) {
//        if (root == null) {
//            return 0;
//        }
//        int ans = root.val + helper(root.left, map) + helper(root.right, map);
//        map.put(ans,map.getOrDefault(ans, 0) + 1);
//        most = Math.max(most, map.getOrDefault(ans, 0));
//
//        return ans;
//    }



    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s : count.keySet()) {
            if (count.get(s) == maxCount)
                res.add(s);
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int s = dfs(root.left) + dfs(root.right) + root.val;
        count.put(s, count.getOrDefault(s, 0) + 1);
        maxCount = Math.max(maxCount, count.get(s));
        return s;
    }

    public static void main(String[] args) {
        FiveZeroEight fiveZeroEight = new FiveZeroEight();
//        TreeNode root = new TreeNode(5);
//        TreeNode two = new TreeNode(2);
//        TreeNode five = new TreeNode(-5);
//        root.left = two;
//        root.right = five;
        TreeNode root = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(-3);
        root.left = two;
        root.right = three;

        fiveZeroEight.findFrequentTreeSum(root);
    }
}

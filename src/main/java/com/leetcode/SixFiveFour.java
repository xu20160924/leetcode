package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;

/**
 * @author: John
 * @date: 2020-01-26 17:16
 * @description: 654
 **/
public class SixFiveFour {
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        return construct(nums, 0, nums.length);
//    }
//
//    public TreeNode construct(int[] nums, int l, int r) {
//        if (l == r) {
//           return null;
//        }
//        int max_i = max(nums, l, r);
//        TreeNode root = new TreeNode(nums[max_i]);
//        root.left = construct(nums, l, max_i);
//        root.right = construct(nums, max_i + 1, r);
//        return root;
//    }
//
//    public int max(int[] nums, int l, int r) {
//        int max_i = l;
//        for (int i = l; i < r; i++) {
//           if (nums[max_i] < nums[i]) {
//               max_i = i;
//           }
//        }
//        return max_i;
//    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int num : nums) {
            TreeNode cur = new TreeNode(num);
            while (!list.isEmpty() && list.peekFirst().val < cur.val) {
                cur.left = list.pop();
            }
            if (!list.isEmpty()) {
                list.peekFirst().right = cur;
            }
            list.addFirst(cur);
        }
        return list.peekFirst();
    }


    public static void main(String[] args) {
        int[] input = {3, 4, 5, 1, 2};
        SixFiveFour sixFiveFour = new SixFiveFour();
        sixFiveFour.constructMaximumBinaryTree(input);
    }
}


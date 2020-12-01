package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-09-18 16:05
 * @description: 54
 **/
public class FiveFour {

//    public int kthSmallest(TreeNode root, int k) {
//        if (k == 0) {
//            return root.left == null ? root.right.val : root.left.val;
//        }
//        return kthSmallest(root.left != null ? root.left : root.right, k--);
//    }


//    public int kthLargest(TreeNode root, int k) {
//       List<Integer> list = new ArrayList<>();
//       helper(root, list);
//       return list.get(list.size() - k);
//    }
//
//    private void helper(TreeNode root, List<Integer> list) {
//        if (root == null) {
//           return;
//        }
//        if (root.left != null) {
//            helper(root.left, list);
//        }
//        list.add(root.val);
//        if (root.right != null) {
//           helper(root.right, list);
//        }
//    }


//    private int ans = 0, count = 0;
//    public int kthLargest(TreeNode root, int k) {
//        helper(root, k);
//        return ans;
//    }
//
//    private void helper(TreeNode root, int k) {
//       if (root.right != null) {
//           helper(root.right, k);
//       }
//       if (++count == k) {
//          ans = root.val;
//          return;
//       }
//       if (root.left != null) {
//          helper(root.left, k);
//       }
//    }

    public int kthLargest(TreeNode root, int k) {
        return helper(root, k);
    }

    private int helper(TreeNode root, int k) {
        if (root == null) {
           return 0;
        }
        if (k == 0) {
            return root.val;
        }
        return root.right != null ? helper(root.right, --k) : helper(root.left, --k);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode one = new TreeNode(1);
//        TreeNode four = new TreeNode(4);
//        TreeNode two = new TreeNode(2);
//        one.right = two;
//        root.left = one;
//        root.right = four;

        TreeNode root = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode one = new TreeNode(1);

        two.left = one;
        three.left = two;
        three.right = four;
        root.left = three;
        root.right = six;


        FiveFour fiveFour = new FiveFour();
        System.out.println(fiveFour.kthLargest(root, 3));
    }
}

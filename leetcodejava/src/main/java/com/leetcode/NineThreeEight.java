package com.leetcode;

import com.entity.TreeNode;

import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-29 10:58
 * @description: 938
 **/
public class NineThreeEight {
//    public int rangeSumBST(TreeNode root, int L, int R) {
//        helper(root, L, R);
//        return sum;
//    }
//
//    int sum = 0;
//    boolean end = false;
//    private void helper(TreeNode root, int L, int R) {
//        if (root == null) {
//            return;
//        }
//        helper(root.left, L, R);
//        System.out.println(root.val);
//        if (root.val == R) {
//            sum += root.val;
//            end = true;
//            return;
//        }
//        if ((root.val == L || sum > 0) && !end) {
//            sum += root.val;
//        }
//        helper(root.right, L, R);
//    }

//    int ans;
//    public int rangeSumBST(TreeNode root, int L, int R) {
//        ans = 0;
//        dfs(root, L, R);
//        return ans;
//    }
//
//    private void dfs(TreeNode node, int L, int R) {
//        if (node != null) {
//            if (L <= node.val && node.val <= R) {
//                ans += node.val;
//            }
//            if (L < node.val) {
//                dfs(node.left, L, R);
//            }
//            if (node.val < R) {
//                dfs(node.right, L, R);
//            }
//        }
//    }

//    public int rangeSumBST(TreeNode root, int L, int R) {
//        int ans = 0;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node != null) {
//                if (L <= node.val && node.val <= R) {
//                    ans += node.val;
//                }
//                if (L < node.val) {
//                    stack.push(node.left);
//                }
//                if (node.val < R) {
//                    stack.push(root.right);
//                }
//            }
//        }
//        return ans;
//    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }


    /**
     * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
     * <p>
     * The binary search tree is guaranteed to have unique values.
     * <p>
     * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
     * Output: 32
     *
     *
     *
     * [18,9,27,6,15,24,30,3,null,12,null,21]
     * 18
     * 24
     */
    public static void main(String[] args) {
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{10, 5, 15, 3, 7, null, 18});
//        NineThreeEight nineThreeEight = new NineThreeEight();
//        System.out.println(nineThreeEight.rangeSumBST(root, 7, 15));
//

      TreeNode root = TreeNode.getTreeNode(new Integer[]{18,9,27,6,15,24,30,3,null,12,null,21});
        NineThreeEight nineThreeEight = new NineThreeEight();
        System.out.println(nineThreeEight.rangeSumBST(root, 18, 24));

    }
}

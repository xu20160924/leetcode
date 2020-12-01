package com.leetcode;

import com.entity.TreeNode;

public class SixSixNine {
    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root.val < low) {
//            root = root.right;
//            helper(root.right, root, low, high);
//        } else if (root.val > high) {
//            helper(root.left, root, low, high);
//        } else {
//
//        }

        helper(root, root, low, high);

        return root;
    }

    private void helper(TreeNode root, TreeNode prev, int low, int high) {
        if (root == null) {
            return;
        }
//        if (root.val < low) {
//            root = root.right;
//        }
//        if (root.val > high) {
//            root = root.left;
//        }
//        if (root.val > low && root.val < high) {
//            helper(root.left, root, low, high);
//            helper(root.right, root, low, high);
//
//        }
        while (root.val < low) {
            root = root.right;
        }
        while (root.val > high) {
            root = root.left;
        }
        if (root.val == low) {
            root.left = null;
//            if (root.right != null && root.right.val < prev.val) {
//                prev.left = root.right;
//            }
        }
        if (root.val == high) {
            root.right = null;
//            if (root.left != null && root.left.val > prev.val) {
//                prev.right = root.left;
//            }
        }
        helper(root.left, root, low, high);
        helper(root.right, root, low, high);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.listToTree("[1,null,2]");
        TreeNode root = TreeNode.listToTree("[4,2,5,1,3]");
//        TreeNode root = TreeNode.listToTree("[3,0,4,null,2,null,null,1]");
        SixSixNine sixSixNine = new SixSixNine();
//        TreeNode a = sixSixNine.trimBST(root, 1, 3);
        TreeNode a = sixSixNine.trimBST(root, 2, 5);
        System.out.println("");
    }


    //    public TreeNode trimBST(TreeNode root, int low, int high) {
//        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
//        dummy.left = root;
//        helper(root, dummy, low, high);
//        return root;
//    }
//    private void helper(TreeNode root, TreeNode prev, int low, int high) {
//        if (root == null) {
//            return;
//        }
//
//        while (root.val < low) {
//            prev.left = root.right;
//            prev = root;
//            root = root.right;
//        }
//        while (root.val > high) {
//            prev.right = root.left;
//            prev = root;
//            root = root.left;
//        }
//        if (root.val <= low) {
//            root.left = null;
//        }
//        if (root.val >= high) {
//            root.right = null;
//        }
//        helper(root.left, root, low, high);
//        helper(root.right, root, low, high);
//
//    }

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null) {
//            return root;
//        }
//        if (root.val > high) {
//            return trimBST(root.left, low, high);
//        }
//        if (root.val < low) {
//            return trimBST(root.right, low, high);
//        }
//        root.left = trimBST(root.left, low, high);
//        root.right = trimBST(root.right, low, high);
//        return root;
//    }

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if (root == null) {
//            return root;
//        }
//
//        // Find a valid root which is used to return;
//        while (root.val < low || root.val > high) {
//            if (root.val < low) {
//                root = root.right;
//            }
//            if (root.val > high) {
//                root = root.left;
//            }
//        }
//        TreeNode dummy = root;
//
//        while (dummy != null) {
//            while (dummy.left != null && dummy.left.val < low) {
//                dummy.left = dummy.left.right;
//            }
//            dummy = dummy.left;
//        }
//        dummy = root;
//        while (dummy != null) {
//            while (dummy.right != null && dummy.right.val > high) {
//                dummy.right = dummy.right.left;
//            }
//            dummy = dummy.right;
//        }
//        return root;
//    }


}

package com.lintcode;

import com.entity.TreeNode;

import javax.xml.transform.Result;

/**
 * @author: John
 * @date: 2020-03-21 13:35
 * @description: 578
 **/
public class FiveSevenEight {
//    class ResultType {
//        public boolean a_exist, b_exist;
//        public TreeNode node;
//
//        public ResultType(boolean a_exist, boolean b_exist, TreeNode node) {
//            this.a_exist = a_exist;
//            this.b_exist = b_exist;
//            this.node = node;
//        }
//    }
//    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
//
//    }
//
//    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
//       if (root == null) {
//           return new ResultType(false, false, null);
//       }
//       ResultType left = helper(root.left, A, B);
//       ResultType right = helper(root.right, A, B);
//       boolean a_exist = left.a_exist || right.a_exist || root == A;
//       boolean b_exist = right.b_exist || left.b_exist || root == B;
//
//       if (root == A || root == B) {
//           return new ResultType(a_exist, b_exist, root);
//       }
//       if (left.node != null && right.node != null) {
//           return new ResultType(a_exist, b_exist, root);
//       }
//       if (left.node != null) {
//           return new ResultType(a_exist, false, root.left);
//       }
//       if (right.node != null) {
//           return new ResultType(false, b_exist, root.right);
//       }
//       return new ResultType(a_exist, b_exist, null);
//    }


    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResulType result = helper(root, A, B);
        if (result.a_exist && result.b_exist) {
            return result.node;
        }
        return null;
    }


    private ResulType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResulType(false, false, null);
        }

        ResulType left = helper(root.left, A, B);
        ResulType right = helper(root.right, A, B);

        boolean a_exist = left.a_exist || right.b_exist || root == A;
        boolean b_exist = right.b_exist || left.b_exist || root == B;

        if (root == A || root == B) {
            return new ResulType(a_exist, b_exist, root);
        }

        if (left.node != null && right.node != null) {
            return new ResulType(a_exist, b_exist, root);
        }

        if (left.node != null) {
            return new ResulType(a_exist, b_exist, left.node);
        }
        if (right.node != null) {
            return new ResulType(a_exist, b_exist, right.node);
        }
        return new ResulType(a_exist, b_exist, null);
    }


    class ResulType {
        public boolean a_exist, b_exist;
        public TreeNode node;
        ResulType(boolean a_exist, boolean b_exist, TreeNode node) {
            this.a_exist = a_exist;
            this.b_exist = b_exist;
            this.node = node;
        }
    }
}

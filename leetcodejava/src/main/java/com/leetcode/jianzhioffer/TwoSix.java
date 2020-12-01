package com.leetcode.jianzhioffer;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-05-19 19:56
 * @description: 26
 **/
public class TwoSix {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
       if (B == null) {
           return true;
       }
       if (A == null || !A.val.equals(B.val)) {
           return false;
       }
       return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
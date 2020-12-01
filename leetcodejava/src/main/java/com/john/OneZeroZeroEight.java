package com.john;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-11-01 14:37
 * @description: 1008
 **/
public class OneZeroZeroEight {
//    public TreeNode bstFromPreorder(int[] preorder) {
//        return helper(null, null, preorder, 0);
//    }
//
//    private TreeNode helper(TreeNode par, TreeNode grand, int[] preorder, int index) {
//        if (index >= preorder.length) {
//            return null;
//        }
//
//
//        if (preorder[index] > preorder[0]) {
//            return null;
//        }
//        TreeNode cur = new TreeNode(preorder[index]);
//        if (grand != null && cur.val > grand.val) {
//            grand.right = cur;
//        }
//
//        if (par != null && preorder[index] > par.val) {
//            cur.right = helper(par, null, preorder, index + 1);
//        } else {
//            cur.left = helper(cur, par, preorder, index + 1);
//        }
//        helper(cur, par, preorder, index + 1);
//        return cur;
//    }


    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return helper(A, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] A, int bound) {
        if (i == A.length || A[i] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(A[i++]);
        root.left = helper(A, root.val);
        root.right = helper(A, bound);
        return root;
    }


    public static void main(String[] args) {
        OneZeroZeroEight oneZeroZeroEight = new OneZeroZeroEight();

        TreeNode a = oneZeroZeroEight.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
    }
}

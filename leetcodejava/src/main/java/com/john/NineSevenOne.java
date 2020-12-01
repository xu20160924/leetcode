package com.john;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: John
 * @date: 2020-10-31 18:00
 * @description: 971
 **/
public class NineSevenOne {

//    List<Integer> flipped;
//    int index;
//    int[] voyage;
//    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
//        flipped = new ArrayList<>();
//        index = 0;
//        this.voyage = voyage;
//        dfs(root);
//        if (!flipped.isEmpty() && flipped.get(0) == -1) {
//            flipped.clear();
//            flipped.add(-1);
//        }
//        return flipped;
//    }
//
//    private void dfs(TreeNode node) {
//        if (node != null) {
//            if (!flipped.isEmpty() && flipped.get(0) == -1) {
//                return;
//            }
//            if (node.val != voyage[index++]) {
//                flipped.clear();
//                flipped.add(-1);
//                return;
//            }
//            if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
//                flipped.add(node.val);
//                dfs(node.right);
//                dfs(node.left);
//            } else {
//                dfs(node.left);
//                dfs(node.right);
//            }
//        }
//    }


//    List<Integer> res = new ArrayList<>();
//    int i = 0;
//    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
//         return dfs(root, v) ? res : Arrays.asList(-1);
//    }
//
//    private boolean dfs(TreeNode node, int[] v) {
//        if (node == null) {
//            return true;
//        }
//        if (node.val !=  v[i++]) {
//            return false;
//        }
//        if (node.left != null && node.left.val != v[i]) {
//            res.add(node.val);
//            return dfs(node.right, v) && dfs(node.left, v);
//        }
//        return dfs(node.left, v) && dfs(node.right, v);
//    }


    List<Integer> res = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] v) {
        return helper(root, v) ? res : Arrays.asList(-1);
    }

    private boolean helper(TreeNode node, int[] v) {
        if (node == null) {
            return true;
        }
        if (node.val != v[i++]) {
            return false;
        }
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return helper(node.right, v) && helper(node.left, v);
        }
        return helper(node.left, v) && helper(node.right, v);
    }






//    private void helper(TreeNode root, int[] voyage, int num, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//
//        if () {
//
//        }
//    }


//    private void helper(TreeNode root, int[] voyage, int num, List<Integer> list) {
//        if (root == null || num > voyage.length) {
//            return;
//        }
//
//        if ((root.left != root.right) && (root.left == null || root.right == null)) {
//            if ((num + 1) < voyage.length && root.val != voyage[num]) {
//                list.removeAll(list);
//                list.add(-1);
//                return;
//            }
//        } else {
//            if (root.left != null && root.right != null) {
//                if (root.left.val == voyage[num + 2] && root.right.val == voyage[num + 1]) {
//                    list.add(root.val);
//                } else {
//
//                }
//            }
//        }
//
//
//        if (root.left != null) {
//           num++;
//        }
//        helper(root.left, voyage, num, list);
//        if (root.right != null) {
//            num++;
//        }
//        helper(root.right, voyage, num, list);
//    }

    public static void main(String[] args) {
        /**
         * [1,null,2,null,3]
         * [1,3,2]
         */

//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2});
        NineSevenOne nineSevenOne = new NineSevenOne();
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,null,2,null,3});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{2,4,3,1,5});
        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,2,null,3});
//        List<Integer> a = nineSevenOne.flipMatchVoyage(root, new int[]{1,3,2});
        List<Integer> a = nineSevenOne.flipMatchVoyage(root, new int[]{1,3,2});
//        List<Integer> a = nineSevenOne.flipMatchVoyage(root, new int[]{1,3,2});
//        List<Integer> a = nineSevenOne.flipMatchVoyage(root, new int[]{2,1});
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2, null, 3});
    }

}

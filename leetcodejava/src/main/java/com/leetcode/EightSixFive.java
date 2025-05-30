package com.leetcode;

import com.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-10-17 20:17
 * @description: 865
 **/
public class EightSixFive {
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        return deep(root).getValue();
//    }
//
//    public Pair<Integer, TreeNode> deep(TreeNode root) {
//        if (root == null) {
//            return new Pair(0, null);
//        }
//        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);
//        int d1 = l.getKey(), d2 = r.getKey();
//        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
//    }

//    Map<TreeNode, Integer> depth;
//    int maxDepth;
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//        depth = new HashMap<>();
//        depth.put(null, -1);
//        dfs(root, null);
//        maxDepth = Integer.MIN_VALUE;
//        for (Integer d : depth.values()) {
//            maxDepth = Math.max(maxDepth, d);
//        }
//        return answer(root);
//    }
//
//    private void dfs(TreeNode node, TreeNode parent) {
//        if (node != null) {
//            depth.put(node, depth.get(parent) + 1);
//            dfs(node.left, node);
//            dfs(node.right, node);
//        }
//    }
//
//    private TreeNode answer(TreeNode node) {
//        if (node == null || depth.get(node) == maxDepth) {
//            return node;
//        }
//        TreeNode L = answer(node.left),
//                R = answer(node.right);
//        if (L != null && R != null) {
//            return node;
//        }
//        if (L != null) {
//            return L;
//        }
//        if (R != null) {
//            return R;
//        }
//        return null;
//    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
       if (node == null) {
           return new Result(null, 0);
       }
       Result L = dfs(node.left),
               R = dfs(node.right);
       if (L.dist > R.dist) {
           return new Result(L.node, L.dist + 1);
       }
       if (L.dist < R.dist) {
           return new Result(R.node, R.dist + 1);
       }
       return new Result(node, L.dist + 1);

    }



    class Result {
        TreeNode node;
        int dist;

        public Result(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }





//    private void helper(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        helper(root.left);
//        helper(root.right);
//        System.out.println(root.val);
//
//    }


    public static void main(String[] args) {
//        TreeNode root = TreeNode.getTreeNode(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode root = TreeNode.getTreeNode(new Integer[]{3,5,1,6,null,8,7,null,null});
        EightSixFive eightSixFive = new EightSixFive();
        eightSixFive.subtreeWithAllDeepest(root);
    }
}

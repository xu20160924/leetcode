package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-10-06 09:44
 * @description: 337
 **/
public class ThreeThreeSeven {
//    public int rob(TreeNode root) {
//        int[] answer = helper(root);
//        return Math.max(answer[0], answer[1]);
//    }
//
//    private int[] helper(TreeNode node) {
//        if (node == null) {
//            return new int[]{0, 0};
//        }
//        int left[] = helper(node.left);
//        int right[] = helper(node.right);
//        // if we rob this node, we cannot rob its children
//        int rob = node.val + left[1] + right[1];
//        // else, we free to choose rob its children or not
//        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//        return new int[]{rob, notRob};
//    }

//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int val = 0;
//        if (root.left != null) {
//            val += rob(root.left.left) + rob(root.left.right);
//        }
//        if (root.right != null) {
//            val += rob(root.right.left) + rob(root.right.right);
//        }
//
//        return Math.max(val + root.val, rob(root.left) + rob(root.right));
//    }

//    public int rob(TreeNode root) {
//        return robSub(root, new HashMap<>());
//    }

//    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
//       if (root == null) {
//           return 0;
//       }
//       if (map.containsKey(root)) {
//           return map.get(root);
//       }
//       int val = 0;
//       if (root.left != null) {
//           val += robSub(root.left.left, map) + robSub(root.left.right, map);
//       }
//
//       if (root.right != null) {
//           val += robSub(root.right.left, map) + robSub(root.right.right, map);
//       }
//       val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
//       map.put(root, val);
//       return val;
//    }

//    private int[] robSub(TreeNode root) {
//        if (root == null) {
//            return new int[2];
//        }
//        int[] left = robSub(root.left);
//        int[] right = robSub(root.right);
//        int[] res = new int[2];
//        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//        res[1] = root.val + left[0] + right[0];
//        return res;
//    }
//
//
//    HashMap<TreeNode, Integer> robResult = new HashMap<>();
//    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
//
//    private int helper(TreeNode node, boolean parentRobbed) {
//        if (node == null) {
//            return 0;
//        }
//
//        if (parentRobbed) {
//            if (robResult.containsKey(node)) {
//                return robResult.get(node);
//            }
//            int result = helper(node.left, false) +
//                    helper(node.right, false);
//            robResult.put(node, result);
//            return result;
//        } else {
//            if (notRobResult.containsKey(node)) {
//                return notRobResult.get(node);
//            }
//            int rob = node.val + helper(node.left, true) +
//                    helper(node.right, true);
//            int notRob = helper(node.left, false)
//                    + helper(node.right, false);
//            int result = Math.max(rob, notRob);
//            notRobResult.put(node, result);
//            return result;
//        }
//    }
//
//    public int rob(TreeNode root) {
//        return helper(root, false);
//    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // reform tree into array-based tree
        ArrayList<Integer> tree = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(-1, new ArrayList<>());
        int index = -1;
        // we use two Queue to store node and index
        Queue<TreeNode> q_node = new LinkedList<>();
        q_node.add(root);
        Queue<Integer> q_index = new LinkedList<>();
        q_index.add(index);

        while (q_node.size() > 0) {
            TreeNode node = q_node.poll();
            int parentIndex = q_index.poll();
            if (node != null) {
                index++;
                tree.add(node.val);
                graph.put(index, new ArrayList<>());
                graph.get(parentIndex).add(index);
                // push new node into Queue
                q_node.add(node.left);
                q_index.add(index);
                q_node.add(node.right);
                q_index.add(index);
            }
        }
        // represent the maximum start by node i with robbinig i
        int[] dpRob = new int[index + 1];
        // represent the maximum start by node i without robbing i
        int[] dpNotRob = new int[index + 1];

        for (int i = index; i >= 0; i--) {
            ArrayList<Integer> children = graph.get(i);
            if (children == null || children.size() == 0) {
                // if is leaf
                dpRob[i] = tree.get(i);
                dpNotRob[i] = 0;
            } else {
                dpRob[i] = tree.get(i);
                for (int child : children) {
                    dpRob[i] += dpNotRob[child];
                    dpNotRob[i] += Math.max(dpRob[child], dpNotRob[child]);
                }
            }
        }
        return Math.max(dpRob[0], dpNotRob[0]);
    }

}

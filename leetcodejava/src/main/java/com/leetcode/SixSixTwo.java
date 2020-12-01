package com.leetcode;

import com.entity.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

public class SixSixTwo {
//    public int widthOfBinaryTree(TreeNode root) {
//
//                dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
//                return max;
//    }
//
//    int max = Integer.MIN_VALUE;
//    private void dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
//        if (root == null) {
//            return;
//        }
//        if (start.size() == level) {
//            start.add(order);
//            end.add(order);
//        } else {
//            end.set(level, order);
//        }
////        int cur = end.get(level) - start.get(level) + 1;
//        dfs(root.left, level + 1, 2 * order, start, end);
//        dfs(root.right, level + 1, 2 * order + 1, start, end);
//        max = Math.max(max, end.get(level) - start.get(level) + 1);
////        return Math.max(cur, Math.max(left, right));
//    }


//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        List<Integer> start = new ArrayList<>();
//
//    }
//    int max = Integer.MIN_VALUE;
//    private void helper(TreeNode root, int level, int index, List<Integer> list) {
//        if (root == null) {
//            return;
//        }
//        if (list.size() == level) {
//            list.add(index);
//        }
//        max = Math.max(max, index + 1 - list.get(level));
//        helper(root.left, level + 1, 2 * index, list);
//        helper(root.right, level + 1, 2 * index + 1, list);
//    }

//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        Map<TreeNode, Integer> map = new HashMap<>();
//        queue.offer(root);
//        map.put(root, 1);
//        int curW = 0;
//        int maxW = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int start = 0;
//            int end = 0;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (i == 0) {
//                    start = map.get(node);
//                }
//                if (i == size - 1) {
//                    end = map.get(node);
//                }
//
//                if (node.left != null) {
//                    map.put(node.left, map.get(node) * 2);
//                }
//                if (node.right != null) {
//                    map.put(node.right, map.get(node) * 2 + 1);
//                }
//            }
//            curW = end - start + 1;
//            maxW = Math.max(maxW, curW);
//        }
//        return maxW;
//    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        queue.add(root);
        qIndex.add(1);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int index = qIndex.remove();
                if (i == 0) {
                    start = index;
                }
                if (i == size - 1) {
                    end = index;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    qIndex.add(2 * index);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    qIndex.add(2 * index + 1);
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        SixSixTwo sixSixTwo = new SixSixTwo();
        TreeNode root = TreeNode.listToTree("[1,3,2,5,3,null,9]");
        System.out.println(sixSixTwo.widthOfBinaryTree(root));
    }


    //    public int widthOfBinaryTree(TreeNode root) {
//        int max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int count = size;
//            int negative = 0;
////            while (size-- > 0) {
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left == null && node.right == null) {
//                    count--;
//                }
//                if ((i == 0 && node.left == null) || (i == size && node.right == null)) {
//                    negative--;
//                }
//
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            if (!queue.isEmpty()) {
////                prev = size * 2;
//                max = Math.max(max, (count * 2) + negative);
//                negative = 0;
//            }
//        }
//        return max;
//    }

//    public int widthOfBinaryTree(TreeNode root) {
//        int max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
//        if (root == null) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        TreeNode negativeNode = new TreeNode(-1);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            int negative = 0;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//
//                if (node == negativeNode) {
//                    negative--;
//                }
//                if (node.left != null) {
//                    queue.add(node.left);
//                } else {
//                    queue.add(negativeNode);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                } else {
//                    queue.add(negativeNode);
//                }
//            }
//            if (!queue.isEmpty()) {
//                max = Math.max(max, (size * 2) + negative);
//            }
//        }
//        return max;
//    }

//    public int widthOfBinaryTree(TreeNode root) {
//        return dfs(root, 0, 1, new ArrayList<>(), new ArrayList<>());
//    }
//
//    private int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
//        if (root == null) {
//            return 0;
//        }
//        if (start.size() == level) {
//            start.add(order); end.add(order);
//        } else {
//            end.set(level, order);
//        }
//        int cur = end.get(level) - start.get(level) + 1;
//        int left = dfs(root.left, level + 1, 2 * order, start, end);
//        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
//        return Math.max(cur, Math.max(left, right));
//    }


}

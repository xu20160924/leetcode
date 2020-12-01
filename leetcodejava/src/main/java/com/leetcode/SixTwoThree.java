package com.leetcode;

import com.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SixTwoThree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

//        TreeNode cur = null;
        while (--d > 2) {
            int size = queue.size();
            while (size-- > 0) {
               TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            TreeNode vNodeL = new TreeNode(v);
            vNodeL.left = cur.left;
            cur.left = vNodeL;

            TreeNode vNodeR = new TreeNode(v);
            vNodeR.right = cur.right;
            cur.right = vNodeR;
        }

        return root;
    }

//    public TreeNode addOneRow(TreeNode t, int v, int d) {
//        if (d == 1) {
//            TreeNode n = new TreeNode(v);
//            n.left = t;
//            return n;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(t);
//        int depth = 1;
//        while (depth < d -1) {
//            Queue<TreeNode> temp = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                TreeNode node = queue.remove();
//                if (node.left != null) {
//                    temp.add(node.left);
//                    temp.add(node.right);
//                }
//                queue = temp;
//                depth++;
//            }
//        }
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            TreeNode temp = node.left;
//            node.left = new TreeNode(v);
//            node.left.left = temp;
//        }
//    }


    public static void main(String[] args) {
//        TreeNode root = TreeNode.listToTree("[4,2,6,3,1,5]");
        TreeNode root = TreeNode.listToTree("[1,2,3,4]");
        SixTwoThree sixTwoThree = new SixTwoThree();
//        TreeNode a = sixTwoThree.addOneRow(root, 1, 3);
        TreeNode a = sixTwoThree.addOneRow(root, 5, 4);
        System.out.println("");
    }




    //    public TreeNode addOneRow(TreeNode root, int v, int d) {
//        if (d == 1) {
//            TreeNode newNode = new TreeNode(v);
//            newNode.left = root;
//            return newNode;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (--d > 1) {
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode cur = queue.poll();
//                if (cur.left != null) {
//                    queue.add(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.add(cur.right);
//                }
//            }
//        }
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.remove();
//            TreeNode vNodeL = new TreeNode(v);
//            vNodeL.left = node.left;
//            node.left = vNodeL;
//
//            TreeNode vNodeR = new TreeNode(v);
//            vNodeR.right = node.right;
//            node.right = vNodeR;
//        }
//
//        return root;
//    }

//    public TreeNode addOneRow(TreeNode t, int v, int d) {
//        if (d == 1) {
//            TreeNode n = new TreeNode(v);
//            n.left = n;
//            return n;
//        }
//        insert(v, t, --d);
//        return t;
//    }
//
//    private void insert(int val, TreeNode node, int d) {
//        if (node == null) {
//            return;
//        }
//        if (d <= 1) {
//            TreeNode t = node.left;
//            node.left = new TreeNode(val);
//            node.left.left = t;
//            t = node.right;
//            node.right = new TreeNode(val);
//            node.right.right = t;
//        } else {
//            insert(val, node.left, d - 1);
//            insert(val, node.right, d - 1);
//        }
//    }

//    class Node {
//        Node(TreeNode n, int d) {
//            node = n;
//            depth = d;
//        }
//        TreeNode node;
//        int depth;
//    }
//    public TreeNode addOneRow(TreeNode t, int v, int d) {
//        if (d == 1) {
//            TreeNode n = new TreeNode(v);
//            n.left = t;
//            return n;
//        }
//
//        Stack<Node> stack = new Stack<>();
//        stack.push(new Node(t, 1));
//        while (!stack.isEmpty()) {
//            Node n = stack.pop();
//            if (n.node == null) {
//                continue;
//            }
//            if (n.depth == d - 1) {
//                TreeNode temp = new TreeNode(v);
//                n.node.left = new TreeNode(v);
//                n.node.left.left = temp;
//                temp = n.node.right;
//                n.node.right = new TreeNode(v);
//                n.node.right.right = temp;
//                return t;
//            } else {
//                stack.push(new Node(n.node.left, n.depth + 1));
//                stack.push(new Node(n.node.right, n.depth + 1));
//            }
//        }
//        return t;
//    }
}

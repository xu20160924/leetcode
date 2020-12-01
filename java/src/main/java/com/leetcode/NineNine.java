package com.leetcode;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-10-08 07:58
 * @description: 99
 **/
public class NineNine {
//    public TreeNode recoverTree(TreeNode root) {
//        helper(root, true);
//        return root;
//    }
//
//    TreeNode prev = null;
//
//    private void helper(TreeNode node, boolean isLeft) {
//        if (node == null) {
//            return;
//        }
//
//        if (!isLeft && prev != null && node.val < prev.val) {
//            int temp = node.val;
//            node.val = prev.val;
//            prev.val = temp;
//        }
//        if (isLeft && prev != null && node.val > prev.val) {
//            int temp = node.val;
//            node.val = prev.val;
//            prev.val = temp;
//        }
//
//
//        prev = node;
//
//        helper(node.left, true);
//        System.out.println(node.val);
//
//        helper(node.right, false);
//    }

//    TreeNode firstNode, secondNode = null;
//    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
//
//    public void recoverTree(TreeNode root) {
//        // In order traversal to find the two node
//        traverse(root);
//
//        int temp = firstNode.val;
//        firstNode.val = secondNode.val;
//        secondNode.val = temp;
//    }
//
//    private void traverse(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        traverse(node.left);
//        System.out.println(node.val);
//        if (firstNode == null && prevNode.val >= node.val) {
//            firstNode = prevNode;
//        }
//        if (firstNode != null && prevNode.val >= node.val) {
//            secondNode = node;
//        }
//        prevNode = node;
//        traverse(node.right);
//
//    }

//    public void morrisTraversal(TreeNode root) {
//        TreeNode prev = null, first = null, second = null;
//        TreeNode temp = null;
//        while (root != null) {
//            if (prev != null && prev.val > root.val && first == null) {
//                first = prev;
//                second = root;
//            }
//            if (root.left != null) {
//                temp = root.left;
//                while (temp.right != null && temp.right != root) {
//                    temp = temp.right;
//                }
//
//                if (temp.right != null) {
//
//                    System.out.println(root.val);
//                    prev = root;
////                    temp.right = null;
//                    root = root.right;
//                } else {
//
//                    temp.right = root;
//                    root = root.left;
//                }
//            } else {
//                System.out.println(root.val);
//                root = root.right;
//            }
//        }
//        if (first != null && second != null) {
//            int t = first.val;
//            first.val = second.val;
//            second.val = t;
//        }
//        System.out.println(":");
//    }



//    TreeNode prev = null, first = null, second = null, temp = null;
//
//    public void recoverTree(TreeNode root) {
//        morrisTraversal(root);
//        if (first != null && second != null) {
//            int t = first.val;
//            first.val = second.val;
//            second.val = t;
//        }
//    }
//
//    private void morrisTraversal(TreeNode root) {
//        while (root != null) {
//            if (prev != null && prev.val > root.val) {
//                if (first == null) {
//                    first = prev;
//                }
//                second = root;
//            }
//            if (root.left != null) {
//                temp = root.left;
//                while (temp.right != null && temp.right != root) {
//                    temp = temp.right;
//                }
//
//                if (temp.right != null) {
//                    prev = root;
//                    temp.right = null;
//                    root = root.right;
//                } else {
//                    temp.right = root;
//                    root = root.left;
//                }
//
//            } else {
//                prev = root;
//                root = root.right;
//            }
//        }
//    }

    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        helper(root);
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;
        helper(root.right);
    }



    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode one = new TreeNode(1);
//        TreeNode four = new TreeNode(4);
//        TreeNode two = new TreeNode(2);
//
//        four.left = two;
//        root.left = one;
//        root.right = four;


        TreeNode root = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        three.right = two;
        root.left = three;

        NineNine nineNine = new NineNine();
//        TreeNode t = nineNine.recoverTree(root);
        nineNine.recoverTree(root);
//        System.out.println("\n");
//        nineNine.morrisTraversal(root);
    }
}

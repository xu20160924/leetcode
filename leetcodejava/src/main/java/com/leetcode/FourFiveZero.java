package com.leetcode;

import com.entity.TreeNode;

public class FourFiveZero {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null && cur.val != key) {
            pre = cur;
            if (cur.val > key) {
                cur = cur.left;
            }
            if (cur.val < key) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }

    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        for(;next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if (root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }

    //    public TreeNode deleteNode(TreeNode root, int key) {
//
//        if (root.left == null && root.right == null && root.val == key) {
//            return null;
//        }
//        if (root.val == key) {
//            root.right.left = root.left;
//        }
//        helper(root, root, key);
//
//        return root;
//    }
//
//    private void helper(TreeNode cur, TreeNode prev, int key) {
//        if (cur == null) {
//            return;
//        }
//        if (key == cur.val) {
//            if (cur.left == null && cur.right == null) {
//                cur = null;
//               return;
//            }
//            if (cur.left != null && cur.right != null) {
//                if (cur.left.val < prev.val) {
//                    cur.left.right = cur.right;
//                    prev.left = cur.left;
//                } else {
//                    cur.right.left = cur.left;
//                    prev.right = cur.right;
//                }
//            }
//            if (cur.val < prev.val) {
//                prev.left = cur.left == null ? cur.right : cur.left;
//            } else {
//                prev.right = cur.left == null ? cur.right : cur.left;
//            }
//        }
//
//        if (key > cur.val) {
//            helper(cur.right, cur, key);
//        } else {
//            helper(cur.left, prev, key);
//        }
//    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//        if (key < root.val) {
//            root.left = deleteNode(root.left, key);
//        } else if (key > root.val) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            if (root.left == null) {
//                return root.right;
//            } else if (root.right == null) {
//                return root.left;
//            }
//            TreeNode minNode = findMin(root.right);
//            root.val = minNode.val;
//            root.right = deleteNode(root.right, root.val);
//        }
//        return root;
//    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        helper(root, root, key);
//        return root;
//    }
//
//    private TreeNode helper(TreeNode root, TreeNode prev, int key) {
//        if (root == null) {
//            return null;
//        }
//        if (key < root.val) {
//            root.left = helper(root.left, root, key);
//        } else if (key > root.val) {
//            root.right = helper(root.right, root, key);
//        } else {
//            if (root.left == null) {
//                return root.right;
//            } else if (root.right == null) {
//                return root.left;
//            }
//            TreeNode minNode = findMin(root.right);
//            root.val = minNode.val;
//            prev.right = root.right;
////            root.right = deleteNode(root.right, root.val);
//        }
//        return root;
//    }


//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root == null) {
//            return null;
//        }
//
//        if (root.val > key) {
//            root.left = deleteNode(root.left, key);
//        } else if (root.val < key) {
//            root.right = deleteNode(root.right, key);
//        } else {
//            if (root.left == null) {
//                return root.right;
//            }
//            if (root.right == null) {
//                return root.left;
//            }
//
//            TreeNode rightSmallest = root.right;
//            while (rightSmallest.left != null) {
//                rightSmallest = rightSmallest.left;
//            }
//            rightSmallest.left = root.left;
//            return root.right;
//        }
//        return root;
//    }


//    private TreeNode deleteRootNode(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        if (root.left == null) {
//            return root.right;
//        }
//        if (root.right == null) {
//            return root.left;
//        }
//        TreeNode next = root.right;
//        TreeNode pre = null;
//        for (; next.left != null; pre = next, next = next.left);
//        next.left = root.left;
//        if (root.right != next) {
//            pre.left = next.right;
//            next.right = root.right;
//        }
//        return next;
//    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        TreeNode cur = root;
//        TreeNode pre = null;
//        while (cur != null && cur.val != key) {
//            pre = cur;
//            if (key < cur.val) {
//                cur = cur.left;
//            } else if (key > cur.val) {
//                cur = cur.right;
//            }
//        }
//        if (pre == null) {
//            return deleteRootNode(cur);
//        }
//        if (pre.left == cur) {
//            pre.left = deleteRootNode(cur);
//        } else {
//            pre.right = deleteRootNode(cur);
//        }
//        return root;
//    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public static void main(String[] args) {
        FourFiveZero fourFiveZero = new FourFiveZero();
        TreeNode root = new TreeNode(50);
        TreeNode three = new TreeNode(30);
        TreeNode four = new TreeNode(40);
        TreeNode seven = new TreeNode(70);
        TreeNode six = new TreeNode(60);
        TreeNode eight = new TreeNode(80);

        seven.left = six;
        seven.right = eight;
        three.right = four;
        root.left = three;
        root.right = seven;


        TreeNode a = fourFiveZero.deleteNode(root, 50);
        System.out.println("");
    }
}

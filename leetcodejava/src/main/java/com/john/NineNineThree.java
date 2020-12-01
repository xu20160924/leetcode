package com.john;

import com.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-11-01 10:36
 * @description: 993
 **/
public class NineNineThree {
//    public boolean isCousins(TreeNode root, int x, int y) {
//        Map<Integer, TreeNode> map = new HashMap<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            TreeNode par = null;
//
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.val == x || node.val == y) {
//                    if (par == null) {
//                        par = map.get(node.val);
//                    } else {
//                        return par != map.get(node.val);
//                    }
//                }
//                if (node.left != null) {
//                    queue.add(node.left);
//                    map.put(node.left.val, node);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                    map.put(node.right.val, node);
//                }
//            }
//        }
//        return false;
//    }

//    int depth;
//    TreeNode par;
//
//    public boolean isCousins(TreeNode root, int x, int y) {
//        depth = -1;
//        par = null;
//        return helper(root, null, 0, x, y);
//    }
//
//    private boolean helper(TreeNode root, TreeNode par, int depth, int x, int y) {
//        if (root == null) {
//            return false;
//        }
//
//        if (root.val == x || root.val == y) {
//            if (this.par != null) {
//                return this.depth == depth && this.par != par;
//            }
//            this.depth = depth;
//            this.par = par;
//        }
//        return helper(root.left, root, depth + 1, x, y) || helper(root.right, root, depth + 1, x, y);
//    }


    public boolean isCousins(TreeNode root, int A, int B) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isAexist = false;
            boolean isEexist = false;
            for (int i = 0; i< size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A) {
                    isAexist = true;
                }
                if (cur.val == B) {
                    isEexist = true;
                }
                if (cur.left != null && cur.right != null) {
                    if (cur.left.val == A && cur.right.val == B) {
                        return false;
                    }
                    if (cur.left.val == B && cur.right.val == A) {
                        return false;
                    }
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (isAexist && isEexist) {
                return true;
            }
        }
        return false;
    }

    //    public boolean isCouins(TreeNode root, int x, int y) {
//
//    }
//
//    private void helper(TreeNode root1, TreeNode root2, int x, int y) {
//        if (root1 == null) {
//            return;
//        }
//
//        helper(root1.left, );
//    }
    public static void main(String[] args) {
        NineNineThree nineNineThree = new NineNineThree();

        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,2,3,null,4,null,5});
        System.out.println(nineNineThree.isCousins(root, 5, 4));
    }
}

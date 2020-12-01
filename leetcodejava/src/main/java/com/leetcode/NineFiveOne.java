package com.leetcode;

import com.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: John
 * @date: 2020-10-29 15:45
 * @description: 951
 **/
public class NineFiveOne {
//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 != null) {
//            return false;
//        }
//        if (root1 != null && root2 == null) {
//            return false;
//        }
//        if (root1 == null && root2 == null) {
//
//        }
//        return helper(root1, root2);
//    }
//
//    private boolean helper(TreeNode root1, TreeNode root2) {
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        Queue<TreeNode> queue2 = new LinkedList<>();
//        queue1.add(root1);
//        queue2.add(root2);
//        while (!queue1.isEmpty() && !queue2.isEmpty()) {
//            int size = queue1.size();
//            int size2 = queue2.size();
//            if (size != size2) {
//                return false;
//            }
//            Set<Integer> set1 = new HashSet<>();
//            Set<Integer> set2 = new HashSet<>();
//            for (int i = 0; i < size; i++) {
//                TreeNode node1 = queue1.poll();
//                TreeNode node2 = queue2.poll();
//                set1.add(node1.val);
//                set2.add(node2.val);
//                if (node1.left != null) {
//                    queue1.add(node1.left);
//                }
//                if (node1.right != null) {
//                    queue1.add(node1.right);
//                }
//                if (node2.left != null) {
//                    queue2.add(node2.left);
//                }
//                if (node2.right != null) {
//                    queue2.add(node2.right);
//                }
//            }
//            if (!set1.containsAll(set2)) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        return helper(root1, root2, root1, root2);
//    }
//
//    private boolean helper(TreeNode root1, TreeNode root2, TreeNode par1, TreeNode par2) {
//        if (root1.val == root2.val && par1.val == par2.val) {
//            return true;
//        }
//
//        return (helper(root1.left, root2.right, root1, root2) || helper(root1.left, root2.left, root1, root2) || helper(root1.right, root2.left, root1, root2) || helper(root1.right, root2.right, root1, root2));
//    }

//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        if (root1.val == root2.val) {
//            return true;
//        }
//        if (root1 == null || root2 == null || root1.val != root2.val) {
//            return false;
//        }
//        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
//                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
//    }


//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        List<Integer> vals1 = new ArrayList<>();
//        List<Integer> vals2 = new ArrayList<>();
//        dfs(root1, vals1);
//        dfs(root2, vals2);
//        return vals1.equals(vals2);
//    }
//
//    private void dfs(TreeNode node, List<Integer> vals) {
//        if (node != null) {
//            vals.add(node.val);
//            int L = node.left != null ? node.left.val : - 1;
//            int R = node.right != null ? node.right.val : -1;
//
//            if (L < R) {
//                dfs(node.left, vals);
//                dfs(node.right, vals);
//            } else {
//                dfs(node.right, vals);
//                dfs(node.left, vals);
//            }
////            vals.add(null);
//        }
//    }


//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        Queue<TreeNode> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
//        queue1.offer(root1);
//        queue2.offer(root2);
//        while (!queue1.isEmpty() && !queue2.isEmpty()) {
//            TreeNode node1 = queue1.poll(), node2 = queue2.poll();
//            if (node1 == null || node2 == null) {
//                if (node1 != node2) {
//                    return false;
//                } else {
//                    continue;
//                }
//            }
//            if (node1.val != node2.val) {
//                return false;
//            }
//            if (node1.left == node2.left || node1.left != null && node2.left != null && node1.left.val == node2.left.val) {
//                queue1.addAll(Arrays.asList(node1.left, node1.right));
//            } else {
//                queue1.addAll(Arrays.asList(node1.right, node1.left));
//            }
//            queue2.addAll(Arrays.asList(node2.left, node2.right));
//        }
//        return queue1.isEmpty() && queue2.isEmpty();
//    }





//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
//        stack1.push(root1);
//        stack2.push(root2);
//
//        while (!stack1.isEmpty() && !stack2.isEmpty()) {
//            TreeNode node1 = stack1.pop(), node2 = stack2.pop();
//            if (node1 == null || node2 == null) {
//                if (node1 != node2) {
//                    return false;
//                } else {
//                    continue;
//                }
//            }
//            if (node1.val != node2.val) {
//                return false;
//            }
//            if (node1.left == node2.left || (node1.left != null && node2.left != null && node1.left.val == node2.left.val)) {
//                stack1.addAll(Arrays.asList(node1.left, node1.right));
//            } else {
//                stack1.addAll(Arrays.asList(node1.right, node1.left));
//            }
//            stack2.addAll(Arrays.asList(node2.left, node2.right));
//        }
//        return stack1.isEmpty() && stack2.isEmpty();
//    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        if ((root1.left != null ? root1.left.val: -1) != (root2.left != null ? root2.left.val : -1)) {
            TreeNode t = root1.left;
            root1.left = root1.right;
            root1.right = t;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }


    public static void main(String[] args) {
//        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{1,2,3,4,5,6,null,null,null,7,8});
//        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{99,3,2,null,6,4,5,null,null,null,null,8,7});
        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, null, null, null, 7, 8});
        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7});
//        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{1, 2, 3});
//        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{1, 2, null, 3});
//
//        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{0, 3, 1, null, null, null, 2});
//        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{0, 3, 1, 2});


        /**
         * [1,2,3]
         * [1,2,null,3]
         */
//        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{1,2,3});
//        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{1,2,null,3});

        /**
         * [0,3,1,null,null,null,2]
         * [0,3,1,2]
         */


        /**
         * [0,null,1]
         * [0,1]
         * true
         */
//        TreeNode root1 = TreeNode.getTreeNode(new Integer[]{0, null, 1});
//        TreeNode root2 = TreeNode.getTreeNode(new Integer[]{0, 1});

        NineFiveOne nineFiveOne = new NineFiveOne();
        System.out.println(nineFiveOne.flipEquiv(root1, root2));
        System.out.println("");
    }
}

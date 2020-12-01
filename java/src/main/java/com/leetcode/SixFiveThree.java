package com.leetcode;

import com.entity.TreeNode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-04-14 17:57
 * @description: 653
 **/
public class SixFiveThree {

    // 方法不通过
//    public boolean findTarget(TreeNode root, int k) {
////        if (root.left == null || root.right == null) {
////           return false;
////        }
//        if (root.left == null && root.right == null) {
//           return false;
//        }
//        int left = root.left == null ? 0 : root.left.val;
//        int right = root.right == null ? 0 : root.right.val;
//
//        if (root.val < k) {
//            return findTarget(root.right, k - root.val);
//        } else if (root.val > k) {
//            return findTarget(root.left, k - root.val);
//        } else {
//            return true;
//        }
//    }


//    /**
//     * hashset
//     * @param root
//     * @param k
//     * @return
//     */
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        return find(root, k, set);
//    }
//
//    private boolean find(TreeNode root, int k, Set<Integer> set) {
//        if (root == null) {
//            return false;
//        }
//        if (set.contains(k - root.val)) {
//            return true;
//        }
//        set.add(root.val);
//        return find(root.left, k, set) || find(root.right, k, set);
//    }

    /**
     * bfs and hashset
     * @param root
     * @param k
     * @return
     */
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> set = new HashSet<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            if (queue.peek() != null) {
//                TreeNode node = queue.remove();
//                if (set.contains(k - node.val)) {
//                   return true;
//                }
//                set.add(node.val);
//                queue.add(node.right);
//                queue.add(node.left);
//            } else {
//                // remove 掉 null node
//                queue.remove();
//            }
//        }
//        return false;
//    }


    public boolean findTarget(TreeNode root, int k) {
       List<Integer> list = new ArrayList<>();
       inorder(root, list);
       int l = 0, r = list.size() - 1;
       while (l < r) {
          int sum = list.get(l) + list.get(r);
          if (sum == k) {
              return true;
          }
          if (sum < k) {
             l++;
          } else {
              r--;
          }
       }
       return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
           return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);

        six.right = seven;
        three.left = two;
        three.right = four;
        root.left = three;
        root.right = six;

//        TreeNode root = new TreeNode(2);
//        TreeNode one = new TreeNode(1);
//        TreeNode three = new TreeNode(3);
//        root.left = one;
//        root.right = three;


        SixFiveThree sixFiveThree = new SixFiveThree();
        System.out.println(sixFiveThree.findTarget(root, 3));
    }
}

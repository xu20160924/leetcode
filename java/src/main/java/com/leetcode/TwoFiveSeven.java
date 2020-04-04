package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-02-22 16:27
 * @description: 257
 **/
public class TwoFiveSeven {
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<>();
//        return dfs(root, res, "");
//
//    }
//    private List<String> dfs(TreeNode node, List<String> res, String str) {
//       if (node == null) {
//           return res;
//       }
//       str += node.val + "->";
//       if (node.left == null && node.right == null) {
//           str = str.substring(0, str.length() - 2);
//           res.add(str);
//           str = "";
//       }
//       dfs(node.left, res, str);
//       dfs(node.right, res, str);
//       return res;
//    }


//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> answer = new ArrayList<>();
//        if (root != null) {
//            searchBT(root, "", answer);
//        }
//        return answer;
//    }
//    private void searchBT(TreeNode root, String path, List<String> answer) {
//        if (root.left == null && root.right == null) {
//            answer.add(path + root.val);
//        }
//        if (root.left != null) {
//            searchBT(root.left, path + root.val + "->", answer);
//        }
//        if (root.right != null) {
//            searchBT(root.right, path + root.val + "->", answer);
//        }
//    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }
    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        two.right = five;
        root.left = two;
        root.right = three;

        TwoFiveSeven twoFiveSeven = new TwoFiveSeven();
        List<String> res = twoFiveSeven.binaryTreePaths(root);
    }
}

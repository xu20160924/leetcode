package com.lintcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-03-21 08:16
 * @description: 480
 **/
public class ThreeEightZero {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add("" + root.val);
            return paths;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

//    private void dfs() {
//
//    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);

        two.right = five;
        root.left = two;
        root.right = three;

        ThreeEightZero threeEightZero = new ThreeEightZero();
        threeEightZero.binaryTreePaths(root);
    }
}

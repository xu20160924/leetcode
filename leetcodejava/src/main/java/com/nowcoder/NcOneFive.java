package com.nowcoder;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-11-22 20:40
 * @description: NC15
 **/
public class NcOneFive {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }


    public static void main(String[] args) {
        NcOneFive ncOneFive = new NcOneFive();
        ArrayList<ArrayList<Integer>> a = ncOneFive.levelOrder(TreeNode.getTreeNode(new Integer[]{3,9,20,null,null,15,7}));
    }
//    private void traverse(TreeNode root, List<List<Integer>> res) {
//        if (root == null) {
//            return ;
//        }
//
//    }

}

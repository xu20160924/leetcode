package com.entity;

import java.util.LinkedList;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2019-12-29 19:07
 * @description:
 **/
public class TreeNode {
    public Integer val;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode parent = null;

    public TreeNode(Integer val) {
        this.val = val;
    }
    public static TreeNode listToTree(String src){
        src = src.substring(1,src.length()-1);
        String[] strList = src.split(",");

        TreeNode root  ;
        TreeNode result = null;
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i =0 ; i< strList.length ; i++){
            if (i == 0){
                root = new TreeNode(Integer.parseInt(strList[i]));
                result = root;
                queue.add(root);
            }
            if (!queue.isEmpty()){
                root = queue.poll();
            }else {
                break;
            }
            if ( i+1 < strList.length  && !strList[i+1].equals( "null")){
                root.left = new TreeNode(Integer.parseInt(strList[i +1]));
                queue.add(root.left);
            }
            if ( i + 2 < strList.length && !strList[i+2].equals( "null")){
                root.right = new TreeNode(Integer.parseInt(strList[i +2]));
                queue.add(root.right);
            }
            i = i +1;
        }
        return result;
    }
    public static TreeNode getTreeNode(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        LinkedList<TreeNode> subTree = new LinkedList<>();
        subTree.push(head);
        for (int i = 1; i < nums.length; i++) {
            if (!subTree.isEmpty()) {
                TreeNode cur = subTree.pop();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    subTree.add(cur.left);
                }
                i++;
                if (i >= nums.length) {
                    break;
                }
                if (nums[i] != null) {
                    cur.right = new TreeNode(nums[i]);
                    subTree.add(cur.right);
                }

            } else {
                break;
            }
        }
        return head;

    }


}

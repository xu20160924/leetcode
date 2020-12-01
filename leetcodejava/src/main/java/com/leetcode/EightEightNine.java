package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: John
 * @date: 2020-10-20 18:26
 * @description: 889
 **/
public class EightEightNine {
//    int[] pre, post;
//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        this.pre = pre;
//        this.post = post;
//        return make(0, 0, pre.length);
//    }
//
//    public  TreeNode make(int i0, int i1, int N) {
//        if (N == 0) {
//            return  null;
//        }
//        TreeNode root = new TreeNode(pre[i0]);
//        if (N == 1) {
//            return root;
//        }
//
//        int L = 1;
//        for (; L < N; ++L) {
//            if (post[i1 + L - 1] == pre[i0 + 1]) {
//                break;
//            }
//        }
//        root.left = make(i0 + 1, i1, L);
//        root.right = make(i0 + L+ 1, i1 + L, N -1 -L);
//        return  root;
//    }

//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        int N = pre.length;
//        if (N == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[0]);
//        if (N == 1) {
//            return root;
//        }
//        int L = 0;
//
//        for (int i = 0; i < N; ++i)
//            if (post[i] == pre[1])
//                L = i+1;
//
//        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1), Arrays.copyOfRange(post, 0, L));
//        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N), Arrays.copyOfRange(post, L, N - 1));
//        return root;
//    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        EightEightNine eightEightNine = new EightEightNine();
        TreeNode a =  eightEightNine.constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
        System.out.println("");
    }
//    int[] pre, post;
//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        this.pre = pre;
//        this.post = post;
//        return make(0, 0, pre.length);
//    }
//    private TreeNode make(int i0, int i1, int N) {
//        if (N == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[i0]);
//        if (N == 1) {
//            return root;
//        }
//        int L = 1;
//        for (; L < N; ++L) {
//            if (post[i1 + L - 1] == pre[i0 + 1]) {
//                break;
//            }
//        }
//        root.left = make(i0 + 1, i1, L);
//        root.right = make(i0 + L + 1, i1 + L, N - 1 - L);
//        return root;
//    }

//    int preIndex = 0, posIndex = 0;
//    public TreeNode constructFromPrePost(int[] pre, int[] post) {
//        TreeNode root = new TreeNode(pre[preIndex++]);
//        if (root.val != post[posIndex]) {
//            root.left = constructFromPrePost(pre, post);
//        }
//        if (root.val != post[posIndex]) {
//            root.right = constructFromPrePost(pre, post);
//        }
//        posIndex++;
//        return root;
//    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode>  s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast(); j++;
            }
            if (s.getLast().left == null) {
                s.getLast().left = node;
            } else {
                s.getLast().right = node;
            }
            s.offer(node);
        }
        return s.getFirst();
    }


}


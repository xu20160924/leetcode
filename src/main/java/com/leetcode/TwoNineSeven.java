package com.leetcode;

import com.entity.TreeNode;

import javax.crypto.spec.PSource;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2020-03-23 13:51
 * @description: 297
 **/
public class TwoNineSeven {

    private static final String spliter = ",";
    private static final String NN = "X";


//    public String serialize(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        buildString(root, sb);
//        return sb.toString();
//    }
//
//    private void buildString(TreeNode node, StringBuilder sb) {
//        if (node == null) {
//           sb.append(NN).append(spliter);
//        } else {
//            sb.append(node.val).append(spliter);
//            buildString(node.left, sb);
//            buildString(node.right, sb);
//        }
//    }
//
//    public TreeNode deserialize(String data) {
//        Deque<String> nodes = new LinkedList<>();
//        nodes.addAll(Arrays.asList(data.split(spliter)));
//        return buildTree(nodes);
//    }
//
//    private TreeNode buildTree(Deque<String> nodes) {
//        String val = nodes.remove();
//        if (val.equals(NN)) {
//           return null;
//        } else {
//            TreeNode node = new TreeNode(Integer.valueOf(val));
//            node.left = buildTree(nodes);
//            node.right = buildTree(nodes);
//            return node;
//        }
//    }

//    public String serialize(TreeNode root) {
//        return serial(new StringBuilder(), root).toString();
//    }
//
//    private StringBuilder serial(StringBuilder str, TreeNode root) {
//        if (root == null) {
//           return str.append("#");
//        }
//        str.append(root.val).append(",");
//        serial(str, root.left).append(",");
//        serial(str, root.right).append(",");
//        return str;
//    }

    public TreeNode deserialize(String data) {
        return desrial(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode desrial(Queue<String> q) {
        String val = q.poll();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = desrial(q);
        root.right = desrial(q);
        return root;
    }


    public String serialize(TreeNode root) {
        return serial(new StringBuilder(), root).toString();
    }

    private StringBuilder serial(StringBuilder str, TreeNode root) {
        if (root == null) {
           return str.append("#");
        }
        str.append(root.val).append(",");
        serial(str, root.left).append(",");
        serial(str, root.right);
        return str;
    }

    // wrong answer
//    public TreeNode deserialize(String data) {
//       return desrial(new StringBuilder().append(data));
//    }
//
//    private TreeNode desrial(StringBuilder data) {
////        if (data.length() == 0) {
////            return null;
////        }
//        String val = data.substring(0, 1);
//        data = data.deleteCharAt(0);
//        if (",".equals(val)) {
//            val = data.substring(0, 1);
//            data = data.deleteCharAt(0);
//        }
//        if ("#".equals(val)) {
//           return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.valueOf(val));
//        root.left = desrial(data);
//        root.right = desrial(data);
//        return root;
//    }

    public static void main(String[] args) {
        TwoNineSeven twoNineSeven = new TwoNineSeven();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        three.left = four;
        three.right = five;
        root.left = two;
        root.right = three;

        System.out.println(twoNineSeven.serialize(root));
        TreeNode result = twoNineSeven.deserialize(twoNineSeven.serialize(root));
    }
}




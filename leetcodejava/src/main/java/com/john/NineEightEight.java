package com.john;

import com.entity.TreeNode;

/**
 * @author: John
 * @date: 2020-11-01 08:33
 * @description: 988
 **/
public class NineEightEight {


//    char[] dict = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'
//            , 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//
//    public String smallestFromLeaf(TreeNode root) {
//        TreeMap<String, String> map = new TreeMap<>();
//        helper(root, map, "");
//        String str = map.firstKey();
//        return str;
//    }
//
//    private void helper(TreeNode root, TreeMap map, String key) {
//        if (root == null) {
//            return;
//        }
//        String newKey = dict[root.val] + key;
//        if (!map.containsKey(newKey)) {
//            map.put(newKey, newKey);
//            map.remove(key);
//        }
//        helper(root.left, map, newKey);
//        helper(root.right, map, newKey);
//    }

    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append((char) 'a' + node.val);
        if (node.left == null && node.right == null) {
            sb.reverse();
            String s = sb.toString();
            sb.reverse();
            if (s.compareTo(ans) < 0) {
                ans = s;
            }
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf('a'));
//        System.out.println((char)(0 + 97));
        NineEightEight nineEightEight = new NineEightEight();
        TreeNode root = TreeNode.getTreeNode(new Integer[]{1,
                2,
                2,
                4,
                4,
                4,
                4,
                8,
                8,
                8,
                8,
                8,
                8,
                8,
                8,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16,
                16});
        nineEightEight.smallestFromLeaf(root);
    }


}

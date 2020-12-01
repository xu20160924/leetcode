package com.leetcode;

import com.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: John
 * @date: 2020-10-12 10:10
 * @description: 199
 **/
public class OneNineNine {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode curr, List<Integer> result, int depth) {
        if (curr == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(curr.val);
        }
        helper(curr.right, result, depth + 1);
        helper(curr.left, result, depth + 1);
    }

}

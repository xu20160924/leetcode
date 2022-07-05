package com.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Denial.AO
 * @date: 2020-12-03 16:07
 * @description: 784
 **/
public class SevenEightFour {
    //    public List<String> letterCasePermutation(String S) {
//        if (S == null) {
//            return new LinkedList<>();
//        }
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(S);
//
//        for (int i = 0; i < S.length(); i++) {
//            if (Character.isDigit(S.charAt(i))) {
//                continue;
//            }
//            int size = queue.size();
//            for (int j = 0; j < size; j++) {
//                String cur = queue.poll();
//                char[] chs = cur.toCharArray();
//
//                chs[i] = Character.toUpperCase(chs[i]);
//                queue.offer(String.valueOf(chs));
//
//                chs[i] = Character.toLowerCase(chs[i]);
//                queue.offer(String.valueOf(chs));
//            }
//        }
//        return new LinkedList<>(queue);
//    }
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        List<String> res = new LinkedList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }

    private void helper(char[] chs, List<String> res, int pos) {
        if (pos == chs.length) {
            res.add(new String(chs));
            return;
        }
        if (chs[pos] >= '0' && chs[pos] <= '9') {
            helper(chs, res, pos + 1);
            return;
        }

        chs[pos] = Character.toUpperCase(chs[pos]);
        helper(chs, res, pos + 1);

        chs[pos] = Character.toLowerCase(chs[pos]);
        helper(chs, res, pos + 1);
    }
}


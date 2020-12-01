package com.lintcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: John
 * @date: 2020-04-02 09:11
 * @description: 136
 **/
public class OneThreeSix {

    //    public List<List<String>> partition(String s) {
//        List<List<String>> results = new ArrayList<>();
//        if (s == null || s.length() == 0) {
//            return results;
//        }
//        List<String> partition = new ArrayList<>();
//        helper(s, 0, partition, results);
//        return results;
//    }
//
//    private void helper(String s, int startIndex, List<String> partition,
//                        List<List<String>> results) {
//        if (startIndex == s.length()) {
//            results.add(new ArrayList<>(partition));
//            return;
//        }
//        for (int i = startIndex; i < s.length(); i++) {
//            String subString = s.substring(startIndex, i + 1);
//            if (!isPalindrome(s)) {
//               continue;
//            }
//            partition.add(subString);
//            helper(s, i + 1, partition, results);
//            partition.remove(partition.size() - 1);
//        }
//    }
//
//    private boolean isPalindrome(String s) {
//       for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
//           if (s.charAt(i) != s.charAt(j)) {
//              return false;
//           }
//       }
//       return true;
//    }
//    List<List<String>> results;
//    boolean[][] isPalindrome;
//
//    public List<List<String>> partition(String s) {
//        results = new ArrayList<>();
//        if (s == null || s.length() == 0) {
//            return results;
//        }
//        getIsPalindrome(s);
//        helper(s, 0, new ArrayList<>());
//        return results;
//    }
//
//    private void getIsPalindrome(String s) {
//        int n = s.length();
//        isPalindrome = new boolean[n][n];
//
//        for (int i = 0; i < n; i++) {
//            isPalindrome[i][i] = true;
//        }
//        for (int i = 0; i < n - 1; i++) {
//            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
//        }
//
//        for (int i = n - 3; i >= 0; i--) {
//            for (int j = i + 2; j < n; j++) {
//                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
//            }
//        }
//    }
//
//    private void helper(String s, int startIndex, List<Integer> partition) {
//        if (startIndex == s.length()) {
//            addResult(s, partition);
//            return;
//        }
//
//        for (int i = startIndex; i < s.length(); i++) {
//            if (!isPalindrome[startIndex][i]) {
//                continue;
//            }
//            partition.add(i);
//            helper(s, i + 1, partition);
//            partition.remove(partition.size() - 1);
//        }
//    }
//
//    private void addResult(String s, List<Integer> partition) {
//        List<String> result = new ArrayList<>();
//        int startIndex = 0;
//        for (int i = 0; i < partition.size(); i++) {
//            result.add(s.substring(startIndex, partition.get(i) + 1));
//            startIndex = partition.get(i) + 1;
//        }
//        results.add(result);
//    }

//    public List<List<String>> partition(String s) {
//        int len = s.length();
//        List<List<String>> res = new ArrayList<>();
//        if (len == 0) {
//            return res;
//        }
//        // 预处理
//        // 状态: dp[i][j] 表示s[i][j] 是否是回文
//        boolean[][] dp = new boolean[len][len];
//        // 状态转移方程: 在s[i] == s[j]的时候, dp[i][j] 参考dp[i + 1][j - 1]
//        for (int right = 0;  right < len; right++) {
//            // 注意 left <= right 取等号表示1个字符的时候也需要判断
//            for (int left = 0; left <= right; left++) {
//                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
//                    dp[left][right] = true;
//                }
//            }
//        }
//
//        Deque<String> stack = new ArrayDeque<>();
//        backtracking(s, 0, len, dp, stack, res);
//        return res;
//    }
//
//    private void backtracking(String s, int start, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
//       if (start == len) {
//          res.add(new ArrayList<>(path));
//          return;
//       }
//       for (int i = start; i < len; i++) {
//           // 剪枝
//           if (!dp[start][i]) {
//                continue;
//           }
//           path.addLast(s.substring(start , i  + 1));
//           backtracking(s, i + 1, len, dp, path, res);
//           path.removeLast();
//       }
//    }

    public List<List<String>> partition(String s) {
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        for (int len = 1; len <= l; len++) {
            for (int i = 0; i <= s.length(); i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
            }
        }
        return partitionHelper(s, 0, dp);
    }

    private List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
        if (start == s.length()) {
//            List<List<String>> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(list);
            return ans;
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
               String left = s.substring(start, i + 1);
               for (List<String> l : partitionHelper(s, i + 1, dp)) {
                  l.add(0, left);
                  ans.add(l);
               }
            }
        }
        return ans;
    }

}

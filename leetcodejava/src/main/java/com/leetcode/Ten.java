package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-14 19:34
 * @description: 10
 **/
public class Ten {
    enum Result {
        TRUE, FALSE
    }

    Result[][] memo;
    // top-down
//    public boolean isMatch(String text, String pattern) {
//        memo = new Result[text.length() + 1][pattern.length() + 1];
//        return dp(0, 0, text, pattern);
//    }
//
//    public boolean dp(int i, int j, String text, String pattern) {
//        if (memo[i][j] != null) {
//            return memo[i][j] == Result.TRUE;
//        }
//        boolean ans;
//        if (j == pattern.length()) {
//            ans = i == text.length();
//        } else {
//            boolean first_match = (i < text.length()) &&
//                    (pattern.charAt(j) == text.charAt(i) ||
//                            pattern.charAt(j) == '.');
//            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
//                ans = (dp(i, j + 2, text, pattern) ||
//                        first_match && dp(i + 1, j, text, pattern));
//            } else {
//                ans = first_match && dp(i + 1, j + 1, text, pattern);
//            }
//        }
//        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
//        return ans;
//    }


//    public boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) {
//            return text.isEmpty();
//        }
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) ||
//                        pattern.charAt(0) == '.'));
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

//    public boolean isMatch(String text, String pattern) {
//        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
//        dp[text.length()][pattern.length()] = true;
//        for (int i = text.length(); i >= 0; i--) {
//            for (int j = pattern.length(); j >= 0; j--) {
//                boolean first_match = (!text.isEmpty() &&
//                        text.charAt(i) == pattern.charAt(j) ||
//                        pattern.charAt(j) == '.');
//                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
//                    dp[i][j] = dp[i][j + 2] || first_match && dp[i+1][j];
//                } else {
//                    dp[i][j] =  first_match && dp[i + 1][j + 1];
//                }
//            }
//        }
//        return dp[0][0];
//    }

    public boolean isMatch(String s, String p) {
       if (s == null || p == null) {
           return false;
       }
       boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
       dp[0][0] = true;
       for (int i = 0; i < p.length(); i++) {
           if (p.charAt(i) == '*' && dp[0][i - 1]) {
               dp[0][i + 1] = true;
           }
       }
       for (int i = 0; i < s.length(); i++) {
           for (int j = 0; j < p.length(); j++) {
               if (p.charAt(j) == '.') {
                   dp[i+1][j+1] = dp[i][j];
               }
               if (p.charAt(j) == s.charAt(i)) {
                   dp[i+1][j+1] = dp[i][j];
               }
               if (p.charAt(j) == '*') {
                   if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                   } else {
                       dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                   }
               }
           }
       }
       return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
//        String str = "mississippi";
//        String pattern = "mis*is*p*.";
//        String pattern = "c*a*b";
//        String str = "aab";
        String str = "aa";
        String pattern = "a";
        Ten ten = new Ten();
        System.out.println(ten.isMatch(str, pattern));
    }
}

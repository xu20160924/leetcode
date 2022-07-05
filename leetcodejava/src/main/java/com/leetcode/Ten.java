package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-14 19:34
 * @description: 10
 **/
public class Ten {

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

//    public boolean isMatch(String s, String p) {
//       if (s == null || p == null) {
//           return false;
//       }
//       boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//       dp[0][0] = true;
//       for (int i = 0; i < p.length(); i++) {
//           if (p.charAt(i) == '*' && dp[0][i - 1]) {
//               dp[0][i + 1] = true;
//           }
//       }
//       for (int i = 0; i < s.length(); i++) {
//           for (int j = 0; j < p.length(); j++) {
//               if (p.charAt(j) == '.') {
//                   dp[i+1][j+1] = dp[i][j];
//               }
//               if (p.charAt(j) == s.charAt(i)) {
//                   dp[i+1][j+1] = dp[i][j];
//               }
//               if (p.charAt(j) == '*') {
//                   if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
//                        dp[i+1][j+1] = dp[i+1][j-1];
//                   } else {
//                       dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
//                   }
//               }
//           }
//       }
//       return dp[s.length()][p.length()];
//    }

//    public boolean isMatch(String s, String p) {
//        if (p == null || p.equals("")) {
//            return (s == null || s.equals(""));
//        }
//        boolean bool = (s != null && !s.equals("")) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
//        if (p.length() > 2 && p.charAt(1) == '*') {
//            return (isMatch(s, p.substring(2)) || (bool && isMatch(s.substring(1), p)));
//        } else {
//            return (bool && isMatch(s.substring(1), p.substring(1)));
//        }
//    }

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

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 2; j < n + 1; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);
                if (charS == charP || charP == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    char preAsterisk = p.charAt(j - 2);
                    if (preAsterisk != '.' && preAsterisk != charS) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 2]
                                || dp[i - 1][j - 2]
                                || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        boolean[][] dp = new boolean[2][2];
        int[][] test = new int[2][3];
//        String str = "mississippi";
//        String pattern = "mis*is*p*.";
//        String pattern = "c*a*b";
//        String str = "aab";

//        string str = "aab";
//        Solution *solution = new Solution();
//        cout << solution->isMatch(str, "c*a*b") << endl;

        String str = "aab";
        String pattern = "c*a*b";
        Ten ten = new Ten();
        System.out.println(ten.isMatch(str, pattern));
    }
}

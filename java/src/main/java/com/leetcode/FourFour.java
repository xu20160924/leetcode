package com.leetcode;

/**
 * @author: John
 * @date: 2020-03-15 16:18
 * @description: 44
 **/
public class FourFour {

//    public boolean comparison(String str, String pattern) {
//        int s = 0, p = 0, match = 0, starIdx = -1;
//        while (s < str.length()) {
//            // advancing both pointers
//            if (p < pattern.length() && (pattern.charAt(p) == '?' ||
//                    str.charAt(s) == pattern.charAt(p))) {
//                s++;
//                p++;
//            }
//            // found only advancing pattern pointer
//            else if (p < pattern.length() && pattern.charAt(p) == '*') {
//                starIdx = p;
//                match = s;
//                p++;
//            }
//            // last pattern pointer was *, advancing string pointer
//            else if (starIdx != -1) {
//                p = starIdx + 1;
//                match++;
//                s = match;
//            }
//            // current pattern pointer is not star, last patter pointer was not *
//            // characters do not match
//            else {
//                return false;
//            }
//        }
//        // check for remaining characters in pattern
//        while (p < pattern.length() && pattern.charAt(p) == '*') {
//            p++;
//        }
//        return p == pattern.length();
//    }
//    public boolean isMatch(String s, String p) {
//       boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
//       match[s.length()][p.length()] = true;
//       for (int i = p.length() - 1; i >= 0; i--) {
//           if (p.charAt(i)!='*') {
//               break;
//           } else {
//               match[s.length()][i] = true;
//           }
//       }
//       for (int i = s.length() - 1; i >= 0; i--) {
//           for (int j = p.length() - 1; j >= 0; j--) {
//               if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
//                   match[i][j] = match[i+1][j+1];
//               } else if (p.charAt(j) == '*') {
//                   match[i][j] = match[i][j+1] || match[i + 1][j];
//               } else {
//                   match[i][j] = false;
//               }
//           }
//       }
//       return match[0][0];
//    }

//    public boolean isMatch_2d_method(String s, String p) {
//       int m = s.length(), n = p.length();
//       boolean[][] dp = new boolean[m+1][n+1];
//       dp[0][0] = true;
//       for (int i = 1; i <= m; i++) {
//           dp[i][0] = false;
//       }
//
//       for (int j = 1; j <= n; j++) {
//           if (p.charAt(j - 1) == '*') {
//               dp[0][j] = true;
//           } else {
//               break;
//           }
//       }
//
//       for (int i = 1; i <= m; i++) {
//           for (int j = 1; j <= n; j++) {
//               if (p.charAt(j-1) != '*') {
//                   dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) ||
//                           p.charAt(j - 1) == '?');
//               } else {
//                   dp[i][j] = dp[i-1][j] || dp[i][j-1];
//               }
//           }
//       }
//       return dp[m][n];
//    }

//    public boolean isMatch(String s, String p) {
//       int m = s.length(), n = p.length();
//       boolean[] dp = new boolean[n];
//       dp[0] = true;
//       for (int i = 1; i <= m; i++) {
//           for (int j = 1; j <= n; j++) {
//               if () {
//
//               }
//           }
//       }
//    }


    public static void main(String[] args) {
        FourFour fourfour = new FourFour();
//        fourfour.comparison("adceb", "*a*b");
//        fourfour.comparison("aa", "*");
    }
}

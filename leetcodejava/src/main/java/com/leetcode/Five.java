package com.leetcode;

/**
 * @author: John
 * @date: 2020-02-15 10:34
 * @description: 5
 **/
public class Five {
//    public char[] manacherString(String str) {
//        char[] charArr = str.toCharArray();
//        char[] res = new char[str.length() * 2 + 1];
//        int index = 0;
//        for (int i = 0; i != res.length; i++) {
//            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
//        }
//        return res;
//    }


    /**
     * S="abc435cba"，S="abc534cba"，最长公共子串是 "abc" 和 "cba"，但很明显这两个字符串都不是回文串。
     * <p>
     * 所以我们求出最长公共子串后，并不一定是回文串，我们还需要判断该字符串倒置前的下标和当前的字符串下标是不是匹配。
     *
     * @param s
     * @return
     */
//    public String longestPalindrome(String s) {
//        if (s.equals("")) {
//            return "";
//        }
//        String origin = s;
//        String reverse = new StringBuffer(s).reverse().toString();
//        int length = s.length();
//        int[][] arr = new int[length][length];
//        int maxLen = 0;
//        int maxEnd = 0;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                if (origin.charAt(i) == reverse.charAt(j)) {
//                    if (i == 0 || j == 0) {
//                        arr[i][j] = 1;
//                    } else {
//                        arr[i][j] = arr[i - 1][j - 1] + 1;
//                    }
//                }
//                if (arr[i][j] > maxLen) {
//                    maxLen = arr[i][j];
//                    maxEnd = i; // 以i位置结尾的字符
//                }
//            }
//        }
//        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
//    }

//    public String longestPalindrome(String s) {
//        if (s.equals("")) {
//            return "";
//        }
//        String origin = s;
//        String reverse = new StringBuffer(s).reverse().toString();
//        int length = s.length();
//        int[][] arr = new int[length][length];
//        int maxLen = 0;
//        int maxEnd = 0;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                if (origin.charAt(i) == reverse.charAt(j)) {
//                    if (i == 0 || j == 0) {
//                        arr[i][j] = 1;
//                    } else {
//                        arr[i][j] = arr[i-1][j-1]+1;
//                    }
//                }
//                // 增加下标判断
//                if (arr[i][j] > maxLen) {
//                    int beforeRev = length - 1 -j;
//                    if (beforeRev + arr[i][j] - 1 == i) {     //判断下标是否对应
//                       maxLen = arr[i][j];
//                       maxEnd = i;
//                    }
//                }
//            }
//        }
//        return s.substring(maxEnd-maxLen+1, maxEnd+1);
//    }


//    public String longestPalindrome(String s) {
//       if (s.equals("")) {
//           return "";
//       }
//       String origin = s;
//       String reverse = new StringBuffer(s).reverse().toString();
//       int length = s.length();
//       int[] arr = new int[length];
//       int maxLen = 0;
//       int maxEnd = 0;
//       for (int i = 0; i < length; i++) {
//           for (int j = length - 1; j >= 0; j--) {
//               if (origin.charAt(i) == reverse.charAt(j)) {
//                   if (i == 0 || j == 0) {
//                       arr[j] = 1;
//                   } else {
//                       arr[j] = arr[j - 1] + 1;
//                   }
//               } else {
//                   arr[j] = 0;
//               }
//               if (arr[j] > maxLen) {
//                   int beforeRev = length - 1 -j;
//                   if (beforeRev + arr[j] - 1==i) {
//                      maxLen = arr[j];
//                      maxEnd = i;
//                   }
//               }
//           }
//       }
//       return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
//    }
//    public String longestPalindrome(String s) {
//        int length = s.length();
//        boolean[][] P = new boolean[length][length];
//        int maxLen = 0;
//        String maxPal = "";
//        for (int len = 1; len <= length; len++) {
//            for (int start = 0; start < length; start++) {
//                int end = start + len - 1;
//                if (end >= length) {
//                    break;
//                }
//                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
//                if (P[start][end] && len > maxLen) {
//                    maxPal = s.substring(start, end + 1);
//                }
//            }
//        }
//        return maxPal;
//    }

//    public String longestPalindrome(String s) {
//        int n = s.length();
//        String res = "";
//        boolean[][] dp = new boolean[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i + 1][j-1]);
//                if (dp[i][j] &&  j -1 + 1 > res.length()) {
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//        return res;
//    }

//    public String longestPalindrome(String s) {
//       int n = s.length();
//       String res = "";
//       boolean[] P = new boolean[n];
//       for (int i = n -1; i >= 0; i--) {
//           for (int j = n -1; j>=i; j--) {
//               P[j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || P[j-1]);
//               if (P[j] && j-i + 1> res.length()) {
//                   res = s.substring(i, j + 1);
//               }
//           }
//       }
//       return res;
//    }

//    public String longestPalindrome(String s) {
//       if (s == null | s.length() < 1) {
//           return "";
//       }
//       int start = 0, end = 0;
//       for (int i = 0; i < s.length(); i++) {
//           int len1 = expandAroundCenter(s, i , i );
//           int len2 = expandAroundCenter(s, i, i + 1);
//           int len = Math.max(len1, len2);
//           if (len > end - start) {
//               start = i - (len - 1) /2;
//               end = i + len / 2;
//           }
//       }
//       return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//           L--;
//           R++;
//        }
//        return R - L - 1;
//    }

//    public String preProcess(String s) {
//       int n = s.length();
//       if (n == 0) {
//           return "^$";
//       }
//       String ret = "^";
//       for (int i = 0; i < n; i++) {
//           ret += "#" + s.charAt(i);
//       }
//       ret += "#$";
//       return ret;
//    }
//
//    public String longestPalindrome(String s) {
//        String T = preProcess(s);
//        int n = T.length();
//        int[] P = new int[n];
//        int C = 0, R = 0;
//        for (int i = 1; i < n - 1; i++) {
//            int i_mirror = 2*C-i;
//            if (R > i) {
//               P[i] = Math.min(R - i, P[i_mirror]); //防止超出R
//            } else {
//                P[i] = 0;   //等于R的情况
//            }
//            // 碰到之前讲的三种情况时候，需要利用中心扩展法
//            while (T.charAt(i+1+P[i]) == T.charAt(i-1-P[i])) {
//                P[i]++;
//            }
//            //判断是否需要更新R
//            if (i + P[i] > R) {
//               C = i;
//               R = i + P[i];
//            }
//        }
//        //找出P的最大值
//        int maxLen = 0;
//        int centerIndex = 0;
//        for (int i = 1; i < n -1; i++) {
//            if (P[i] > maxLen) {
//                maxLen = P[i];
//                centerIndex = i;
//            }
//        }
//        int start = (centerIndex - maxLen) / 2; // 求原字符串的下标
//        return s.substring(start, start + maxLen);
//    }


//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        String res = s.substring(0, 1);
//
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLen && valid(s, i, j)) {
//                    maxLen = j - i + 1;
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//        return res;
//    }
//
//    private boolean valid(String s, int left, int right) {
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

//    public boolean isPalinromic(String s) {
//        int len = s.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (s.charAt(i) != s.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public String longestPalindrome(String s) {
//        String ans = "";
//        int max = 0;
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                String test = s.substring(i, j);
//                if (isPalinromic(test) && test.length() > max) {
//                    ans = s.substring(i, j);
//                    max = Math.max(max, ans.length());
//                }
//            }
//        }
//        return ans;
//    }

//    public String longestPalindrome(String s) {
//        int length = s.length();
//        boolean[][] P = new boolean[length][length];
//        int maxLen = 0;
//        String maxPal = "";
//        for (int len = 1; len <= length; len++) {
//            for (int start = 0; start < length; start++) {
//                int end = start + len - 1;
//                if (end >= length) {
//                    break;
//                }
//                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
//                if (P[start][end] && len > maxLen) {
//                    maxPal = s.substring(start, end + 1);
//                }
//            }
//        }
//        return maxPal;
//    }

//    public String longestPalindrome(String s) {
//       int n = s.length();
//       String res = null;
//       boolean[][] dp = new boolean[n][n];
//
//       for (int i = n -1; i >= 0; i--) {
//           for (int j = i; j < n; j++) {
//               dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3||dp[i+1][j-1]);
//               if (dp[i][j] &&(res== null ||j-i+1 >res.length())) {
//                   res = s.substring(i, j+1);
//               }
//           }
//       }
//       return res;
//    }

//    public String longestPalindrome(String s) {
//        String max = "";
//        for (int i = 0; i < s.length(); i++) {
//            String s1 = extend(s, i, i), s2 = extend(s, i, i+1);
//        }
//    }
//    private String extend(String s, int i, int j) {
//
//    }


//    public static void main(String[] args) {
//        String str = "abcbaade";
//        Five five = new Five();
//        five.longestPalindrome(str);
//    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Five five = new Five();
        five.longestPalindrome("cbbd");

    }
}

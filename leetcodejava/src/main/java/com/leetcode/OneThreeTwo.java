package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

/**
 * @author: John
 * @date: 2020-03-16 16:28
 * @description: 132
 **/
public class OneThreeTwo {

//    int count;
//
//    public int minCut(String s) {
//        if (s.length() == 1) {
//            return 0;
//        }
//        backtrack(new ArrayList<>(), s, 0, true);
//        return count;
//    }
//
//    private void backtrack(List<String> temp, String s, int start, boolean last) {
//        if ((temp.size() == s.length()) || (start == s.length() - 1)) {
//            count++;
//        } else {
//            for (int i = start; i < s.length(); i++) {
//                if (isPalindrome(s, start, i)) {
//
//                    backtrack(temp, s, i + 1, true);
//                } else if (last && !isPalindrome(s, start, i)) {
//                    temp.add(s.substring(start, i + 1));
//                    backtrack(temp, s, i + 1, false);
//                    temp.remove(temp.size() - 1);
//                }
//            }
//        }
//    }
//
//    private boolean isPalindrome(String s, int low, int high) {
//        while (low < high) {
//            if (s.charAt(low++) != s.charAt(high--)) {
//                return false;
//            }
//        }
//        return true;
//    }


//    public int minCut(String s) {
//        int len = s.length();
//        if (len < 2) {
//            return 0;
//        }
//        int[] dp = new int[len];
//        for (int i = 0; i < len; i++) {
//            dp[i] = i;
//        }
//
//        for (int i = 1; i < len; i++) {
//            if (checkPalindrome(s, 0, i)) {
//                dp[i] = 0;
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                if (checkPalindrome(s, j + 1, i)) {
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[len - 1];
//    }
//
//    private boolean checkPalindrome(String s, int left, int right) {
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }


//    public int minCut(String s) {
//       int n = s.length();
//       int[] dp = IntStream.range(0, n).toArray();
//       for (int mid = 1; mid < n; mid++) {  // iterate through all chars as mid point of palindrome
//           // case 1. odd len: center is at index mid, expand on both sides
//           for (int start = mid, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
//                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
//                dp[end] = Math.min(dp[end], newCutAtEnd);
//           }
//           // case 2: even len: center is between [mid - 1, mid], expand on both sides
//           for (int start = mid - 1, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
//               int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
//               dp[end] = Math.min(dp[end], newCutAtEnd);
//           }
//       }
//       return dp[n - 1];
//    }


    //    public int minCut(String s) {
//        int l = s.length();
//        boolean[][] dp = new boolean[l][l];
//        for (int left = 1; left < l; left++) {
//            for (int right = 0; left <= right; right++) {
//                if (s.charAt(left) == s.charAt(right) && ((right - left) <= 2 || dp[left++][right--])) {
//                    dp[left][right] = true;
//                }
//            }
//        }
//        backtrack(s, 0, cuts, dp);
//        return cuts;
//    }

    public int minCut(String s) {

        // validate input
        if (s == null  || s.length() <= 1) {
          return 0;
       }
        // dp
        int n = s.length();
        int[] dp = IntStream.range(0, n).toArray(); // initial value: dp[i] = i

        for (int mid = 1; mid < n; mid++) { // iterate through all chars as mid point of Palindrome
            //case 1. odd len: center is at index mid, expand on both sides
            for (int start = mid, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
            // case 2. even len: cneter is between [mid -1， mid], expand on both sides
            for (int start = mid - 1, end = mid; start >= 0 && end < n && s.charAt(start) == s.charAt(end); start--, end++) {
                int newCutAtEnd = (start == 0) ? 0 : dp[start - 1] + 1;
                dp[end] = Math.min(dp[end], newCutAtEnd);
            }
        }
        return dp[n - 1];
    }



    public static void main(String[] args) {
        OneThreeTwo oneThreeTwo = new OneThreeTwo();
//        System.out.println(oneThreeTwo.minCut("bb"));
        System.out.println(oneThreeTwo.minCut("abbad"));
//        System.out.println(oneThreeTwo.minCut("cdd"));
    }
}

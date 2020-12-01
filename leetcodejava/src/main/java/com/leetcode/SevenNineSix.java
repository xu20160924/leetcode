package com.leetcode;

import java.util.HashMap;

/**
 * @author: John
 * @date: 2020-01-24 10:24
 * @description: 796
 **/
public class SevenNineSix {
//    public static boolean rotateString(String A, String B) {
//        if (A.equals(B)) {
//            return true;
//        }
//        int MOD = 1_000_000_007;
//        int P = 113;
//        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();
//        long hb = 0, power = 1;
//        for (char x : B.toCharArray()) {
//            hb = (hb + power * x) % MOD;
//            power = power * P % MOD;
//        }
//        long ha = 0; power = 1;
//        char[] ca = A.toCharArray();
//        for (char x : ca) {
//           ha = (ha + power * x) % MOD;
//           power = power * P % MOD;
//        }
//
//        for (int i = 0; i < ca.length; ++i) {
//            char x = ca[i];
//            ha += power * x - x;
//            ha %= MOD;
//            ha *= Pinv;
//            ha %= MOD;
//            if (ha == hb && (A.substring(i + 1) + A.substring(0, i + 1)).equals(B)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * KMP
     *
     * @param A
     * @param B
     * @return
     */
//    public static boolean rotateString(String A, String B) {
//        int N = A.length();
//        if (N != B.length()) {
//            return false;
//        }
//        if (N == 0) {
//            return true;
//        }
//        int[] shifts = new int[N + 1];
//        Arrays.fill(shifts, 1);
//        int left = -1;
//        for (int right = 0; right < N; ++right) {
//            while (left >= 0 && (B.charAt(left) != B.charAt(right))) {
//                left -= shifts[left];
//            }
//            shifts[right + 1] = right - left++;
//        }
//
//        int matchLen = 0;
//        for (char c: (A+A).toCharArray()) {
//            while (matchLen >= 0 && B.charAt(matchLen) != c) {
//               matchLen -= shifts[matchLen];
//            }
//            if (++matchLen == N) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 方案未通过 因为包含重复的问题
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        char[] ac = A.toCharArray();
        char[] bc = B.toCharArray();

        for (int i = 0; i < A.length(); i++) {
            if (ac.length - 1 == i) {
                map.put(ac[i], ac[0]);
            } else {
                map.put(ac[i], ac[i + 1]);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            char tmp = map.getOrDefault(bc[i], '1');
            if (i + 1 == bc.length) {
               if (tmp != bc[0]) {
                   return false;
               } else {
                   return true;
               }
            }
            if (tmp != bc[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String A = "abcde";
//        String B = "cdeab";
//        System.out.println(SevenNineSix.rotateString(A, B));
        SevenNineSix sevenNineSix = new SevenNineSix();
//        System.out.println(sevenNineSix.rotateString(A, B));
        System.out.println(sevenNineSix.rotateString("clrwmpkwru", "wmpkwruclr"));
    }
}

package com.john;

import com.sun.corba.se.impl.ior.iiop.MaxStreamFormatVersionComponentImpl;

/**
 * @author: John
 * @date: 2020-01-25 12:13
 * @description: kmp
 **/
public class KMP {

    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X初始为 0
        int X = 0;
        // 构建装啊提转移图
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
               if (pat.charAt(j) == c) {
                  dp[j][c] = j + 1;
               } else {
                   dp[j][c] = dp[X][c];
               }
               // 更新影子状态
               X = dp[X][pat.charAt(j)];
            }
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为0
        int j = 0;
        for (int i = 0; i < N; i++) {
            //计算pat的下一个装啊提
            j = dp[j][txt.charAt(i)];
            //到达终止态， 返回结果
            if (j == M) {
                return i - M + 1;
            }
        }
        // 没有到达终止态 匹配失败
        return -1;
    }

    //    public int search(String txt, String pat) {
//        int M = pat.length();
//        int N = txt.length();
//
//        int j = 0;
//        for (int i = 0; i < N; i++) {
//            j = dp[j][txt.charAt(i)];
//            if (j == M) {
//               return i - M + 1;
//            }
//        }
//        return -1;
//    }
}

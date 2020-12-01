package com.leetcode.crackcodeinterview;

/**
 * @author: John
 * @date: 2020-03-25 21:58
 * @description: 0503
 **/
public class ZeroFiveZeroThree {

//    public int reverseBits(int num) {
//        int max = 0;
//        int cnt = 0, cntPre = 0;
//        while (num) {
//
//        }
//    }

    public int reverseBits(int num) {
        int maxLen = 0, preLen = 0, curLen = 0, bits = 32;
        while (bits-- > 0) {
            if ((num & 1) == 0) {
                curLen -= preLen;
                preLen = curLen + 1;
            }
            curLen++;
            maxLen = Math.max(maxLen, curLen);
            num >>= 1;
        }
        return maxLen;
    }
}

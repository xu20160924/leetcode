package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-18 14:00
 * @description: 15
 **/
public class OneFive {

    /**
     * n &= n - 1
     * @return
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

//    public int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//           res += n & 1;
//           n >>>= 1;
//        }
//        return res;
//    }


}

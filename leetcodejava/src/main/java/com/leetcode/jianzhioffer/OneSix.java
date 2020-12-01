package com.leetcode.jianzhioffer;

/**
 * @author: John
 * @date: 2020-05-18 15:00
 * @description: 16
 **/
public class OneSix {

    /**
     *  cannot pass
     * @param x
     * @param n
     * @return
     */
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        if (n < 0) {
//            n = -n;
//            x = 1/x;
//        }
//        return (n % 2 == 0) ? myPow(x*x, n / 2) : x * myPow(x * x, n / 2);
//    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

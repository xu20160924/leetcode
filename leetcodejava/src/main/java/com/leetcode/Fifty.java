package com.leetcode;

/**
 * @author: John
 * @date: 2020-01-31 21:24
 * @description: 50
 **/
public class Fifty {
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return  0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

//    public static double myPow(double x, long n) {
//        long N = n;
//        if (x < 0) {
//           x = 1 / x;
//           N = - N;
//        }
//        return fastPow(x, N);
//    }
    public static double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0 ; i /= 2) {
           if ((i % 2) == 1) {
               ans = ans * current_product;
           }
           current_product = current_product * current_product;
        }
        return ans;
    }
}

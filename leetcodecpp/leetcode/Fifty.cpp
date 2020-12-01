//
// Created by John on 2020/1/31.
//

#include <cstdio>
#include "Fifty.h"

using namespace std;

class Solution{
//public:
//    static double fastPow(double x, long long n) {
//        if (n == 0) {
//            return 1.0;
//        }
//        double half = fastPow(x, n / 2);
//        if (n % 2 == 0) {
//            return half * half;
//        } else {
//            return half * half * x;
//        }
//    }
//
//public:
//    static double myPow(double x, int n) {
//        long long N = n;
//        if (N < 0) {
//            x = 1 / x;
//            N = - N;
//        }
//        return fastPow(x, N);
//    }
//
//};

//public:
//    static double myPow(double x, int n) {
//        long long N = n;
//        if (n < 0) {
//            x = 1 / x;
//            N = -N;
//        }
//        double ans = 1;
//        double current_product = x;
//        for (long long i = N; i; i /= 2) {
//            if ((i % 2) == 1) {
//                ans = ans * current_product;
//            }
//            current_product = current_product * current_product;
//        }
//        return ans;
//    }
public:
    static double myPow(double x, int n) {
        if (n == 0) {return 1;}
        if (n == 1) {return x;}
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
};

//
//int main() {
//    printf("%f", Solution::myPow(2, -10));
//}
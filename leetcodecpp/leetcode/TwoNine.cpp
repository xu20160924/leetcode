//
// Created by John on 2020/2/27.
//

#include <climits>
#include <cstdlib>
#include "iostream"

using namespace std;

class Solution{
//public:
//    int divide(int dividend, int divisor) {
//        if(dividend == INT_MIN && divisor == -1) {
//            return INT_MAX;
//        }
//        long dvd = labs(dividend), dvs = labs(divisor), ans = 0;
//        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
//        while(dvd >= dvs) {
//            long temp = dvs, m = 1;
//            while(temp << 1 <= dvd) {
//                temp <<= 1;
//                m <<= 1;
//            }
//            dvd -= temp;
//            ans += m;
//        }
//        return sign * ans;
//    }
//
//public:
//    int divide(int dividend, int divisor) {
//        if(dividend == 0) {
//            return 0;
//        }
//        if(divisor == 1) {
//            return dividend;
//        }
//        if(divisor == -1) {
//            if(dividend > INT_MIN) {
//               return -dividend;
//            }
//            return INT_MAX;
//        }
//        long a = dividend;
//        long b = divisor;
//        int sign = 1;
//        if((a>0&&b<0) || (a<0&&b>0)) {
//            sign = -1;
//        }
//        a = a > 0 ? a : -a;
//        b = b > 0 ? b : -b;
//        long res = div(a, b);
//        if(sign > 0) {
//            return res > INT_MAX ? INT_MAX : res;
//        }
//        return -res;
//    }
//    int div(long a, long b) {
//        if(a<b) {
//            return 0;
//        }
//        long count = 1;
//        long tb = b;
//        while((tb+tb) <= a) {
//            count = count + count;
//            tb = tb + tb;
//        }
//        return count + div(a- tb, b);
//    }

//public:
//    int divide(int dividend, int divisor) {
//        if(dividend == INT_MIN && divisor == -1) {
//            return INT_MAX;
//        }
//        long dvd = labs(dividend), dvs = labs(divisor), ans = 0;
//        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;
//        while(dvd >= dvs) {
//            long temp = dvs, m = 1;
//            while(temp << 1 <= dvd) {
//                temp <<= 1;
//                m <<= 1;
//            }
//            dvd -= temp;
//            ans += m;
//        }
//        return sign * ans;
//    }

public:
    int divide(int A, int B) {
        if(A == INT_MIN && B == -1) {
            return INT_MAX;
        }
        int a = abs(A), b = abs(B), res = 0;
        for(int x = 31; x >= 0; x--) {
            if((signed)((unsigned)a >> x) - b >= 0) {
                res += 1 << x, a -= b << x;
            }
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
};

//int main() {
//    Solution * solution = new Solution();
//    solution->divide(2147483647, 2);
////    cout<< INT_MAX<<endl;
//}
//
// Created by John on 2020/3/1.
//

#include <iostream>
#include <unordered_map>
#include "string"
using namespace std;

class Solution {
//public:
//    string fractionToDecimal(int numerator, int denominator) {
//        string res = to_string((double) numerator / (double) denominator);
//        if (res[2]=='0') {
//            res = res.substr(0, 1);
//        } else {
//            res = res.substr(0, 3);
//
//        }
////        if (((double) numerator / (double) denominator) > 0 && (denominator % numerator) == 0 ) {
////            return res;
////        }
//        if (((double) numerator / (double) denominator) > 0 && (denominator % numerator) > 0) {
//            res.insert(2, "(");
//            res.insert(4, ")");
//        }
//        return res;
//    }

public:
    string fractionToDecimal(int64_t n, int64_t d) {
        if (n == 0) {
            return "0";
        }
        string res;
        if (n < 0 ^ d < 0) {
            res += '-';
        }
        n = abs(n), d = abs(d);

        res += to_string(n / d);
        if (n % d == 0) {
            return res;
        }
        res += '.';

        unordered_map<int, int> map;
        for (int64_t r = n % d; r; r %= d) {
            if (map.count(r) > 0) {
                res.insert(map[r], 1, '(');
                res += ')';
                break;
            }
            map[r] = res.size();
            r *= 10;
            res += to_string(r / d);
        }
        return res;
    }
};

//int main() {
//    Solution * solution = new Solution();
////    cout << 1 % 2 << endl;
//    cout << solution->fractionToDecimal(2, 3) << endl;
//}
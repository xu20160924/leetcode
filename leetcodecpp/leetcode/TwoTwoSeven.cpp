//
// Created by John on 2020/2/23.
//

#include "TwoTwoSeven.h"
#include <string>
#include <sstream>

using namespace std;
class Solution{
public:
    int calculate(string s) {
        istringstream in('+' + s + '+');
        long long total = 0, term = 0, n;
        char op;
        while (in >> op) {
            if (op == '+' or op == '-') {
                total += term;
                in >> term;
                term *= 44 -op;
            } else {
                in >> n;
                if (op == '*') {
                    term *= n;
                } else {
                    term /= n;
                }
            }
        }
        return total;
    }
};

//int main() {
//    string s = "3+2-1+4*2/2*3/2";
//    Solution * solution = new Solution();
//    solution->calculate(s);
//}
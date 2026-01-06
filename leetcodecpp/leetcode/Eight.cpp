//
// Created by caidaoliuhai on 2025/12/17.
//
#include "string"
#include "iostream"
#include <cstdint>

using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        int n = s.length();
        int res = 0;
        int sign = 1;
        int i = 0;
        while (s[i] == ' ') {
            i++;
        };
        while (!isdigit(s[i])) {
            char c = s[i];
            if (c == '-' || c == '+') {
                sign = c == '-' ? -1 : 1;
            }
            i++;
        }

        while (i < n && isdigit(s[i])) {
            char c = s[i];
            int num = c - '0';
            if (res > (INT_MAX - num) / 10) {
                // res = sign == 1 ? INT_MAX : INT_MIN;
                return sign == 1? INT_MAX : INT_MIN;
            }
            res = (res * 10) + num;
            i++;
        }
        return res * sign;
    }
};

int main() {
    Solution *solution = new Solution();
    //    -042
//    cout << "res" << solution->myAtoi("   -042") << endl;
    cout << "res" << solution->myAtoi("words and 987") << endl;
//    cout << "res" << solution->myAtoi("42") << endl;
}
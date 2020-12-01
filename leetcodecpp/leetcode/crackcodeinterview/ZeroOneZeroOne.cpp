//
// Created by John on 2020/9/14.
//
#include <iostream>
#include "string"

using namespace std;

class Solution {
public:
    bool isUnique(string astr) {
        for (int i = 0; i < astr.size(); i++) {
            if (astr.find(astr[i]) != astr.rfind(astr[i])) {
//                printf(astr.find(astr[i]), "%s");
//                printf(astr.find(astr[i]), "%s");
                cout << astr.find(astr[i])  << "\n";
                cout << astr.rfind(astr[i]) << "\n";
                return false;
            }
        }
        return true;
    }
};
//int main() {
//    Solution * solution = new Solution();
//    solution->isUnique("leetcode");
//}


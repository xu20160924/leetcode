//
// Created by caidaoliuhai on 2022/11/15.
//
#include "vector"
#include "../algorithm/LeetCodeInterview.h"


class Solution {
public:
//    void reverseString(vector<char>& s) {
//        int l = 0;
//        int r = s.size() - 1;
//        while (l < r) {
//            swap(s[l++], s[r--]);
//        }
//    }
    void reverseString(vector<char>& s) {
        int l = 0;
        int r = s.size() - 1;
        while (l < r) {
            s[l] = s[l] ^ s[r];
            s[r] = s[l] ^ s[r];
            s[l] = s[l] ^ s[r];
            l++;
            r--;
        }
    }
};

int main() {
    Solution* solution = new Solution();
    vector<char> s = {'h', 'e', 'l', 'l', 'o'};
    solution->reverseString(s);
}
//
// Created by John on 2020/3/18.
//
#include "vector"
using namespace std;

class Solution {
public:
    int singleNumber(vector<int> & nums) {
        int a = 0, b = 0;
        for (auto x : nums) {
            b = (b ^ x) & ~a;
            a = (a ^ x) & ~b;
        }
        return b;
    }
};

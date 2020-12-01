//
// Created by John on 2020/3/2.
//
#include "vector"
using namespace std;

class Solution{
public:
    int rob(vector<int> & nums) {
        int ch1 = 0, ch2 = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i % 2 == 0) {
                ch2 += nums[i];
            } else {
                ch1 += nums[i];
            }
        }
        return ch1 > ch2 ? ch1 : ch2;
    }
};

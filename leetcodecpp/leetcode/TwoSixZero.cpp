//
// Created by John on 2020/2/3.
//

#include "TwoSixZero.h"
#include <vector>
#include <numeric>
#include <iostream>

using namespace std;

class Solution{
public:
    static vector<int> singleNumber(vector<int> &nums) {
        // pass 1
        // get the xor of the two numbers we need to find
        int diff = accumulate(nums.begin(), nums.end(), 0, bit_xor<int>());
        // get its last set bit
        diff &= -diff;

        // pass2
        vector<int> rets(2);  // store the two numbers will return
        for (int num : nums) {
            if ((num & diff) == 0) { // the bit is not set
                rets[0] ^= num;
            } else { // the bit is set
                rets[1] ^= num;
            }
        }
        return rets;
    }
    static void print(std::vector<int> const &input)
    {
        for (int i = 0; i < input.size(); i++) {
            cout << input.at(i) << ' ';
        }
    }
};



//int main() {
//    vector<int> input;
//    input.push_back(1);
//    input.push_back(2);
//    input.push_back(1);
//    input.push_back(3);
//    input.push_back(2);
//    input.push_back(5);
//
//    vector<int> result = Solution::singleNumber(input);
//    Solution::print(result);
//}
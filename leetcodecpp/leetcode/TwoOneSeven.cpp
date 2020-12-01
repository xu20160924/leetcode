//
// Created by John on 2020/2/24.
//

#include "TwoOneSeven.h"
#include <vector>

using namespace std;

class Solution{
public:
    bool containsDuplicate(vector<int> & nums) {
        if (nums.size() < 2) {
            return false;
        }
        int bit = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (bit == (bit ^ nums[i])) {
                return true;
            }
            bit ^= nums[i];
        }
        return false;
    }
};

//int main() {
//    vector<int> nums;
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(3);
//    nums.push_back(1);
//    Solution * solution = new Solution();
//    solution->containsDuplicate(nums);
////    printf("%d", 1^2);
//}
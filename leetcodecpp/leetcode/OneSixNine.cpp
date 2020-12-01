//
// Created by John on 2020/3/8.
//
#include <iostream>
#include "vector"
#include "unordered_map"

using namespace std;

class Solution {
public:
    int majorityElement(vector<int> & nums) {
        int target = nums.size() / 2;
        unordered_map<int, int> map(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            if (map[nums[i]] >= target) {
                return nums[i];
            }
            map[nums[i]]++;
        }
    }
};
//int main() {
//    vector<int> nums;
//    nums.push_back(3);
//    nums.push_back(2);
//    nums.push_back(3);
//    Solution * solution = new Solution();
//    cout << solution->majorityElement(nums) << endl;
//}
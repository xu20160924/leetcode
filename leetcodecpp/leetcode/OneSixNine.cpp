//
// Created by John on 2020/3/8.
//
#include <iostream>
#include "vector"
#include "unordered_map"

using namespace std;

class Solution {
public:
    // int majorityElement(vector<int> & nums) {
    //     int target = nums.size() / 2;
    //     unordered_map<int, int> map(nums.size());
    //     for (int i = 0; i < nums.size(); i++) {
    //         if (map[nums[i]] >= target) {
    //             return nums[i];
    //         }
    //         map[nums[i]]++;
    //     }
    // }

    // int majorityElement(vector<int>& nums) {
    //     int target = nums.size() / 2;
    //     unordered_map<int, int> map(nums.size());
    //     for (int i = 0; i < nums.size(); i++) {
    //         if (map[nums[i]] >= target) {
    //             return nums[i];
    //         }
    //         map[nums[i]]++;
    //     }
    //     return 0;
    // }

    int majorityElement(vector<int>& nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

};


int main() {
    vector<int> nums = {2,2,1,1,1,2,2};
    Solution * solution = new Solution();
    cout << solution->majorityElement(nums) << endl;
}
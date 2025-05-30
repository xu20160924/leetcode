#include <iostream>
#include <vector>
//
// Created by John on 2025/3/27.
//
using namespace std;

class Solution {
    // public:
    //     static int findClosestNumber(vector<int>& nums) {
    //         if (nums.size() == 1) {
    //             return nums[0];
    //         }
    //         int left = 0, right = nums.size() - 1;
    //         int mid = left + (right - left) / 2;
    //         while (left < right) {
    //             if (nums[mid] <= 0 || nums[mid] * nums[mid + 1] < 0) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid;
    //             }
    //             mid = left + (right - left) / 2;
    //
    //             if (nums[mid] == 0) {
    //                 return nums[mid];
    //             }
    //         }
    //         return nums[mid];
    //     }

public:
    static int findClosestNumber(vector<int>& nums) {
        int ans = INT_MAX;
        for (int i : nums) {
            if (abs(i) < ans) {
                ans = i;
            } else if (abs(i) == abs(ans)) {
                ans = max(ans, i);
            }
        }
        return ans;
    }


int main(int argc, char *argv[]) {
    vector<int> nums = {-1,1,0,0};
    std::cout << Solution().findClosestNumber(nums) << endl;
};


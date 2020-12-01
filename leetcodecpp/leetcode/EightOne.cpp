//
// Created by John on 2020/2/6.
//

#include "EightOne.h"
#include <vector>

using namespace std;
class Solution{
public:
    static bool search(vector<int>& nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[mid]) {
                if ((target <= nums[mid]) && (target >= nums[left])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
//public:
//    static bool search(vector<int> & nums, int target) {
//        int left = 0, right = nums.size() - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                return true;
//            }
//
//            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
//                ++left;
//                --right;
//            } else if(nums[left] <= nums[mid]) {
//                if ((nums[left] <= target) && (nums[mid] > target)) {
//                    right = mid - 1;
//                } else {
//                    left = mid + 1;
//                }
//            } else {
//                if ((nums[mid] < target && nums[right] >= target)) {
//                    left = mid + 1;
//                } else {
//                    right = mid -1;
//                }
//            }
//        }
//        return false;
//    }
//

};

//int main() {
//    vector<int> nums;
////    nums.push_back(2);
////    nums.push_back(5);
////    nums.push_back(6);
////    nums.push_back(0);
////    nums.push_back(0);
//    nums.push_back(3);
//    nums.push_back(1);
//    printf("%d", Solution::search(nums, 1));
//
//};
//
// Created by John on 2020/3/19.
//
#include "vector"
using namespace std;

class Solution{
public:
    // wrong answer
//    vector<int> searchRange(vector<int> & nums, int target) {
//        vector<int> res(2, -1);
//        int start = 0, end = nums.size();
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                res[0] = mid;
//                if (nums[mid - 1] == target) {
//                    res[1] = mid -1;
//                } else if (nums[mid + 1] == target) {
//                    res[1] = mid + 1;
//                } else {
//                    res[1] = mid;
//                }
//                break;
//            } else if (nums[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//        return res;
//    }
    vector<int> searchRange(vector<int> nums, int target) {
        int i = 0, j = nums.size() - 1;
        // search for the left one
        vector<int> res(2, -1);
        if (nums.size() < 1) {
            return res;
        }
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (nums[i] != target) {
            return res;
        } else {
            res[0] = i;
        }

        // search for the right one
        j = nums.size() - 1; // We dont have to set i to 0 the second time.
        while (i < j) {
            // Make mid biased to the right
            int mid = (i + j) / 2 + 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                // So that this wont't make the search range stuck.
                i = mid;
            }
        }
        res[1] = j;
        return res;
    }
};

//int main() {
//    vector<int> nums;
////    nums.push_back(5);
////    nums.push_back(7);
////    nums.push_back(7);
////    nums.push_back(8);
////    nums.push_back(8);
//    nums.push_back(1);
//    Solution * solution = new Solution();
//    solution->searchRange(nums, 1);
//}

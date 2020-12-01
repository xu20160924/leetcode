//
// Created by John on 2020/5/4.
//
#include "vector"

using namespace std;

class Solution {
public:
//    int findRepeatNumber(vector<int> &nums) {
//        if (nums.empty()) {
//            return -1;
//        }
//        int start = 0;
//        int end = nums.size() - 1;
//
//        while (end >= start) {
//            int mid = ((end - start) >> 1) + start;
//            int count = countRange(nums, start, mid);
//            if (end == start) {
//                if (count > 1) {
//                    return start;
//                } else {
//                    break;
//                }
//            }
//            if (count > (mid - start + 1)) {
//                end = mid;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    int countRange(vector<int> &nums, int start, int end) {
//        if (nums.empty()) {
//            return -1;
//        }
//        int count = 0;
//        for (int n : nums) {
//            if (n >= start && n <= end) {
//                ++count;
//            }
//        }
//        return count;
//    }

    int getDuplication(const int * numbers, int length) {
        if (numbers == nullptr || length <= 0) {

        }
    }

};
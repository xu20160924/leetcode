//
// Created by John on 2020/2/29.
//
#include "vector"

using namespace std;

class Solution{

public:
    // brute solution linear scan
//    int findPeakElement(vector<int>& nums) {
//        for (int i = 0; i < nums.size() - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return nums.size() - 1;
//    }

    // recursion binary search
//    int findPeakElement(vector<int> & nums) {
//        return search(nums, 0, nums.size() - 1);
//    }
//    int search(vector<int> & nums, int l, int r) {
//        if (l == r) {
//            return l;
//        }
//        int mid = l + (r - l) / 2;
//        if (nums[mid] > nums[mid + 1]) {
//            return search(nums, l, mid);
//        }
//        return search(nums, mid + 1, r);
//    }

    // iterative binary search
    int findPeakElement(vector<int> & nums) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

};

//int main() {
//    vector<int> nums;
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(1);
//    nums.push_back(3);
//    nums.push_back(5);
//    nums.push_back(6);
//    nums.push_back(4);
//    Solution * solution = new Solution();
//    solution->findPeakElement(nums);
//}
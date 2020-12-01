//
// Created by John on 2020/2/6.
//

#include "ThreeThree.h"
#include <vector>
#include <cmath>

using namespace std;

class Solution{
//public:
//    static int search(int A[], int n, int target) {
//        int lo = 0, hi = n -1;
//        while(lo < hi) {
//            int mid = (lo + hi) /2;
//            if (A[mid] > A[hi]) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//            int rot = lo;
//            lo = 0; hi = n -1;
//            while (lo <= hi) {
//                int mid = (lo + hi) / 2;
//                int realmid = (mid + rot) % n;
//                if (A[realmid]==target) {
//                    return realmid;
//                }
//                if (A[realmid]<target) {
//                    lo = mid + 1;
//                } else {
//                    hi = mid - 1;
//                }
//            }
//            return -1;
//        }
//    }


//public:
//    static int search(vector<int> & nums, int target) {
//        int lo = 0, hi = nums.size() - 1;
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
//            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
//                lo = mid + 1;
//            } else {
//                hi = mid;
//            }
//        }
//        return lo == hi && nums[lo] == target ? lo : -1;
//    }

//public:
//    static int search(vector<int> & nums, int target) {
//        if (nums.empty()) {
//        }
//        int lo = 0, hi = nums.size();
//        while (lo < hi) {
//            int mid = (lo + hi) / 2;
////            double num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid] : target < nums[0] ? -INFINITY : INFINITY;
//            double num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid] : target < nums[0] ? -INFINITY : INFINITY;
//            if (num < target) {
//                lo = mid + 1;
//            } else if (num > target) {
//                hi = mid;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
//    }
public:
    int search(vector<int> & nums, int target) {
        int n = nums.size();
        int lo = 0, hi = nums.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // find the index of the smallest value using binary search.
            // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
            // proof by contradiction that mid < hi: if mid == hi, then lo == hi and loop would have been terminated.
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            // find maximum
//            while (lo < hi) {
//                int mid = round(((float) lo + hi) / 2);
//                if (nums[mid] < nums[lo]) {
//                    hi = mid - 1;
//                } else {
//                    lo = mid;
//                }
//            }


            //  lo == hi is the index of the smallest value and also the number of places rotated.
            int rot = lo;
            lo = 0, hi = nums.size() - 1;
            // The usual binary search and accounting for rotation
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                int realmid = (mid + rot) % n;
                if (nums[realmid] == target) {
                    return realmid;
                }
                if (nums[realmid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return -1;
        }
    }
};

//int main() {
//    vector<int> nums;
//    nums.push_back(4);
//    nums.push_back(5);
//    nums.push_back(6);
//    nums.push_back(7);
//    nums.push_back(0);
//    nums.push_back(1);
//    nums.push_back(2);
//    Solution * solution = new Solution();
//    solution->search(nums, 0);
//}

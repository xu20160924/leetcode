//
// Created by John on 2020/3/12.
//
#include "../algorithm/LeetCodeInterview.h"
#include "vector"

using namespace std;

class Solution{
public:
//    static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
//        int N1 = nums1.size();
//        int N2 = nums2.size();
//        if (N1 < N2) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int lo = 0, hi = N2 * 2;
//        while (lo <= hi) {
//            int mid2 = (lo + hi) / 2;
//            int mid1 = N1 + N2 - mid2;
//
//            double L1 = (mid1 == 0) ? INT_MIN : nums1[(mid1 - 1) / 2];
//            double L2 = (mid2 == 0) ? INT_MIN : nums2[(mid2 - 1) / 2];
//            double R1 = (mid1 == N1 * 2) ? INT_MAX : nums1[(mid1) / 2];
//            double R2 = (mid2 == N2 * 2) ? INT_MAX : nums2[(mid2) / 2];
//
//            if (L1 > R2) {
//                lo = mid2 + 1;
//            } else if (L2 > R1) {
//                hi = mid2 - 1;
//            } else {
//                return (max(L1, L2) + min(R1, R2)) / 2;
//            }
//        }
//        return -1;
//    }
    static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.size();
        int y = nums2.size();

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? INT_MAX: nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ?  INT_MAX : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double) max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2;
                } else {
                    return max(maxLeftY, maxLeftX);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return -1;
    }
};

//int main() {
//    vector<int> nums1{1,3};
//    vector<int> nums2{2};
//    double result = Solution::findMedianSortedArrays(nums1, nums2);
//}
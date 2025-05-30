//
// Created by John on 2020/3/12.
//
#include "../algorithm/LeetCodeInterview.h"
#include "vector"

using namespace std;

class Solution {
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
    //    static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    //        if (nums1.size() > nums2.size()) {
    //            return findMedianSortedArrays(nums2, nums1);
    //        }
    //        int x = nums1.size();
    //        int y = nums2.size();
    //
    //        int low = 0;
    //        int high = x;
    //        while (low <= high) {
    //            int partitionX = (low + high) / 2;
    //            int partitionY = (x + y + 1) / 2 - partitionX;
    //
    //            int maxLeftX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
    //            int minRightX = (partitionX == x) ? INT_MAX: nums1[partitionX];
    //
    //            int maxLeftY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
    //            int minRightY = (partitionY == y) ?  INT_MAX : nums2[partitionY];
    //
    //            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
    //                if ((x + y) % 2 == 0) {
    //                    return ((double) max(maxLeftX, maxLeftY) + min(minRightX, minRightY)) / 2;
    //                } else {
    //                    return max(maxLeftY, maxLeftX);
    //                }
    //            } else if (maxLeftX > minRightY) {
    //                high = partitionX - 1;
    //            } else {
    //                low = partitionX + 1;
    //            }
    //        }
    //        return -1;
    //    }
    // static double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
    //     priority_queue<int> pq;
    //     int i = 0, j = 0;
    //     int num1Size = nums1.size();
    //     int num2Size = nums2.size();
    //     int middleSize = (num1Size + num2Size) / 2 + 1;
    //     while (pq.size() < middleSize) {
    //         if (i >= num1Size) {
    //             pq.push(nums2[j++]);
    //         } else if (j >= num2Size) {
    //             pq.push(nums1[i++]);
    //         } else if (nums1[i] < nums2[j]) {
    //             pq.push(nums1[i++]);
    //         } else {
    //             pq.push(nums2[j++]);
    //         }
    //     }
    //
    //     if ((num1Size + num2Size) % 2 == 0) {
    //         int left = pq.top();
    //         pq.pop();
    //         int right = pq.top();
    //         return (left + right) / 2.0;
    //     } else {
    //         return pq.top();
    //     }
    // }

// 错误的， 有些case过不去
    // static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    //     int m = nums1.size(), n = nums2.size();
    //
    //     vector<int> temp = nums1;
    //     if (m == 0 || n == 0) {
    //         if (m == 0) {
    //             temp = nums2;
    //         }
    //         if (n == 0) {
    //             temp = nums1;
    //         }
    //         if (temp.size() % 2) {
    //             return temp[temp.size() / 2.0];
    //         } else {
    //             return (temp[temp.size() / 2] + temp[temp.size() / 2 - 1]) / 2.0;
    //         }
    //     }
    //
    //
    //     int totalSize = m + n;
    //     int isOdd = (totalSize) % 2;
    //     int mid = totalSize / 2;
    //     int endNums1 = (m - 1);
    //     int startNums2 = 0;
    //     while ((endNums1 + (n - startNums2 - 1)) != mid) {
    //         if (nums1[endNums1] > nums2[startNums2]) {
    //             endNums1--;
    //         } else {
    //             startNums2++;
    //         }
    //     }
    //     if (isOdd) {
    //         return min(nums1[endNums1], nums2[startNums2]);
    //     } else {
    //         return (nums1[endNums1] + nums2[startNums2]) / 2.0;
    //     }
    // }

    static double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if (nums1.size() > nums2.size()) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.size(), n = nums2.size();
        int total = m + n;
        int half = (total + 1) / 2;
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;

            int nums1Left = (i == 0) ? INT_MIN : nums1[i - 1];
            int nums1Right = (i == m) ? INT_MAX : nums1[i];
            int nums2Left = (j == 0) ? INT_MIN : nums2[j - 1];
            int nums2Right = (j == n) ? INT_MAX : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {
                if (total % 2 == 1) {
                    return max(nums1Left, nums2Left);
                } else {
                    return (max(nums1Left, nums2Left) + max(nums1Right, nums2Right)) / 2.0;
                }
            } else if (nums1Left > nums2Right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }

};

int main() {
    vector<int> nums1{0,0,0,0,0};
    vector<int> nums2{-1,0,0,0,0,0,1};
    double result = Solution::findMedianSortedArrays(nums1, nums2);
    cout << result << endl;
}

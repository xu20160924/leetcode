//
// Created by John on 2020/3/19.
//
#include "vector"

using namespace std;

class Solution{
public:
    int findPeak(vector<int> & A) {
        return search(A, 0, A.size() - 1);
    }
    int search(vector<int> nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }
};
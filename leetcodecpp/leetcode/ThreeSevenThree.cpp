//
// Created by John on 2020/3/4.
//
#include "vector"
using namespace std;

class Solution{
public:
    vector<vector<int> > kSmallestPairs(vector<int> & nums1, vector<int> & nums2, int k) {
        vector<vector<int> > res;
        if (nums1.empty() || nums2.empty()) {
            return res;
        }
        int i = 0, j = 0;
        for (int l = 0; l < nums1.size(); l++) {
            if (res.size() == k) {
                break;
            }
            vector<int> pair;
            pair.push_back(nums1[i]);
            pair.push_back(nums2[j]);
            res.push_back(pair);
            if (nums1[i] > nums2[j] || nums1[l] < nums2[l]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
};

//int main() {
//    vector<int> nums1, nums2;
//    nums1.push_back(1);
//    nums1.push_back(7);
//    nums1.push_back(11);
//
//    nums2.push_back(2);
//    nums2.push_back(4);
//    nums2.push_back(6);
//
//    Solution *solution = new Solution();
//    solution->kSmallestPairs(nums1, nums2, 3);
//}
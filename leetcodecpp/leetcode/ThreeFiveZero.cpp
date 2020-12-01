//
// Created by John on 2020/3/3.
//
#include <unordered_map>
#include "vector"
#include "set"

using namespace std;

class Solution{
public:
//    vector<int> intersect(vector<int> & nums1, vector<int> & nums2) {
//        // there hash lesser nums, reduce memory use
//        if (nums1.size() > nums2.size()) {
//            return intersect(nums2, nums1);
//        }
//        unordered_map<int, int> m;
//        for (auto n : nums1) {
//            ++m[n];
//        }
//        int k = 0;
//        for (auto n : nums2) {
//            auto it = m.find(n);
//            if (it != end(m) && --it->second >= 0) {
//                nums1[k++] = n;
//            }
//        }
//        return vector<int>(nums1.begin(), nums1.begin() + k);
//    }


//    vector<int> intersect(vector<int> & nums1, vector<int> & nums2) {
//        sort(begin(nums1), end(nums1));
//        sort(begin(nums2), end(nums2));
//        int i = 0, j = 0, k = 0;
//        while (i < nums1.size() && j < nums2.size()) {
//            if (nums1[i] < nums2[j]) {
//                ++i;
//            } else if (nums1[i] > nums2[j]) {
//                ++j;
//            } else {
//                nums1[k++] = nums1[i++];
//                ++j;
//            }
//        }
//        return vector<int>(begin(nums1), begin(nums1) + k);
//    }

//    vector<int> intersect(vector<int> & nums1, vector<int> & nums2) {
//        sort(begin(nums1), end(nums1));
//        sort(begin(nums2), end(nums2));
//        nums1.erase(__set_intersection(begin(nums1), end(nums1), begin(nums2), end(nums2),
//                begin(nums1), end(nums1)));
//        return nums1;
//    }
};

//
// Created by John on 2020/3/16.
//
#include <cmath>
#include "vector"

using namespace std;

class Solution{
public:
//    vector<vector<int> > subsets(vector<int> &s) {
//        sort(s.begin(), s.end());
//        int elem_num = s.size();
//        int subset_num = pow(2, elem_num);
//        vector<vector<int> > subset_set (subset_num, vector<int> ());
//        for (int i = 0; i < elem_num; i++) {
//            for (int j = 0; j < subset_num; j++) {
//                if ((j >> i) & 1) {
//                    subset_set[j].push_back(s[i]);
//                }
//            }
//        }
//        return subset_set;
//    }

    vector<vector<int>> subsets(vector<int> & nums) {
        int n = nums.size(), p = 1 << n;
        vector<vector<int>> subs(p);
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < n; j++) {
                if ((i >> j) & 1) {
                    subs[i].push_back(nums[j]);
                }
            }
        }
        return subs;
    }
};

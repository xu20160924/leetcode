//
// Created by John on 2020/3/16.
//
#include <cmath>
#include "vector"
#include "iostream"

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

//    vector<vector<int>> subsets(vector<int> & nums) {
//        int n = nums.size(), p = 1 << n;
//        vector<vector<int>> subs(p);
//        for (int i = 0; i < p; i++) {
//            for (int j = 0; j < n; j++) {
//                if ((i >> j) & 1) {
//                    subs[i].push_back(nums[j]);
//                }
//            }
//        }
//        return subs;
//    }

//    vector<vector<int>> subsets(vector<int>& nums) {
//        vector<vector<int>> ans;
//        if (nums.empty()) {
//            return ans;
//        }
//        ans.push_back({});
//
//        for (int num : nums) {
//            vector<vector<int>> tmp;
//            for (auto v : ans) {
//                v.push_back(num);
//                tmp.push_back(v);
//            }
//            for (auto v : tmp) {
//                ans.push_back(v);
//            }
//        }
//        return ans;
//    }

    vector<vector<int>> ans;
    int n, k;

    vector<vector<int>> subsets(vector<int>& nums) {
        n = nums.size();
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, {}, nums);
        }
        return ans;
    }

    void backtrack(int first, vector<int> curr, vector<int> nums) {
        if (curr.size() == k) {
            ans.push_back(vector<int>(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            curr.push_back(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.pop_back();
        }
    }




//    vector<vector<int>> subsets(vector<int>& nums) {
//        vector<vector<int>> ans;
//        int n = nums.size();
//        for (int i = pow(2, n);
//        i < pow(2, n + 1); i++) {
//            string bitmask = bitset<8>(i).to_string();
//            bitmask.erase(0, bitmask.find_first_not_of('0'));
//            bitmask.erase(0,1);
//
//            vector<int> curr;
//            for (int j = 0; j < n; ++j) {
//                if (bitmask[j] == '1') {
//                    curr.push_back(nums[j]);
//                }
//            }
//            ans.push_back(curr);
//        }
//        return ans;
//    }
};

int main() {
    Solution* solution = new Solution();
    vector<int> nums{1,2,3};
//    auto res = solution->subsets(nums);

    vector<vector<int>> ans = solution->subsets(nums);
    for (vector<vector<int>>::iterator it = ans.begin();
        it != ans.end(); it++) {
        for (vector<int>::iterator itt = it->begin(); itt != it->end(); ++itt) {
            cout << *itt << " ";
        }
        cout << "\t";
    }
};

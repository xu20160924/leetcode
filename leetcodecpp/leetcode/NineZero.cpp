//
// Created by John on 2022/6/28.
//
#include "vector"
#include "iostream"

using namespace std;

class Solution {
public:
//    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
//        vector<vector<int>> ans;
//        sort(nums.begin(), nums.end(), less<int>());
//        backtrack(ans, 0, {}, nums);
//        return ans;
//    }
//
//    void backtrack(vector<vector<int>>& ans, int first, vector<int> curr, vector<int> nums) {
//        ans.push_back(vector<int>(curr));
//
//        for (int i = first; i < nums.size(); ++i) {
//            if (i > first && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            curr.push_back(nums[i]);
//            backtrack(ans, i + 1, curr, nums);
//            curr.pop_back();
//        }
//    }
    vector<vector<int>> subsetsWithDup(vector<int> &s) {
        vector<vector<int>> totalset = {{}};
        sort(s.begin(), s.end());
        for (int i = 0; i < s.size();) {
            int count = 0;
            while (count + i < s.size()
                && s[count + i] == s[i]) {
                count++;
            }
            int previous = totalset.size();
            for (int k = 0; k < previous; k++) {
                vector<int> instance = totalset[k];
                for (int j = 0; j < count; j++) {
                    instance.push_back(s[i]);
                    totalset.push_back(instance);
                }
            }
            i += count;
        }
        return totalset;
    }
};

int main() {
    Solution* solution = new Solution();
    vector<int> nums{1,2,2};
//    auto res = solution->subsets(nums);

    vector<vector<int>> ans = solution->subsetsWithDup(nums);
    for (vector<vector<int>>::iterator it = ans.begin();
         it != ans.end(); it++) {
        for (vector<int>::iterator itt = it->begin(); itt != it->end(); ++itt) {
            cout << *itt << " ";
        }
        cout << "\t";
    }
}

#include <iostream>
#include <ostream>
#include <vector>
//
// Created by on 2025/4/19.
//
using namespace std;

class Solution {
private:
    static constexpr int C = 100;

public:
    // vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
    //     int n = nums.size();
    //     vector<array<int, C + 1>> pre(n + 1);
    //     fill(pre[0].begin(), pre[0].end(), 0);
    //     for (int i = 0; i < nums.size(); ++i) {
    //         copy_n(pre[i].begin(), C + 1, pre[i + 1].begin());
    //         ++pre[i + 1][nums[i]];
    //     }
    //
    //     int q = queries.size();
    //     vector<int> ans;
    //     for (int i = 0; i < q; ++i) {
    //         int left = queries[i][0], right = queries[i][1];
    //         int last = 0, best = INT_MAX;
    //         for (int j = 1; j <= C; ++j) {
    //             if (pre[left][j] != pre[right + 1][j]) {
    //                 if (last) {
    //                     best = min(best, j - last);
    //                 }
    //                 last = j;
    //             }
    //         }
    //         if (best == INT_MAX) {
    //             best = - 1;
    //         }
    //         ans.push_back(best);
    //     }
    //     return ans;
    // }


    // vector<int> minDifference(vector<int> &nums, vector<vector<int>> &queries) {
    //     int n = nums.size(), nq = queries.size();
    //     vector<int> ans(nq);
    //     vector<vector<int>> pos(101);
    //     for (int i = 0; i < n; ++i) {
    //         pos[nums[i]].push_back(i);
    //     }
    //
    //     for (int i = 0; i < nq; ++i) {
    //         auto &q = queries[i];
    //         int l = q[0], r = q[1] + 1;
    //         int minDiff = 1e9, pre = -1e9;
    //         for (int v = 1; v <= 100; ++v) {
    //             auto &ps = pos[v];
    //             if (ps.empty()) {
    //                 continue;
    //             }
    //
    //             auto rightLower = lower_bound(ps.begin(), ps.end(), r);
    //             auto leftLower = lower_bound(ps.begin(), ps.end(), l);
    //             int cnt = rightLower - leftLower;
    //             if (cnt == r - l) {
    //                 minDiff = -1;
    //                 break;
    //             }
    //             if (cnt > 0) {
    //                 minDiff = min(minDiff, v - pre);
    //                 pre = v;
    //             }
    //         }
    //         ans[i] = minDiff;
    //     }
    //     return ans;
    // }
    // vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
    //     vector<int> ans(queries.size());
    //     int prefix[100001][101] = {}, cnt[101] = {}, N = nums.size(), M = queries.size();
    //     for (int i = 0; i < N; ++i) {i
    //         cnt[nums[i]]++;
    //         for (int j = 1; j < 101; ++j) {
    //             prefix[i + 1][j] = cnt[j];
    //         }
    //     }
    //     for (int i = 0; i < M; ++i) {
    //         vector<int> query = queries[i];
    //         int left = query[0];
    //         int right = query[1];
    //         cnt[101] = {};
    //         for (int j = 0; j < 101; ++j) {
    //             cnt[j] = prefix[right + 1][j] - prefix[left][j];
    //         }
    //         int pre = -1, minAbs = INT_MAX;
    //         for (int j = 1; j < 101; ++j) {
    //             // without number
    //             if (cnt[j] == 0) {
    //                 continue;
    //             }
    //             if (pre != -1 && j - pre < minAbs) {
    //                 minAbs = j - pre;
    //             }
    //             prev = j;
    //         }
    //         ans[i] = minAbs == INT_MAX ? -1 : minAbs;
    //     }
    //     return ans;
    // }

    // vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {
    //     vector<int> ans;
    //     int prefix[100001][101] = {};
    //     // // build prefix sum
    //     // for (int i = 1; i < nums.size(); i++) {
    //     //     for (int j = 1; j < 101; j++) {
    //     //         prefix[i+1][j] = prefix[i][j] + (nums[i] == j);
    //     //     }
    //     // }
    //     //
    //     // int current = INT_MAX;
    //     // for (int i = 0; i < queries.size(); i++) {
    //     //     int l = queries[i][0];
    //     //     int r = queries[i][1];
    //     //     for (int j = 1; j < 101; j++) {
    //     //         if (prefix[r][j] - prefix[l][j]) {
    //     //             current = min(current, prefix[r][j] - prefix[l][j]);
    //     //         }
    //     //     }
    //     //     if (current == INT_MAX) {
    //     //         ans.push_back(-1);;
    //     //     } else {
    //     //         ans.push_back(current);
    //     //     }
    //     // }
    //     return ans;
    // }

    // int prefix[100001][101];
    // vector<int> minDifference(vector<int>& nums, vector<vector<int>>& queries) {

    //     vector<int> ans;

    //     // build prefix
    //     for (int i = 0; i < nums.size(); i++) {
    //         for (int j = 1; j < 101; j++) {
    //             prefix[i + 1][j] = prefix[i][j] + (nums[i] == j);
    //         }
    //     }


    //     for (int i = 0; i < queries.size(); i++) {
    //         int current = INT_MAX, prev = -1;
    //         int l = queries[i][0];
    //         int r = queries[i][1];
    //         for (int j = 1; j < 101; j++) {
    //             if (prefix[r + 1][j] - prefix[l][j]) {
    //                 current = min(current, prev == -1 ? INT_MAX : j - prev);
    //                 prev = j;
    //             }
    //         }

    //         if (current == INT_MAX) {
    //             ans.push_back(-1);;
    //         } else {
    //             ans.push_back(current);
    //         }
    //     }

    //     return ans;
    // }

};

int main(int argc, char *argv[]) {
    Solution *solution = new Solution();

    // vector<int> nums = { 1, 3, 4, 8};
    // vector<vector<int>> queries = { {0, 1}, {1, 2}, {2, 3}, {0, 3} };

    vector<int> nums = {4,5,2,2,7,10};
    vector<vector<int>> queries = { {2,3}, {0,2}, {0, 5}, {3, 5} };

    vector<int> ans = solution->minDifference(nums, queries);
    for (int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    cout << endl;
}

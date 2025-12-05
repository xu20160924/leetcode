//
// Created by caidaoliuhai on 2025/6/7.
//
#include "vector"
#include "queue"

using namespace std;

class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        vector<vector<int>> res;
        int minimum = INT_MAX;
        int i = 0;
        for (int j = 1; j < arr.size(); j++, i++) {
            int diff = abs(arr[j] - arr[i]);

            if (diff <= minimum) {
                if (diff < minimum) {
                    res.clear();
                }
                minimum = min(diff, minimum);
                vector<int> pair{arr[i], arr[j]};
                res.push_back(pair);
            }

        }
        return res;
    }
};

int main(int argc, char *argv[]) {
    Solution* solution = new Solution();
    vector<int> arr = {3,8,-10,23,19,-4,-14,27};
    solution->minimumAbsDifference(arr);
}

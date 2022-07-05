//
// Created by John on 2022/4/9.
//
#include "vector"
#include "unordered_map"
#include "unordered_map"
#include "iostream"

using namespace std;

class Solution {
public:
//    vector<int> twoSum(vector<int>& nums, int target) {
//        unordered_map<int, int> map;
//        for (int i = 0; i < nums.size(); i++) {
//            map.insert(pair<int, int>(nums[i], i));
//        }
//        for (int i = 0; i < nums.size(); i++) {
//            if (map.find(target - nums[i]) != map.end() && map.at(target - nums[i]) != i) {
//                return vector<int>{i, map.at(target - nums[i])};
//            }
//        }
//        return vector<int>{};
//    }

//    vector<int> twoSum(vector<int>& nums, int target) {
//        unordered_map<int, int> map;
//        for (int i = 0; i < nums.size(); i++) {
//            if (map.find(target - nums[i]) != map.end()) {
//                return {map[target- nums[i]], i};
//            }
//            map[nums[i]] = i;
//        }
//        return {};
//    }

    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        vector<pair<int, int>> arr(n);
        for (int i = 0; i < n; ++i) {
            arr[i] = make_pair(nums[i], i);
        }

        sort(arr.begin(), arr.end());
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = arr[left].first + arr[right].first;
            if (sum == target) {
                return {arr[left].second, arr[right].second};
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return {};
    }

//    vector<int> twoSum(vector<int>& nums, int target) {
//        sort(nums.begin(), nums.end());
//        int i = 0;
//        int j = nums.size() - 1;
//        while (i < j) {
//            int sum = nums[i] + nums[j];
//            if (sum < target) {
//                i++;
//            } else if (sum > target) {
//                j--;
//            } else {
//                return vector<int>{i, j};
//            }
//        }
//        return vector<int>{0, 0};
//    }
};

int main() {

    vector<int> nums{3, 2, 4};
    Solution* solution = new Solution();
    vector<int> res = solution->twoSum(nums, 6);
    cout << "" << endl;
}
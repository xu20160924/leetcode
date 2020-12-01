//
// Created by John on 2020/4/15.
//
#include "vector"

using namespace std;

class Solutin{
public:
//    vector<vector<int>> fourSum(vector<int> & nums, int target) {
//        sort(nums.begin(), nums.end());
//        vector<vector<int>> res;
//        if (nums.size() < 4) {
//            return res;
//        }
//
//        int a, b, c, d, size = nums.size();
//        for (int i = 0; i < size - 4; a++) {
//            if (a > 0 && nums[a] == nums[a - 1]) {
//                continue;  // 确保nums[a] 改变了
//            }
//            for (b = a + 1; b <= size - 3; b++) {
//                if (b > a + 1 && nums[b] == nums[b - 1]) {
//                    continue;  // 确保nums[b]改变了
//                }
//                c + b + 1,  d = size - 1;
//                while (c < d) {
//                    if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
//                        c++;
//                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
//                        d--;
//                    } else {
//                        res.push_back({nums[a], nums[b], nums[c], nums[d]});
//                        while (c < d && nums[c + 1] == nums[c]) { //  确保nums[c] 改变了
//                            c++;
//                        }
//                        while (c < d && nums[d - 1] == nums[d]) { // 确保nums[d] 改变了
//                            d--;
//                        }
//                        c++;
//                        d--;
//                    }
//                }
//            }
//        }
//        return res;
//    }

//    vector<vector<int>> fourSum(vector<int> & nums, int target) {
//        sort(nums.begin(), nums.end());
//        vector<vector<int>> result;
//        int size = nums.size();
//        for (int a = 0; a < size - 3; ++a) {
//            if (a > 0 && nums[a] == nums[a - 1]) {
//                continue;
//            }
//            for (int b = a + 1; b < size - 2; ++b) {    // 以下代码与三数之和一样的
//                if (b > a + 1 && nums[b] == nums[b - 1]) {
//                    continue;
//                }
//                int i = b + 1, j = size - 1;
//                while (i < j) {
//                    int sum = nums[a] + nums[b] + nums[i] + nums[j];
//                    if (sum < target) {
//                        while (i < j && nums[i] == nums[++i]);
//                    } else if (sum > target) {
//                        while (i < j && nums[j] == nums[--j]);
//                    } else {
//                        result.push_back(vector<int> {nums[a], nums[b], nums[i], nums[j]});
//                        while (i < j && nums[i] == nums[++i]);
//                        while (i < j && nums[j] == nums[--j]);
//                    }
//                }
//            }
//        }
//        return result;
//    }
    vector<vector<int>> fourSum(vector<int> & nums, int target) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        int size = nums.size();
        for (int a = 0; a < size - 3; ++a) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < size - 2; ++b) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int i = b + 1;
                int j = size - 1;
                while (i < j) {
                    int sum = nums[a] + nums[b] + nums[i] + nums[j];
                    if (sum < target) {
                        while (i < j && nums[i] == nums[++i]);
                    } else if (sum > target) {
                        while (i < j && nums[j] == nums[++j]);
                    } else {
                        result.push_back(vector<int> {nums[a], nums[b], nums[i], nums[j]});
                        while (i < j && nums[i] == nums[++i]);
                        while (i < j && nums[j] == nums[++j]);
                    }
                }
            }
        }
        return result;
    }
};
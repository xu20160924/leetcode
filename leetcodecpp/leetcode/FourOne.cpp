//
// Created by John on 2020/2/29.
//
#include "vector"

using namespace std;

class Solution{
public:
//    int firstMissingPositive(vector<int> & nums) {
//        if (nums.empty()) {
//            return 0;
//        }
//        int have = 0, should = 0;
//        for (int i = 0; i < nums.size(); i++) {
//            should += (i + 1);
//            if (nums[i] > 0) {
//                have += nums[i];
//            }
//        }
//        return should - have;
//    }
    int firstMissingPositive(vector<int> & nums) {
        int len = nums.size();
        for (int i = 0; i < len; ++i) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums[i], nums[nums[i] - 1]);
            }
        }
        for (int i = 0; i < len; ++i) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return len + 1;
    }

};

//int main() {
//    vector<int> nums;
//    nums.push_back(7);
//    nums.push_back(8);
//    nums.push_back(9);
//    nums.push_back(11);
//    nums.push_back(12);
//
//    Solution * solution = new Solution();
//    solution->firstMissingPositive(nums);
//}
//
// Created by John on 2020/3/2.
//
#include "vector"
using namespace std;

class Solution{
public:
//    bool increasingTriplet(vector<int> & nums) {
//        int num = 1;
//        for (int i = 1; i < nums.size(); ++i) {
//            if (nums[i] >= nums[i-1]) {
//                num+=1;
//            } else {
//                num = 1;
//            }
//            if (num >= 3) {
//                return true;
//            }
//        }
//        return false;
//    }

    bool increasingTriplet(vector<int> & nums) {
        int a = INT_MAX;
        int b = INT_MAX;
        for (auto e : nums) {
            if (e <= a) {
                a = e;
            } else if (e <= b) {
                b = e;
            } else {
                return true;
            }
        }
        return false;
    }
};

//int main() {
//    vector<int> nums;
//    nums.push_back(5);
//    nums.push_back(1);
//    nums.push_back(5);
//    nums.push_back(5);
//    nums.push_back(2);
//    nums.push_back(5);
//    nums.push_back(4);
//
//    Solution * solution = new Solution();
//    solution->increasingTriplet(nums);
//}

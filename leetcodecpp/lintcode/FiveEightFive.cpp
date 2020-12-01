//
// Created by John on 2020/3/19.
//
#include <iostream>
#include "vector"

using namespace std;

class Solution{
public:
    int mountainSequence(vector<int> nums) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[mid + 1]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
};

//int main() {
//    vector<int> nums;
////    nums.push_back(1);
////    nums.push_back(2);
////    nums.push_back(4);
////    nums.push_back(8);
////    nums.push_back(6);
////    nums.push_back(3);
//    nums.push_back(10);
//    nums.push_back(9);
//    nums.push_back(8);
//    nums.push_back(7);
//    Solution * solution = new Solution();
//    cout << solution->mountainSequence(nums) << endl;
//}

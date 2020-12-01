//
// Created by John on 2020/4/17.
//
#include "algorithm"
#include "vector"

using namespace std;

class Solution{
public:
    void sortColors(vector<int> & nums) {
        int second = nums.size() -1, zero = 0;
        for (int i = 0; i <= second; i++) {
            while (nums[i] == 2 && i < second) {
                swap(nums[i], nums[second--]);
            }
            while (nums[i] = 0 && i > zero) {
                swap(nums[i], nums[zero++]);
            }
        }
    }
};

//int main() {
//    vector<int> nums = {2, 0, 2, 1, 1, 0};
//
//    Solution * solution = new Solution();
//    solution->sortColors(nums);
//}

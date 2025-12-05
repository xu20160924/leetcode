//
// Created by caidaoliuhai on 2025/6/3.
//
#include "vector"

using namespace std;


class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int valSize = 0;
        int totalSize = nums.size();
        for (int i = 0; i < totalSize; i++) {
            if (nums[i - valSize] == val) {
                nums.erase(nums.begin() + (i - valSize));
                valSize++;
            }
        }
        return nums.size();
    }
};

int main(int argc, char *argv[]) {
    Solution *solution = new Solution();

    // vector<int> nums = {3, 2, 2, 3};
    // int val = 3;

    vector<int> nums = {0,1,2,2,3,0,4,2};
    int val = 2;

    solution->removeElement(nums, val);
}

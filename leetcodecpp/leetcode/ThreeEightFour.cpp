//
// Created by John on 2020/3/25.
//
#include "vector"

using namespace std;

class Solution{
public:
    Solution(vector<int> nums) {
        Elements = nums;
    }
    // Resets the Array to its original configuration and return it.
    vector<int> reset() {
        return Elements;
    }

    // Return a random shuffling of the array.
    vector<int> shuffle() {
        vector<int> vShuffle = Elements;
        for (int i = 1; i < vShuffle.size(); ++i) {
            int r = rand() % (i + 1);
            if (r != i) {
                swap(vShuffle[r], vShuffle[i]);
            }
        }
        return vShuffle;
    }

private:
    vector<int> Elements;
};

//int main() {
//    vector<int> nums;
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(3);
//    Solution * solution = new Solution(nums);
//    solution->shuffle();
//}
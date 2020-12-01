//
// Created by John on 2020/2/24.
//

#include "OneOne.h"
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxArea = 0;
        int i = 0, j = height.size() - 1;
        while (i < j) {
            int curr = 0;
            if (height[i] < height[j]) {
                curr = height[i] * (j - i);
                i++;
            } else {
                curr = height[j] * (j - i);
                j--;
            }
            maxArea = max(maxArea, curr);
        }
        return maxArea;
    }
};
//int main() {
////    [1,8,6,2,5,4,8,3,7]
//
////    vector<int> nums;
////    nums.push_back(1);
////    nums.push_back(8);
////    nums.push_back(6);
////    nums.push_back(2);
////    nums.push_back(5);
////    nums.push_back(4);
////    nums.push_back(8);
////    nums.push_back(3);
////    nums.push_back(7);
////    Solution * solution = new Solution();
////    printf("%d", solution->maxArea(nums));
//
//    printf("%d", 1^2^1);
//}


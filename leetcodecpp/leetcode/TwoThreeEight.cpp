//
// Created by John on 2020/3/22.
//
#include <numeric>
#include "vector"

using namespace std;

class Solution{
public:
//    vector<int> productExceptSelf(vector<int>& nums) {
//        int allSum = accumulate(nums.begin(), nums.end(), 1, multiplies<int>());
//        for (int i = 0; i < nums.size(); ++i) {
//            nums[i] = allSum / nums[i];
//        }
//        return nums;
//    }
//    vector<int> productExceptSelf(vector<int> & nums) {
//        int length = nums.size();
//        int L [length];
//        int R [length];
////        int answer [length];
//        vector<int> answer(length);
//
//        L[0] = 1;
//        for (int i = 1; i < length; ++i) {
//            L[i] = nums[i - 1] * L[i - 1];
//        }
//
//        R[length - 1] = 1;
//        for (int j = length - 2; j >= 0 ; ++j) {
//           R[j] = nums[j] * R[j];
//        }
//        for (int k = 0; k < length; ++k) {
//            answer[k] = L[k] * R[k];
//        }
//        return answer;
//    }

//    vector<int> productExceptSelf(vector<int> & nums) {
//        int length = nums.size();
//        vector<int> L(length);
//        vector<int> R(length);
//        vector<int> answer(length);
//
//        L[0] = 1;
//        for (int i = 1; i < length; i++) {
//            L[i] = nums[i - 1] * L[i - 1];
//        }
//        R[length - 1] = 1;
//        for (int i = length - 2; i >= 0; i--) {
//            R[i] = nums[i + 1] * R[i + 1];
//        }
//        for (int i = 0; i < length; i++) {
//            answer[i] = L[i] * R[i];
//        }
//        return answer;
//    }
    vector<int> productExceptSelf(vector<int> & nums) {
        int length = nums.size();
        vector<int> answer(length);
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R *= nums[i];
        }
        return answer;
    }

};

//int main() {
//    Solution * solution = new Solution();
//    vector<int> nums;
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(3);
//    nums.push_back(4);
//    solution->productExceptSelf(nums);
//}

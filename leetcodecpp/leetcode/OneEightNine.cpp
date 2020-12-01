//
// Created by John on 2020/3/18.
//
#include "vector"
using namespace std;

class Solution{
public:
//    void rotate(vector<int> & nums, int k) {
//        k = k % nums.size();
//        int count = 0;
//        for (int start = 0; count < nums.size(); start++) {
//            int current = start;
//            int prev = nums[start];
//            do {
//                int next = (current + k) % nums.size();
//                int temp = nums[next];
//                nums[next] = prev;
//                prev = temp;
//                current = next;
//                count++;
//            } while (start != current);
//        }
//    }

    void rotate(vector<int> & nums, int k) {
        k %= nums.size();
        reverse(nums, 0, nums.size() - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.size() - 1);
    }

    vector<int> reverse(vector<int> & nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
};

//int main() {
//    vector<int> nums;
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(3);
//    nums.push_back(4);
//    nums.push_back(5);
//    nums.push_back(6);
//
//
//    Solution * solution = new Solution();
//    solution->rotate(nums, 2);
//}

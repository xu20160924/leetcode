//
// Created by John on 2020/3/20.
//
#include <iostream>
#include "vector"
using namespace std;
class Solution{
public:
//    vector<int> sortArray(vector<int> & nums) {
//        if (nums.empty() || nums.size() == 0) {
//            return nums;
//        }
//
//    }
//    void quickSort(vector<int> & nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int left = start, right = end;
//        int pivot = nums[start + end] / 2;
//        while (left <= right) {
//            while (left <= right && nums[left] < pivot) {
//                left++;
//            }
//            while (left <= right && nums[right] > pivot) {
//                right--;
//            }
//            if (left <= right) {
//                int temp = nums[left];
//                nums[left] = nums[right];
//                nums[right] = temp;
//                left++;
//                right--;
//            }
//        }
//        quickSort(nums, start, right);
//        quickSort(nums, left, end);
//    }
    vector<int> sortArray(vector<int>& nums) {
        if (nums.empty() || nums.size() == 0) {
            return nums;
        }
        quickSort(nums, 0, nums.size() - 1);
        return nums;
    }
    void quickSort(vector<int> & nums, int start, int end) {
        if (start >= end) {
            return;
        }
//        cout << 1 << endl;
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
};

//int main() {
//    vector<int> nums;
////    nums.push_back(5);
////    nums.push_back(2);
////    nums.push_back(3);
////    nums.push_back(1);
//
//
//    nums.push_back(5);
//    nums.push_back(1);
//    nums.push_back(1);
//    nums.push_back(2);
//    nums.push_back(0);
//    nums.push_back(0);
//    Solution * solution = new Solution();
//    solution->sortArray(nums);
//}
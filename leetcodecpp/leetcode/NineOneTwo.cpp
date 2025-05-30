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
//    vector<int> sortArray(vector<int>& nums) {
//        if (nums.empty() || nums.size() == 0) {
//            return nums;
//        }
//        quickSort(nums, 0, nums.size() - 1);
//        return nums;
//    }
//    void quickSort(vector<int> & nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        int left = start;
//        int right = end;
//        int pivot = nums[(left + right) / 2];
//        while (left <= right) {
//            while (left <= right && nums[left] < pivot) {
//                left++;
//            }
//            while (left <= right && nums[right] > pivot) {
//                right--;
//            }
//            if (left <= right) {
//                int temp = nums[right];
//                nums[right] = nums[left];
//                nums[left] = temp;
//                left++;
//                right--;
//            }
//        }
//        quickSort(nums, start, right);
//        quickSort(nums, left, end);
//    }

//      vector<int> sortArray(vector<int>& nums) {
//            for (int i = 0; i < nums.size() - 1; i++) {
//                  for (int j = 0; j < nums.size() - i - 1; j++) {
//                        if (nums[j] > nums[j + 1]) {
//                              int temp = nums[j + 1];
//                              nums[j + 1] = temp;
//                              nums[j] = nums[j + 1];
//                        }
//                  }
//            }
//            return nums;
//      }
// public:
//     vector<int> sortArray(vector<int>& nums) {
//         quickSort(nums, 0, nums.size() - 1);
//         return nums;
//     }
//
//     void quickSort(vector<int>& nums, int startIndex, int endIndex) {
//         if (startIndex > endIndex) {
//             return;
//         }
//         int pivot = partition(nums, startIndex, endIndex);
//         quickSort(nums, startIndex, pivot - 1);
//         quickSort(nums, pivot + 1, endIndex);
//     }
//
//     int partition(vector<int>& nums, int startIndex, int endIndex) {
//         int pivot = nums[startIndex + rand() % (endIndex - startIndex + 1)];
//         int mark = startIndex;
//
//         for (int i = startIndex + 1; i <= endIndex; i++) {
//             if (nums[i] < pivot) {
//                 mark++;
//                 int p = nums[mark];
//                 nums[mark] = nums[i];
//                 nums[i] = p;
//             }
//         }
//
//         nums[startIndex] = nums[mark];
//         nums[mark] = pivot;
//
//         return mark;
//     }

public:
    vector<int> sortArray(vector<int>& nums) {
        bucketSort(nums, nums.size());
        return nums;
    }

    // Insertion sort function to sort individual buckets
    void insertionSort(vector<int>& bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int key = bucket[i];
            int j = i - 1;
            while (j >= 0 && bucket[j] > key) {
                bucket[j + 1] = bucket[j];
                j--;
            }
            bucket[j + 1] = key;
        }
    }

    void bucketSort(vector<int>& nums, int n) {
        int min_val = *min_element(nums.begin(), nums.end());
        int max_val = *max_element(nums.begin(), nums.end());
        int bucket_count = max_val - min_val + 1;


        // create bucket
        vector<vector<int>> bucket(bucket_count);

        // put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bi = nums[i] - min_val;
            bucket[bi].push_back(nums[i]);
        }

        // Sort individual buckets by insertion sort
        for (int i = 0; i < bucket_count; i++) {
            insertionSort(bucket[i]);
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < bucket_count; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                nums[index++] = bucket[i][j];
            }
        }
    }


};

int main() {
    vector<int> nums = {-2, -3, 5};

    Solution * solution = new Solution();
    solution->sortArray(nums);
}
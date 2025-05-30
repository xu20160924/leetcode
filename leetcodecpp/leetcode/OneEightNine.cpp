//
// Created by John on 2020/3/18.
//
#include "vector"
#include "iostream"
#include "algorithm"
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

//    void rotate(vector<int> & nums, int k) {
//        k %= nums.size();
//        reverse(nums, 0, nums.size() - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.size() - 1);
//    }
//
//    vector<int> reverse(vector<int> & nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }

      // void rotate(vector<int>& nums, int k) {
      //     int n = nums.size();
      //     k = k % n;
      //     if (k == 0 || n <= 1) return;
      //
      //     int start = 0, count = 0;
      //     while (count < n) {
      //         int current = start;
      //         cout << current << " current";
      //         int prev = nums[start];
      //         do {
      //             int next = (current + k) % n;
      //             cout << next << endl;
      //             swap(prev, nums[next]);
      //             current = next;
      //             count++;
      //         } while (current != start);
      //         start++;
      //     }
      // }


    // void rotate(vector<int>& nums, int k) {
    //     k %= nums.size();
    //     reverse(nums, 0, nums.size() - 1);
    //     reverse(nums, 0, k - 1);
    //     reverse(nums, k, nums.size() - 1);
    // }
    //
    // void reverse(vector<int>& nums, int start, int end) {
    //     while (start < end) {
    //         int temp = nums[start];
    //         nums[start] = nums[end];
    //         nums[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }


    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k % n;
        if (k == 0 || n <= 1) {
            return;
        }
        // int cycles =
        // for (int i = 0; i < cycles; i++) {
        //
        // }

    }
};

int main() {
    // vector<int> nums{1,2,3,4,5,6,7};
    vector<int> nums{1,2,3,4};

    Solution * solution = new Solution();
    solution->rotate(nums, 2);
}

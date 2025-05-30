//
// Created by John on 2025/3/29.
//
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

class Solution {
public:
    // static vector<int> findClosestElements(vector<int> &arr, int k, int x) {
    //     priority_queue<pair<int, int>> pq;
    //     priority_queue<pair<int, int>> maxPQ;
    //     vector<int> res;
    //     for (int i = 0; i < arr.size(); i++) {
    //         pq.push({abs(arr[i] - x), arr[i]});
    //         if (pq.size() > k) {
    //             pq.pop();
    //         }
    //     }
    //
    //
    //     for (int i = 0; i < k; i++) {
    //         res.push_back(pq.top().second);
    //         pq.pop();
    //     }
    //     // sort(res.begin(), res.end());
    //     reverse(res.begin(), res.end());
    //     return res;
    // }
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return vector<int>(arr.begin() + left, arr.begin() + left + k);
    }
};

// int main() {
//     // vector<int> arr = {1, 1, 1, 10, 10, 10};
//     // int k = 1;
//     // int x = 9;
//
//     vector<int> arr = {1,2,3,4,5};
//     int k = 4;
//     int x = 3;
// };


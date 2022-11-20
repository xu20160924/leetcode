//
// Created by caidaoliuhai on 2022/11/11.
//
#include "../algorithm/LeetCodeInterview.h"
#include "queue"
#include "set"

using namespace std;

class Solution {
private:
    vector<int> unique;
    map<int, int> m;
//    set<int> unique;
public:
    int partition(int left, int right, int pivot) {
        int pivotFrequency = m[unique[pivot]];
        // 1. move pivot to the end
        swap(unique[pivot], unique[right]);

        int storeIndex = left;
        for (int i = left; i <= right; i++) {
            if (m[unique[i]] < pivotFrequency) {
                swap(unique[storeIndex], unique[i]);
                storeIndex += 1;
            }
        }

        swap(unique[right], unique[storeIndex]);
        return storeIndex;
    }

    vector<int> topKFrequent(vector<int>& nums, int k) {
        if (nums.size() == k) {
            return nums;
        }

        for (int num : nums) {
            m[num] += 1;
        }
        // construct unique vector
        for (pair<int, int> p : m) {
            unique.push_back(p.first);
        }

        int n = m.size();
        quickSelect(0, n - 1, n - k);
        vector<int> res(k);
        copy(unique.begin() + n - k, unique.end(), res.begin());
        return res;
    }

    void quickSelect(int left, int right, int kSmall) {
        // fixed the boundary between left and right
        int pivotIndex = left + rand() % (right - left + 1);

        pivotIndex = partition(left, right, pivotIndex);

        if (kSmall == pivotIndex) {
            return;
        } else if (kSmall < pivotIndex) {
            quickSelect(left, pivotIndex - 1, kSmall);
        } else {
            quickSelect(pivotIndex + 1, right, kSmall);
        }
    }
//    vector<int> topKFrequent(vector<int>& nums, int k) {
//        map<int, int, secondCom> m;
//        for (int num : nums) {
//            if (m.count(num)) {
////                int tmp = ++m[num];
////                m.erase(num);
////                m.insert({ num, tmp});
//
////                m[num] = m[num] + 1;
////                m.emplace(make_pair(num, m[num]++));
//            } else {
//                m.insert({ num, 1});
//            }
//        }
//
//        vector<int> res;
//        int i = 0;
//        for (pair<int, int> entry : m) {
//            if (i == k) {
//                return res;
//            }
//            res.push_back(entry.first);
//            i++;
//        }
//    }

//    vector<int> topKFrequent(vector<int>& nums, int k) {
//        if (k == nums.size()) {
//            return nums;
//        }
//
//        map<int, int> m;
//        for (int num : nums) {
//            m[num] += 1;
//        }
//
//        priority_queue<pair<int, int>, vector<pair<int, int>>, customCom> maxHeap;
//        for (map<int, int>::iterator it = m.begin(); it != m.end(); ++it) {
//            maxHeap.push({ it->first, it->second});
//            if (maxHeap.size() > k) {
//                maxHeap.pop();
//            }
//        }
//
//        vector<int> res;
//        for (int i = 0; i < k; ++i) {
//            res.push_back(maxHeap.top().first);
//            maxHeap.pop();
//        }
//        return res;
};
    typedef struct {
        bool operator() (pair<int, int> &l, pair<int, int> &r) const { return l.second > r.second; }
    } customCom;

    struct CustomCom {
        bool operator() (int l, int r) const { return l > r; }
    };


    typedef struct {
        bool operator() (int f, int s) const { return f < s; }
    } secondCom;



int main() {
//    const auto data = {1,8,5,6,3,4,0,9,7,2};
//    struct {
//        bool operator() (const int l, const int r) const { return l > r; }
//    } customLess;
//    priority_queue minq3(data.begin(), data.end(), customLess);

    vector<int> nums{4,1,-1,2,-1,2,3};
    Solution *solution = new Solution();
    auto res = solution->topKFrequent(nums, 2);
    cout << "" << endl;

    struct {
        bool operator() (const int l, const int r) const { return l > r; }
    } customLess;
}
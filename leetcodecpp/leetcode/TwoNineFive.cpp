//
// Created by John on 2020/2/28.
//

#include <iostream>
#include "vector"
#include "queue"
#include "set"

using namespace std;

class Solution {
    vector<double> store;

//    void addNum(int num) {
//        store.push_back(num);
//    }
//    double findMedian() {
//        sort(store.begin(), store.end());
//        int n = store.size();
//        return (n & 1 ? store[n / 2] : (store[ n / 2 - 1] + store[n / 2]) * 0.5);
//    }
//    void addNum(int num) {
//        if (store.empty()) {
//            store.push_back(num);
//        } else {
//            // binary search and insertion combined
//            store.insert(lower_bound(store.begin(), store.end(), num), num);
//        }
//    }
//
//    double findMedian() {
//        int n = store.size();
//        return n & 1 ? store[n / 2] : (store[n / 2 - 1] + store[n / 2]) * 0.5;
//    }

//    priority_queue<int> lo; //max heap
//    priority_queue<int, vector<int>, greater<int> > hi; //min heap
//
//    void addNum(int num) {
//        lo.push(num);
//        hi.push(lo.top());
//        lo.pop();
//
//        if (lo.size() < hi.size()) {
//            lo.push(hi.top());
//            hi.pop();
//        }
//    }
//
//    double findMedian() {
//        return lo.size() > hi.size() ? (double) lo.top() : (lo.top() + hi.top()) * 0.5;
//    }

    multiset<int> data;
//    multiset<int>::iterator  lo_median, hi_median;
    multiset<int>::iterator mid;

public:
    Solution()
        : mid(data.end())
    {
    }
    void addNum(int num) {
        const int n = data.size();
        data.insert(num);
        if (!n) {
            mid = data.begin();
        } else if (num < *mid) {
            mid = (n & 1 ? mid : prev(mid));
        } else {
            mid = (n & 1 ? next(mid) : mid);
        }
    }

    double findMedian() {
        const int n = data.size();
        return (*mid + *next(mid,n % 2 - 1)) * 0.5;
    }

//    void addNum(int num) {
//        const size_t n = data.size();
//        data.insert(num);
//        if (!n) {
//            lo_median = hi_median = data.begin();
//        } else if (n & 1) {
//            if (num < *lo_median) {
//                cout << *lo_median << endl;
//                lo_median--;
//            } else {
//                cout << *hi_median << endl;
//                hi_median++;
//            }
//        } else {
//            if (num > *lo_median && num < *hi_median) {
//                lo_median++;
//                hi_median--;
//            } else if (num >= *hi_median) {
//                lo_median++;
//            } else {
//                lo_median = --hi_median;
//            }
//        }
//    }
//
//    double findMedian() {
//        return (*lo_median + *hi_median) * 0.5;
//    }



//public:
//    void addNum(int num) {
//        if (nums.size() < 2) {
//            median = num;
//        } else {
//            if (nums.size() % 2 == 0) {
//                median = double((nums[index] + nums[index + 1])) / double(2);
//            } else {
//                median = nums[++index];
//            }
//        }
//        nums.push_back(num);
//    }
//
//    double findMedian() {
//        return median;
//    }
//
//private:
//    double median;
//    int index;
//    vector<int> nums;
};
//int main() {
//    Solution * solution = new Solution();
//    solution->addNum(1);
//    solution->addNum(2);
//    cout << solution->findMedian() << endl;
//    solution->addNum(3);
//    cout << solution->findMedian() << endl;
////     printf("%d", 3 / 2);
////    cout<< double(3) / double(2)<<endl;
//}
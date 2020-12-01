//
// Created by John on 2020/11/23.
//

#include <iostream>
#include "vector"

using namespace std;

class Solution {
public:
    vector<int> LIS(vector<int> &arr) {
        // greedy and dichotomy
        vector<int> res;
        vector<int> maxLen;

        if (arr.size() < 1) {
            return res;
        }
        res.emplace_back(arr[0]);
        maxLen.emplace_back(1);
        for (int i = 1; i < arr.size(); i++) {
            if (arr[i] > res.back()) {
                res.emplace_back(arr[i]);
                maxLen.emplace_back(res.size());
            } else {
                // return the number that first greater or equal to the val in begin ...  end
                int pos = lower_bound(res.begin(), res.end(), arr[i]) - res.begin();
//                auto pos = lower_bound(res.begin(), res.end(), arr[i]) ;
//                *pos = (pos - res.begin());
//                cout << *pos << endl;
                cout << *res.begin() << endl;
                res[pos] = arr[i];
                maxLen.emplace_back(pos + 1);
            }
        }
        for (int i = arr.size() - 1, j = res.size(); j > 0; --i) {
            if (maxLen[i] == j) {
                res[--j] = arr[i];
            }
        }
        return res;
    }
};

int main() {
    Solution *solution = new Solution();
    vector<int> arr;
    arr.emplace_back(2);
    arr.emplace_back(1);
    arr.emplace_back(5);
    arr.emplace_back(3);
    arr.emplace_back(6);
    arr.emplace_back(4);
    arr.emplace_back(8);
    arr.emplace_back(9);
    arr.emplace_back(7);
    solution->LIS(arr);



//    const std::vector<int> data = { 1, 2, 4, 5, 5, 6 };
//    for (int i = 0; i < 8; ++i) {
//        // Search for first element x such that i ≤ x
//        auto lower = std::lower_bound(data.begin(), data.end(), i);
//
//        std::cout << i << " ≤ ";
//        lower != data.end()
//        ? std::cout << *lower << " at index " << std::distance(data.begin(), lower)
////        *lower
////        std::distance(data.begin(), lower)
//        : std::cout << "[not found]";
//        std::cout << '\n';
//    }


}
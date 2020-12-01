//
// Created by John on 2020/1/30.
//

#include "OneFiveFour.h"
#include <vector>

using namespace std;

class Solution {
public:
    static int findMin(vector<int> &num) {
        int lo = 0;
        int hi = num.size() - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else if (num[mid] < num[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return num[lo];
    }
};
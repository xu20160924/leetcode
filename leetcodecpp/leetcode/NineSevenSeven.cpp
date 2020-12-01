//
// Created by John on 2020/2/6.
//

#include "NineSevenSeven.h"
#include <vector>

using namespace std;

class Solution{
public:
    static vector<int> sortedSquares(vector<int> & A) {
        vector<int> result(A.size());
        size_t l = 0;
        size_t r = A.size();
        size_t p = A.size() - 1;

        while (l < r) {
            int x = A[l] * A[l];
            int y = A[r - 1] * A[r - 1];
            if (x >= y) {
                result[p] = x;
                p--;
                l++;
            } else {
                result[p] = y;
                p--;
                r--;
            }
        }
        return result;
    }
};
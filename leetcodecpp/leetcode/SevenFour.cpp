//
// Created by John on 2020/2/7.
//

#include "SevenFour.h"
#include <vector>

using namespace std;


class Solution {
public:
    static bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int n = matrix.size(); // the size of rows
        int m = matrix[0].size(); // the size of single row
        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r -1) >> 1;
            if (matrix[mid / m][mid % m] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[r / m][r % m] == target;
    }
};

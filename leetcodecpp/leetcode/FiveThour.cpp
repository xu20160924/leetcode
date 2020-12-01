//
// Created by John on 2020/3/17.
//
#include "vector"

using namespace std;

class Solution{
public:
//    vector<int> spiralOrder(vector<vector<int> > & matrix ) {
//        vector<int> res;
//        int x = matrix.size()-1;
//        int y = matrix[0].size()-1;
//        for (int i = 0; i <= x; i++) {
//            for (int j = 0; j <= y; j++) {
//                if (j == y) {
//                    res.push_back(matrix[i][j]);
//                    int temp = i;
//                    i = j;
//                    j = temp;
//                    continue;
//                }
//                res.push_back(matrix[i][j]);
//            }
//        }
//        return res;
//    }

    vector<int> spiralOrder(vector<vector<int> > & matrix) {
        vector<int> res;
        if (matrix.size() == 0) {
            return res;
        }
        int r1 = 0, r2 = matrix.size() - 1;
        int c1 = 0, c2 = matrix[0].size() - 1;
        while (c1<=c2 && r1<=r2) {
            for (int c = c1; c <= c2; c++) {
                res.push_back(matrix[r1][c]);
            }
            for (int r = r1+1; r <= r2; r++) {
                res.push_back(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    res.push_back(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    res.push_back(matrix[r][c1]);
                }
            }
            c1++;
            r1++;
            c2--;
            r2--;
        }
        return res;
    }
};

//int main() {
//    vector<vector<int> > matrix;
//    vector<int> row1, row2, row3;
//    row1.push_back(1);
//    row1.push_back(2);
//    row1.push_back(3);
//
//    row2.push_back(4);
//    row2.push_back(5);
//    row2.push_back(6);
//
//    row3.push_back(7);
//    row3.push_back(8);
//    row3.push_back(9);
//
//    matrix.push_back(row1);
//    matrix.push_back(row2);
//    matrix.push_back(row3);
//
//    Solution * solution = new Solution();
//    solution->spiralOrder(matrix);
//}
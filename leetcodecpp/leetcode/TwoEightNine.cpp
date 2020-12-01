//
// Created by John on 2020/3/1.
//
#include <iostream>
#include "vector"

using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int> > &board) {
        int m = board.size(), n = m ? board[0].size() : 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int I = max(i - 1, 0); I < min(i + 2, m); ++I) {
                    for (int J = max(j - 1, 0); J < min(j + 2, n); ++J) {
                        count += board[I][J] & 1;
                    }
                }
                if (count == 3 || count - board[i][j] == 3) {
                    board[i][j] |= 2;
                }
//                if ((count | board[i][j]) == 3) {
//                    board[i][j] |= 2;
//                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
};
//
//int main() {
////    vector<vector<int> > board;
////    vector<int> row1, row2, row3, row4;
////    row1.push_back(0);
////    row1.push_back(1);
////    row1.push_back(0);
////
////    row2.push_back(0);
////    row2.push_back(0);
////    row2.push_back(1);
////
////    row3.push_back(1);
////    row3.push_back(1);
////    row3.push_back(1);
////
////    row4.push_back(0);
////    row4.push_back(0);
////    row4.push_back(0);
////    row4.push_back(0);
////    board.push_back(row1);
////    board.push_back(row2);
////    board.push_back(row3);
////    board.push_back(row4);
////
////    Solution *solution = new Solution();
////    solution->gameOfLife(board);
//
//
//
//    int a = 4 | 2;
//    cout << a << endl;
//}
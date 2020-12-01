//
// Created by John on 2020/3/15.
//

#include "vector"

using namespace std;
class Solution {
public:
    bool isValidSudoku(vector<vector<char> > & board) {
        int used1[9][9] = {0}, used2[9][9] = {0}, used3[9][9] = {0};
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if (used1[i][num] || used2[j][num] || used3[k][num]) {
                        return false;
                    }
                    used1[i][num] = used2[j][num] = used3[k][num] = 1;
                }
            }
        }
        return true;
    }
};


//int main() {
//    Solution * solution = new Solution();
//    vector<vector<char> > board;
//    vector<char> row1, row2, row3, row4, row5, row6, row7, row8, row9;
//    row1.push_back('5');
//    row1.push_back('3');
//    row1.push_back('.');
//    row1.push_back('.');
//    row1.push_back('7');
//    row1.push_back('.');
//    row1.push_back('.');
//    row1.push_back('.');
//    row1.push_back('.');
//
//    row2.push_back('6');
//    row2.push_back('.');
//    row2.push_back('.');
//    row2.push_back('1');
//    row2.push_back('9');
//    row2.push_back('5');
//    row2.push_back('.');
//    row2.push_back('.');
//    row2.push_back('.');
//
//    row3.push_back('.');
//    row3.push_back('9');
//    row3.push_back('8');
//    row3.push_back('.');
//    row3.push_back('.');
//    row3.push_back('.');
//    row3.push_back('.');
//    row3.push_back('6');
//    row3.push_back('.');
//
//
//    row4.push_back('8');
//    row4.push_back('.');
//    row4.push_back('.');
//    row4.push_back('.');
//    row4.push_back('6');
//    row4.push_back('.');
//    row4.push_back('.');
//    row4.push_back('.');
//    row4.push_back('3');
//
//    row5.push_back('4');
//    row5.push_back('.');
//    row5.push_back('.');
//    row5.push_back('8');
//    row5.push_back('.');
//    row5.push_back('3');
//    row5.push_back('.');
//    row5.push_back('.');
//    row5.push_back('1');
//
//    row6.push_back('7');
//    row6.push_back('.');
//    row6.push_back('.');
//    row6.push_back('.');
//    row6.push_back('2');
//    row6.push_back('.');
//    row6.push_back('.');
//    row6.push_back('.');
//    row6.push_back('6');
//
//    row7.push_back('.');
//    row7.push_back('6');
//    row7.push_back('.');
//    row7.push_back('.');
//    row7.push_back('.');
//    row7.push_back('.');
//    row7.push_back('2');
//    row7.push_back('8');
//    row7.push_back('.');
//
//    row8.push_back('.');
//    row8.push_back('.');
//    row8.push_back('.');
//    row8.push_back('4');
//    row8.push_back('1');
//    row8.push_back('9');
//    row8.push_back('.');
//    row8.push_back('.');
//    row8.push_back('5');
//
//    row9.push_back('.');
//    row9.push_back('.');
//    row9.push_back('.');
//    row9.push_back('.');
//    row9.push_back('8');
//    row9.push_back('.');
//    row9.push_back('.');
//    row9.push_back('7');
//    row9.push_back('9');
//
//    board.push_back(row1);
//    board.push_back(row2);
//    board.push_back(row3);
//    board.push_back(row4);
//    board.push_back(row5);
//    board.push_back(row6);
//    board.push_back(row7);
//    board.push_back(row8);
//    board.push_back(row9);
//    solution->isValidSudoku(board);
//}
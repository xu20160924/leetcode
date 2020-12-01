//
// Created by John on 2020/2/12.
//

#include "OneThreeZero.h"
#include <vector>
#include <iostream>

using namespace std;

class UF {
private:
    int *id;
    int *rank;
    int count;
public:
    UF(int N) {
        count = N;
        id = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    ~UF() {
        delete[] id;
        delete[] rank;
    }

    int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
        }
        return id[p];
    }

    int getCount() {
        return count;
    }

    bool connected(int p, int q) {
        return find(p) == find(q);
    }

    void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (rank[i] < rank[j]) {
            id[i] = j;
        } else if (rank[i] > rank[j]) {
            id[j] = i;
        } else {
            id[j] = i;
            rank[i]++;
        }
        count--;
    }
};

class Solution {
public:
    void solve(vector<vector<char> > &board) {
        int n = board.size();
        if (n == 0) {
            return;
        }
        int m = board[0].size();
        UF uf = UF(n * m + 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O') {
                    uf.connect(i * m + j, n * m);
                } else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        uf.connect(i * m * j, (i - 1) * m + j);
                    }
                    if (board[i + 1][j] == 'O') {
                        uf.connect(i * m * j, (i + 1) * m + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        uf.connect(i * m + j, i * m + j - 1);
                    }
                    if (board[i][j + 1] == 'O') {
                        uf.connect(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!uf.connected(i*m+j, n*m)) {
                    board[i][j] = 'X';
                }
            }
        }
    }



    //public:
//    void solve(vector<vector<char> > & board) {
//        int i, j;
//        int row = board.size();
//        if (!row) {
//            return;
//        }
//        int col = board[0].size();
//        for (i = 0; i < row; ++i) {
//            check(board, i, 0, row, col);
//            if (row > 1) {
//                check(board, i, col - 1, row, col);
//            }
//        }
//        for (j = 1; j + 1 < col; j++) {
//            check(board, 0, j, row, col);
//            if (row > 1) {
//                check(board, row - 1, j, row, col);
//            }
//        }
//        for (i = 0; i < row; i++) {
//            for (j = 0; j < col; j++) {
//                if (board[i][j] == 'O') {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//        for (i = 0; i< row; i++) {
//            for (j = 0; j < col; j++) {
//                if (board[i][j] == '1') {
//                    board[i][j] = 'O';
//                }
//            }
//        }
//    }
//
//private:
//    void check(vector<vector<char> > &vec, int i, int j, int row, int col) {
//        if (vec[i][j] == 'O') {
//            vec[i][j] = '1';
//            if (i >= 1) {
//                check(vec, i - 1, j, row, col);
//            }
//            if (j >= 1) {
//                check(vec, i, j - 1, row, col);
//            }
//            if (i+1 < row) {
//                check(vec, i + 1, j, row, col);
//            }
//            if (j+1 < col) {
//                check(vec, i, j + 1, row, col);
//            }
//        }
//    }


//class UF {
//private:
//    int * id;
//    int * rank;
//    int  count;
//public:
//    UF(int N) {
//        count = N;
//        id = new int[N];
//        rank = new int[N];
//        for (int i = 0; i < N; i++) {
//            id[i] = i;
//            rank[i] = 0;
//        }
//    }
//    ~UF() {
//        delete[] id;
//        delete[] rank;
//    }
//    int find(int i) {
//        if (i != id[i]) {
//            id[i] = find(id[i]);
//        }
//        return id[i];
////        while (i != id[i]) {
////            id[i] = id[id[i]];
////        }
////        return id[i];
//    }
//
//    bool connected(int p, int q) {
//        return find(p) == find(q);
//    }
//
//    void connect(int p, int q) {
//        int i = find(p);
//        int j = find(q);
//        if (i == j) {
//            return;
//        }
//        if (rank[i] < rank[j]) {
//            id[i] = j;
//        } else if (rank[i] > rank[j]) {
//            id[j] = i;
//        } else {
//            id[j] = i;
//            rank[i]++;
//        }
//        count--;
//    }
//};
//
//class Solution {
//public:
//    void solve(vector<vector<char> >& board) {
//        int n = board.size();
//        if (n == 0) {
//            return;
//        }
//        int m = board[0].size();
//        UF uf = UF(n*m+1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if ((i == 0 || i == n - 1 || j == 0 || j == m -1) && board[i][j] == 'O') {
//                    uf.connect(i*m+j, n*m);
//                } else if (board[i][j] == 'O'){
//                    if (board[i-1][j] == 'O') {
//                        uf.connect(i*m+j, (i-1)*m+j);
//                    }
//                    if (board[i+1][j] == 'O') {
//                        uf.connect(i*m+j, (i+1)*m+j);
//                    }
//                    if (board[i][j-1] == 'O') {
//                        uf.connect(i*m+j, i*(j-1));
//                    }
//                    if (board[i][j+1] == 'O') {
//                        uf.connect(i*m+j, i*(j+1));
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (!uf.connected(i*m+j, n*m)) {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }


};
//
//int main() {
//    vector<vector<char> > board;
//    vector<char> col1, col2, col3, col4;
//    col1.push_back('X');
//    col1.push_back('X');
//    col1.push_back('X');
//    col1.push_back('X');
//
//    col2.push_back('X');
//    col2.push_back('X');
//    col2.push_back('O');
//    col2.push_back('X');
//
//    col3.push_back('X');
//    col3.push_back('O');
//    col3.push_back('X');
//    col3.push_back('X');
//
//    col4.push_back('X');
//    col4.push_back('O');
//    col4.push_back('X');
//    col4.push_back('X');
//
//    board.push_back(col1);
//    board.push_back(col2);
//    board.push_back(col3);
//    board.push_back(col4);
//
//    Solution solution = *new Solution();
//    solution.solve(board);
////    for (vector<char> i = board.begin(); i != board.end(); ++i) {
////        for (auto j = board[i].begin(); i != board[i].end(); ++j) {
////            cout << *i << ' ' << endl;
////        }
////    }
//    for (int i = 0; i < board.size(); i++) {
//        for (int j = 0; j < board[0].size(); j++) {
//            cout << board[i][j] << endl;
//        }
//    }
//};
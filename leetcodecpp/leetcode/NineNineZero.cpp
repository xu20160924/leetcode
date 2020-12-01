//
// Created by John on 2020/2/7.
//

#include "NineNineZero.h"
#include <vector>
#include <string>
#include <iostream>

using namespace std;


class Solution{
    int uf[26];

    int find(int x) {
        if(x != uf[x]) {
            uf[x] = find(uf[x]);
        }
        return uf[x];
    }

public:
    bool equationsPossible(vector<string> & equations) {
        for (int i = 0; i < 26; ++i) {
            uf[i] = i;
        }
        for (string e : equations) {
            if(e[1] == '=') {
//                cout << e[0] - 'a' << endl;
                uf[find(e[0] - 'a')] = find(e[3] - 'a');
            }
        }
        for (string e: equations) {
            if (e[1] == '!' && find(e[0] - 'a') == find(e[3] - 'a')) {
                return false;
            }
        }
        return true;
    }




//public:
//    bool equationsPossible(vector<string>& equations) {
//        for (int i = 0; i < 26; ++i) {
//            uf[i] = i;
//        }
//        for (string e : equations) {
//            if (e[1] == '=') {
//                uf[find(e[0] - 'a')] = uf[find(e(3) - 'a')];
//            }
//        }
//        for (string e: equations) {
//            if (e[1] == '!' && find[e[0] - 'a'] == find[e[3] - 'a']) {
//                return false;
//            }
//        }
//        return true
//    }
//    int uf[26];
//public:
//    int find(int x) {
//        if (x != uf[x]) {
//            uf[x] = find(uf[x]);
//        }
//        return uf[x];
//    }

};

//int main() {
////    cout << 'a' - 'a' << endl;
//  vector<string> equations;
//  equations.push_back("a==b");
//  equations.push_back("b!=c");
//  equations.push_back("c==a");
////    equations.push_back("c==c");
////    equations.push_back("b==d");
////    equations.push_back("x!=z");
//  Solution solution = *new Solution();
//  solution.equationsPossible(equations);
//};

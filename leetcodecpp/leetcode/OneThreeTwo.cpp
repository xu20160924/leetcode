//
// Created by John on 2020/3/16.
//
#include <iostream>
#include "string"
#include "vector"

using namespace std;

class Solution {
public:
//    int minCut(string s) {
//        int n = s.size();
//        vector<int> cut(n + 1, 0);  // number of cuts for the first k characters
//        for (int i = 0; i <= n; i++) {
//            cut[i]= i - 1;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; i - j >= 0 && i+j < n && s[i-j] == s[i+j]; ++j) { // odd length palindrome
//                cut[i+j+1] = min(cut[i+j+1], 1+ cut[i-j]);
//            }
//            for (int j = 1; i-j-1 >= 0 && i+j-1 < n && s[i-j+1] == s[i+j]; j++) { // even length palindrome
//                cout << cut[i+j+1] << endl;
//                cout << 1+cut[i-j+1] << endl;
//
//                cut[i+j+1] = min(cut[i+j+1], 1+cut[i-j+1]);
//            }
//        }
//        return cut[n];
//    }

//    int minCut(string s) {
//        int n = s.size();
//        vector<int> cut(n + 1, 0); // number of cuts for the first k characters
//        for (int i = 0; i <= n; i++) {
//            cut[i] = i - 1;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; i - j >= 0 && i + j < n && s[i - j] == s[i + j]; j++) { // odd length palindrom
//                cut[i + j + 1] = min(cut[i + j + 1], 1 + cut[i - j]);
//            }
//            for (int j = 1; i - j + 1 >= 0 && i + j < n && s[i - j + 1] == s[i + j]; j++) { // even length palindrom
//                cut[i + j + 1] = min(cut[i + j + 1], 1 + cut[i - j + 1]);
//            }
//        }
//        return cut[n];
//    }


//    int minCut(string s) {
//        const int n = s.length();
//        // valid[i][j] = 1 if s[i-j] is Palindrome, otherwise 0
//        vector<vector<int>> valid(n, vector<int>(n, 1));
//
//        // dp[i] = min cuts of s[0-i]
//        vector<int> dp(n, n);
//
//        for (int l = 2; l <= n; ++l) {
//            for (int i = 0, j = j + l - 1; j < n; ++i, ++j) {
//                valid[i][j] = s[i] == s[j] && valid[i + 1][j - 1];
//            }
//        }
//        for (int i = 0; i < n; ++i) {
//            if (valid[0][i]) {
//                dp[i] = 0;
//                continue;
//            }
//            for (int j = 0; j < i; ++j) {
//                if (valid[j+1][i]) {
//                    dp[i] = min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[n - 1];
//    }

//    int minCut(string s) {
//        const int n = s.length();
//        vector<int> dp(n, n);
//        for (int m = 0; m < n; ++m) {
//            for (int d = 0; d <= 1; ++d) {
//                for (int i = m, j = m + d; i>= 0 && j < n && s[i] == s[j]; --i, ++j) {
//                    dp[j] = min(dp[j], (i ? dp[i - 1] + 1 : 0));
//                }
//            }
//        }
//        return dp[n - 1];
//    }


    int minCut(string s) {
        int n = s.size();
        vector<int> cut(n + 1, 0); // number of cuts for the first k characters
        for (int i = 0; i <= n; i++) {
            cut[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; i-j >=0 && i+j < n && s[i-j]==s[i+j]; j++) {
                cut[i+j+1] = min(cut[i+j+1], 1+cut[i-j]);
            }
            for (int j = 1; i-j+1 >= 0 && i+j < n && s[i-j+1] == s[i+j]; j++) {
                cut[i+j+1] = min(cut[i+j+1], 1+cut[i-j+1]);
            }
        }
        return cut[n];

    }

};

//int main() {
//    Solution * solution = new Solution();
//    cout <<  solution->minCut("a") << endl;
////    cout << 0 - 1 << endl;
//}

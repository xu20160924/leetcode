//
// Created by John on 2020/2/16.
//

#include <string>
#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int start = 0, end = 0;

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j] && dp[i+1][j-1]) {
                    dp[i][j] = 1;
                    if (i - j > maxLen) {
                        maxLen = i - j + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substr(start, end - start + 1);
    }
//    string longestPalindrome(string s) {
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        int max = INT_MIN;
//        int li = 0;
//        for (int i = 0; i < len; i++) {
//            int len1 = extentPalindrome(s, i, i),
//            len2 = extentPalindrome(s, i, i + 1);
//            if (max < std::max(len1, len2)) {
//                li = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
//                max = std::max(len1, len2);
//            }
//        }
//        return s.substr(li, max);
//    }

private:
    int extentPalindrome(string s, int j, int k) {
//        while (j >= 0 && k < s.length() && s[j] == s[k]) {
//            j--;
//            k++;
//        }
        for (; j >= 0 && j < s.length(); j--, k++) {
            if (s[j] != s[k]) {
                break;
            }
        }
        return k - j - 2 + 1;
    }

//public:
//    string longestPalindrome(string s) {
//        int len = s.size();
//        if (len < 2) {
//            return s;
//        }
//
//        for (int i = 0; i < len - 1; i++) {
//            extendPalindrome(s, i, i);
//            extendPalindrome(s, i, i + 1);
//        }
//        return s.substr(lo, lo + maxLen);
//    }
//
//private:
//    int lo, maxLen;
//
//    void extendPalindrome(string s, int j, int k) {
//        while (j >= 0 && k < s.size() && s[j] == s[k]) {
//            j--;
//            k++;
//        }
//        if (maxLen < k - j - 1) {
//            lo = j + 1;
//            maxLen = k - j - 1;
//        }
//    }
};

int main() {
    string str = "babad";
    Solution *solution = new Solution();
    cout << solution->longestPalindrome(str) << endl;

//    string str = "bb";
//    cout << str.substr(0, 1) << endl;
}
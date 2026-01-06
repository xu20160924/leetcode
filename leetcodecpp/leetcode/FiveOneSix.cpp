//
// Created by caidaoliuhai on 2025/12/11.
//
#include "string"
#include "vector"
#include "iostream"
#include "set"

using namespace std;

class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        stack<char> st;
        set<char> se;
        for (auto c : s) {
            st.push(c);
        }

        int longest = 0;
        char previous;
        int index = n - 1;
        int waitCharIndex = -1;
        while (!st.empty()) {
            char top = st.top();
            st.pop();
            if (se.count(top)) {
                if (top == previous) {
                    longest++;
                } else {
                    if (waitCharIndex != -1 && waitCharIndex > n) {
                        longest++;
                        waitCharIndex = -1;
                    }
                    longest += 2;
                }
                previous = top;
            } else {
                waitCharIndex = n;
            }
            n--;
            se.insert(top);
        }
        return longest;
    }


// 以下牛客网可以过，但是leetcode会超时
// https://www.nowcoder.com/practice/82297b13eebe4a0981dbfa53dfb181fa?tpId=230&tqId=39762&ru=/exam/oj
//public:
//    int longestPalindromeSubseq(string s) {
//        if (s.length() == 1) {
//            return 1;
//        }
//        int n = s.length();
//        int l = 0, r = n - 1;
//        vector<vector<int>> memo(n, vector<int>(n, -1));
//        return maxLongest(s, l, r, memo);
//    }
//
//private:
//    int maxLongest(string s, int l, int r, vector<vector<int>>& memo) {
//        if (l > r) {
//            return 0;
//        }
//        if (memo[l][r] != -1) {
//            return memo[l][r];
//        }
//        if (l < r && s[l] == s[r]) {
//            memo[l][r] = maxLongest(s, l + 1, r - 1, memo) + 2;
//        } else if (l == r && s[l] == s[r]) {
//            memo[l][r] = 1;
//        } else {
//            memo[l][r] = max(maxLongest(s, l + 1, r, memo), maxLongest(s, l, r - 1, memo));
//        }
//        return memo[l][r];
//    }
};

int main() {
    Solution *solution = new Solution();
    string a = "bbbab";
    cout << solution->longestPalindromeSubseq(a) << endl;
}
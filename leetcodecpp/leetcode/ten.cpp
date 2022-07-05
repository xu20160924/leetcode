//
// Created by John on 2020/3/15.
//
#include "string"
#include "vector"
#include "iostream"

using namespace std;

class Solution {
public:
//    bool isMatch(string s, string p) {
//        if (p.empty()) {
//            return s.empty();
//        }
//        bool first_match = (!s.empty() && (s[0] == p[0] || p[0] == '.'));
//        if (p.size() > 2 && p[1] == '*') {
//            return (isMatch(s, p.substr(2)) || (first_match && isMatch(s.substr(1), p)));
//        } else {
//            return first_match &&  (isMatch(s.substr(1), p.substr(1)));
//        }
//    }

//    bool isMatch(string s, string p) {
//        if (p.empty()) {
//            return s.empty();
//        }
//        bool firstMatch = (!s.empty() && (s[0] == p[0] || p[0] == '.'));
//        if (p.size() > 2 && p[1] == '*') {
//            return (isMatch(s, p.substr(2)) || (firstMatch && isMatch(s.substr(1), p)));
//        } else {
//            return firstMatch && (isMatch(s.substr(1), p.substr(1)));
//        }
//    }

//   bool isMatch(string s, string p) {
//        if (s.empty() && p.empty()) {
//            return true;
//        }
//        bool res = false;
//        if (p[0] == '.') {
//            res = isMatch(s.substr(0, 1), p.substr(0, 1));
//        } else if (p[1] == '*') {
//            int i = 0;
//            while (s[0] == p[i++]) {
//                s = s.substr(0, 1);
//            }
//            res = isMatch(s, p.substr(0, 2));
//        } else {
//            if (s[0] != p[0]) {
//                return false;
//            }
//        }
//        return res;
//    }

// recursion
//    bool isMatch(string s, string p) {
//        if (p.empty()) {
//            return s.empty();
//        }
//        bool firstMatch = (!s.empty() && (s[0] == p[0] || p[0] == '.'));
//        if (p.size() >= 2 && p[1] == '*') {
//            return (isMatch(s, p.substr(2)) ||
//                    (firstMatch && isMatch(s.substr(1) , p)));
//        } else {
//            return firstMatch && isMatch(s.substr(1), p.substr(1));
//        }
//    }


/**
 * Top-Down
 * -1 initial value
 * 0 false
 * 1 true
 */
//    vector<vector<int>> memo;
//    bool isMatch(string s, string p) {
//        vector<int> temp(p.size() + 1, -1);
//        memo.resize(s.size() + 1);
//        fill(memo.begin(), memo.end(), temp);
//        return dp(0, 0, s, p);
//    }
//
//    bool dp(int i, int j, string s, string p) {
//        if (memo[i][j] != -1) {
//            return memo[i][j] == 1;
//        }
//        bool ans;
//        if (j == p.size()) {
//            ans = (i == s.size());
//        } else {
//            bool firstMatch = (i < s.size() &&
//                    (s[i] == p[j] || p[j] == '.'));
//            if (j + 1 < p.size() && p[j + 1] == '*') {
//                ans = (dp(i, j + 2, s, p) ||
//                        (firstMatch && dp(i + 1, j, s, p)));
//            } else {
//                ans = firstMatch && dp(i + 1, j + 1, s, p);
//            }
//        }
//        memo[i][j] = (ans ? 1 : 0);
//        return ans;
//    }

/**
 * Bottom-up
 */
//    bool isMatch(string text, string pattern) {
//        bool dp[text.length() + 1][pattern.length() + 1];
//        fill(&dp[0][0], &dp[0][0] + sizeof(dp), false);
//        dp[text.length()][pattern.length()] = true;
//
//        for (int i = text.length(); i >= 0; i--) {
//            for (int j = pattern.length() - 1; j >= 0; j--) {
//                bool firstMatch = (i < text.length() &&
//                                   (pattern[j] == text[i] || pattern[j] == '.'));
//                if (j + 1 < pattern.length() && pattern[j + 1] == '*') {
//                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
//                } else {
//                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
//                }
//            }
//        }
//        return dp[0][0];
//    }

    bool isMatch(string s, string p) {
        bool dp[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
    }
};

//int main() {
//    bool testb[3][3];
//    int test[2][3] = {1};
//    int test2[2][3];
//    int a;
//    bool b;
//    string str = "mississippi";
//    Solution *solution = new Solution();
//    cout << solution->isMatch(str, "mis*is*p*.") << endl;

//    int arr[] = {10, 20, 30};
//    cout << sizeof(arr) << endl;
//    cout << sizeof(arr[0]) << endl;
//    int n = sizeof(arr) / sizeof(arr[0]);
//    cout << arr << endl;
//    auto temp = arr + n;
//    vector<int> vect(arr, arr + n);
//    for (int x : vect) {
//        cout << x << " ";
//    }
//    cout << "test" << endl;
//}
/**
 *
 * Example 1:


Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any cha
 *
 * @return
 */


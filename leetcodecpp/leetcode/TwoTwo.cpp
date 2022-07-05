//
// Created by John on 2020/3/2.
//

#include "string"
#include "vector"

using namespace std;

class Solution{
public:
//    vector<string> generateParenthesis(int n) {
//        vector<string> res;
//        backtrack(res, "", 0, 0, n);
//        return res;
//    }
//
//    void backtrack(vector<string> & res, string cur, int left, int right, int max) {
//        if (cur.size() >= max * 2) {
//            res.push_back(cur);
//            return;
//        }
//        if (left < max) {
//            backtrack(res, cur+"(", left + 1, right, max);
//        }
//        if (right < left) {
//            backtrack(res, cur+")", left, right + 1, max);
//        }
//    }


//    void backtrack(vector<string>& res, string s, int left, int right, int max) {
//        if (s.size() >= max * 2) {
//            res.push_back(s);
//            return;
//        }
//        if (left < max) {
//            backtrack(res, s + "(", left + 1, right, max);
//        }
//        if (right < left) {
//            backtrack(res, s + ")", left, right + 1, max);
//        }
//    }
//
//    vector<string> generateParenthesis(int n) {
//        vector<string> res;
//        backtrack(res, "", 0, 0, n);
//        return res;
//    }

//    vector<string> generateParenthesis(int n) {
//        vector<string> res;
//        if (!n) {
//            return res;
//        } else {
//            for (int c = 0; c < n; ++c) {
//                for (string left : generateParenthesis(c)) {
//                    for (string right : generateParenthesis(n - 1 - c)) {
//                        res.push_back("(" + left + ")" + right);
//                    }
//                }
//            }
//        }
//        return res;
//    }

    vector<string> generateParenthesis(int n) {
        vector<vector<string>> dp;
        dp.push_back({""});

        for (int i = 1; i <= n; i++) {
            vector<string> temp;
            for (int j = 0; j < i; j++) {
                for (string first : dp[j]) {
                    for (string second : dp[i - j - 1]) {
                        temp.push_back("(" + first + ")" + second);
                    }
                }
            }
            dp.push_back(temp);
        }
        return dp[dp.size() - 1];
    }
};

int main() {
    Solution* solution = new Solution();
    vector<string> res =  solution->generateParenthesis(3);
}
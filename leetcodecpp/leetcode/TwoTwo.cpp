//
// Created by John on 2020/3/2.
//

#include "string"
#include "vector"

using namespace std;

class Solution{
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        backtrack(res, "", 0, 0, n);
        return res;
    }

    void backtrack(vector<string> & res, string cur, int left, int right, int max) {
        if (cur.size() >= max * 2) {
            res.push_back(cur);
            return;
        }
        if (left < max) {
            backtrack(res, cur+"(", left + 1, right, max);
        }
        if (right < left) {
            backtrack(res, cur+")", left, right + 1, max);
        }
    }
};

//int main() {
//    Solution * solution = new Solution();
//    vector<string> res =  solution->generateParenthesis(2);
//}
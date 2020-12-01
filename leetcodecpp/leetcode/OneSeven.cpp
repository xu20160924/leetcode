//
// Created by John on 2020/3/5.
//
#include "map"
#include "unordered_map"
#include "string"
#include "vector"

using namespace std;

class Solution{

public:

    Solution() {
        phone["2"] = "abc";
        phone["3"] = "def";
        phone["4"] = "ghi";
        phone["5"] = "jkl";
        phone["6"] = "mno";
        phone["7"] = "pqrs";
        phone["8"] = "tuv";
        phone["9"] = "wxyz";
    }
    ~Solution(){

    }

    unordered_map<string, string> phone;
    vector<string> res;
    vector<string> letterCombinations(string digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return res;
    }

    void backtrack(string combination, string next_digits) {
        if (next_digits.size() == 0) {
            res.push_back(combination);
        } else {
            string digit = next_digits.substr(0, 1);
            string letters = phone[digit];
            for (int i = 0; i < letters.size(); ++i) {
                string letter = phone[digit].substr(i,  1);
                backtrack(combination + letter, next_digits.substr(1));
            }
        }
    }
};

//int main() {
//    Solution * solution = new Solution();
//    vector<string> res = solution->letterCombinations("23");
//}
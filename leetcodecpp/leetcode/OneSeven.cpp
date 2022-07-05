//
// Created by John on 2020/3/5.
//
#include "map"
#include "unordered_map"
#include "string"
#include "vector"
#include "iostream"
#include "queue"

using namespace std;

class Solution{

public:

    unordered_map<string, string> phone = {
            {"2", "abc"},
            {"3", "def"},
            {"4", "ghi"},
            {"5", "jkl"},
            {"6", "mno"},
            {"7", "qprs"},
            {"8", "tuv"},
            {"9", "wxyz"}
    };
//    Solution() {
//        phone["2"] = "abc";
//        phone["3"] = "def";
//        phone["4"] = "ghi";
//        phone["5"] = "jkl";
//        phone["6"] = "mno";
//        phone["7"] = "pqrs";
//        phone["8"] = "tuv";
//        phone["9"] = "wxyz";
//    }
//    ~Solution(){
//
//    }
//
//    unordered_map<string, string> phone;
//    vector<string> res;
//    vector<string> letterCombinations(string digits) {
//        if (digits.length() != 0) {
//            backtrack("", digits);
//        }
//        return res;
//    }
//
//    void backtrack(string combination, string next_digits) {
//        if (next_digits.size() == 0) {
//            res.push_back(combination);
//        } else {
//            string digit = next_digits.substr(0, 1);
//            string letters = phone[digit];
//            for (int i = 0; i < letters.size(); ++i) {
//                string letter = phone[digit].substr(i,  1);
//                backtrack(combination + letter, next_digits.substr(1));
//            }
//        }
//    }

//    vector<string> res;
//    void backtrack(string combination, string next_digits) {
//        if (next_digits.size() == 0) {
//            res.push_back(combination);
//        } else {
//            string digit = next_digits.substr(0, 1);
//            string letters = phone[digit];
//            for (int i = 0; i < letters.size(); ++i) {
//                string letter = phone[digit].substr(i, 1);
//                backtrack(combination + letter, next_digits.substr(1));
//            }
//        }
//    }
//
//    vector<string> letterCombinations(string digits) {
//        if (digits.size() > 1) {
//            backtrack("", digits);
//            return res;
//        }
//        return {};
//    }

    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if (digits.empty()) {
            return ans;
        }
        string mapping[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.push_back("");
        while (ans.front().length() != digits.length()) {
            string tmp = ans.front();
            ans.erase(ans.begin());

            string letter = mapping[digits[tmp.length()] - '0'];
            for (char c : letter) {
                ans.push_back(tmp + c);
            }
        }
        return ans;
    }
};

int main() {
    Solution * solution = new Solution();
    vector<string> res = solution->letterCombinations("23");
    for (vector<string>::iterator it = res.begin(); it != res.end(); ++it) {
        cout << "\t" << *it;
    }
//    string a = "123";
//    cout << a.substr(1) << endl;
}
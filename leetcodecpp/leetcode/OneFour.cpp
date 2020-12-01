//
// Created by John on 2020/3/5.
//
#include "string"
#include "vector"

using namespace std;

class Solution {
public:
//    string longestCommonPrefix(vector<string> &strs) {
//        if (strs.size() == 0) {
//            return "";
//        }
//        string prefix = strs[0];
//        for (int i = 1; i < strs.size(); i++) {
//            while (strs[i].find(prefix) != 0) {
//                prefix = prefix.substr(0, prefix.size() - 1);
//                if (prefix.empty()) {
//                    return "";
//                }
//            }
//        }
//        return prefix;
//    }
    string longestCommonPrefix(vector<string> & strs) {
        if (strs.size() == 0) {
            return "";
        }
        string pre = strs[0];
        for (int i = 1; i < strs.size(); i++) {
            while (strs[i].find(pre)) {
                pre = pre.substr(0, pre.size() - 1);
            }
        }
        return pre;
    }

};

//int main() {
//    vector<string> strs;
//    strs.push_back("flower");
//    strs.push_back("flow");
//    strs.push_back("flight");
//    Solution * solution = new Solution();
//    solution->longestCommonPrefix(strs);
//}
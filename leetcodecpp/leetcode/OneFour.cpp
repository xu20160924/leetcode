//
// Created by John on 2020/3/5.
//
#include "string"
#include "vector"
#include "iostream"

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


//    string longestCommonPrefix(vector<string> & strs) {
//        if (strs.size() == 0) {
//            return "";
//        }
//        string pre = strs[0];
//        for (int i = 1; i < strs.size(); i++) {
//            while (strs[i].find(pre)) {
//                pre = pre.substr(0, pre.size() - 1);
//            }
//        }
//        return pre;
//    }

//        string longestCommonPrefix(vector<string>& strs) {
//            if (strs.size() == 0) {
//                return "";
//            }
//            string prefix = strs[0];
//            for (int i = 1; i < strs.size(); i++) {
//                while (strs[i].find(prefix)) {
//                    prefix = prefix.substr(0, prefix.size() - 1);
//                    if (prefix.empty()) {
//                        return "";
//                    }
//                }
//            }
//            return prefix;
//        }

//    string longestCommonPrefix(vector<string>& strs) {
//        if (strs.size() == 0) {
//            return "";
//        }
//        for (int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0][i];
//            for (int j = 1; j < strs.size(); j++) {
//                if (i == strs[j].length() || strs[j][i] != c) {
//                    return strs[0].substr(0, i);
//                }
//            }
//        }
//        return strs[0];
//    }


    /**
     * divide and conquer
     * @param strs
     * @return
     */
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.size() - 1);
    }

    string longestCommonPrefix(vector<string>& strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            string lcpLeft = longestCommonPrefix(strs, l, mid);
            string lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    string commonPrefix(string left, string right) {
        int min = std::min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left[i] != right[i]) {
                return left.substr(0, i);
            }
        }
        return left.substr(0, min);
    }



//    string longestCommonPrefix(vector<string> & strs) {
//        if (strs.size() < 1) {
//            return "";
//        }
//        string res = "";
//        for (int i = 0; i < INT_MAX; i++) {
//            if (strs[0][i] == '\0') {
//                return res;
//            }
//            char c = strs[0][i];
//            char c2 = strs[0][i];
//            for (int j = 0; j < strs.size(); j++) {
//                if (strs[j].empty()) {
//                    return "";
//                }
//                c &= strs[j][i];
//            }
//            if (c == c2) {
//                res.push_back(c2);
//            } else {
//                return res;
//            }
//        }
//    }

    void g(int& y) {
        cout << y;
        cout << typeid(y).name();
        y++;
    }

    void f(int& x) {
        g(x);
    }
};

int main() {
    //["flower","flow","flight"]

    vector<string> strs;
    strs.push_back("flower");
    strs.push_back("flow");
    strs.push_back("flight");

//    strs.push_back("flower");
//    strs.push_back("flower");
//    strs.push_back("flower");
//    strs.push_back("flow");
//    strs.push_back("flight");

    Solution * solution = new Solution();
    cout << solution->longestCommonPrefix(strs) << endl;

//    Solution* solution = new Solution();
//    int a = 34;
//    solution->f(a);
//    return 0;
}

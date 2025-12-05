//
// Created by John on 2022/5/25.
//

#include "string"
#include "ctype.h"
#include "iostream"

using namespace std;

class Solution{
public:
//    bool isPalindrome(string s) {
//        if (s.size() < 2) {
//            return true;
//        }
//        int i = 0;
//        int j = s.size();
//        while ((j - i) > 2) {
//            if (s[i] != s[j]) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    bool isPalindrome(string s) {
//        if (s.empty()) {
//            return true;
//        }
//        int i = 0;
//        int j = s.length() - 1;
//        while (i <= j) {
//            if (!(isalpha(s[i]) || isdigit(s[i]))) {
//                i++;
//            } else if (!(isalpha(s[j]) || isdigit(s[j]))) {
//                j--;
//            } else {
//                if (tolower(s[i]) != tolower(s[j])) {
//                    return false;
//                }
//                i++;
//                j--;
//            }
//        }
//        return true;
//    }

    // bool isPalindrome(string s) {
    //     for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
    //         while (!isalnum(s[i]) && i < j) {
    //             i++;
    //         }
    //         while (!isalnum(s[j]) && i < j) {
    //             j--;
    //         }
    //         if (tolower(s[i]) != tolower(s[j])) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    bool isPalindrome(string s) {
        int l = 0;
        int r = s.size() - 1;
        return valid(s, l, r);
    }

    bool valid(string& s, int l, int r) {
        while (l < r && !isalnum(s[l])) {
            l++;
        }
        while (l < r && !isalnum(s[r])) {
            r--;
        }

        if (l >= r) {
            return true;
        }

        if (tolower(s[l]) != tolower(s[r])) {
            return false;
        }

        return valid(s, l + 1, r - 1);
    }

};

int main() {
    Solution* solution = new Solution();
    cout << solution->isPalindrome("A man, a plan, a canal: Panama") << endl;
}
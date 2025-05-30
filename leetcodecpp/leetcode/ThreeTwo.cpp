#include <ios>
#include <string>
//
// Created by John on 2025/5/20.
//

#include <iostream>

using namespace std;

class Solution {
public:
    // int longestValidParenthese(string s) {
    //     int maxLen = 0;
    //     int currentLen = 0;
    //     int rightCount = 0;
    //     int leftCount = 0;
    //     for (char c : s) {
    //         if (c == ')') {
    //             rightCount++;
    //         }
    //
    //
    //         if (rightCount > leftCount) {
    //             leftCount = 0;
    //             rightCount = 0;
    //             currentLen = 0;
    //             continue;
    //         }
    //
    //         if (c == '(') {
    //             leftCount++;
    //         }
    //
    //         currentLen += min(leftCount, rightCount) * 2;
    //         maxLen = max(maxLen, currentLen);
    //         if (leftCount != 0 && leftCount == rightCount) {
    //             leftCount = 0;
    //             rightCount = 0;
    //             currentLen = 0;
    //         }
    //     }
    //
    //
    //     return maxLen;
    // }

    // int longestValidParenthese(string s) {
    //     int n = s.length(), longest = 0;
    //     stack<int> st;
    //     for (int i = 0; i < n; i++) {
    //         if (s[i] == '(') {
    //             st.push(i);
    //         } else {
    //             if (!st.empty()) {
    //                 if (s[st.top()] == '(') {
    //                     st.pop();
    //                 } else {
    //                     st.push(i);
    //                 }
    //             } else {
    //                 st.push(i);
    //             }
    //         }
    //     }
    //
    //     if (st.empty()) {
    //         longest = 0;
    //     } else {
    //        int a = n, b = 0;
    //         while (!st.empty()) {
    //             b = st.top; st.pop();
    //             longest = max(longest, a - b -1);
    //             a = b;
    //         }
    //         longest = max(longest, a);
    //     }
    //     return longest;
    // }


    int longestValidParenthese(string s) {
        int left = 0, right = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = max(maxLength, 2* right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s[i] == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = max(maxLength, 2* right);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLength;
    }

};

int main(int argc, char *argv[]) {
    Solution solution;
    cout << solution.longestValidParenthese(")()())") << endl;
}

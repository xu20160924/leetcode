//
// Created by John on 2020/2/16.
//

#include "Five.h"
#include <string>
#include <iostream>
#include <vector>

using namespace std;


class Solution{
//private:
//    string centerSpread(string s, int left, int right) {
//        int size = s.size();
//        int i = left;
//        int j = right;
//        while (i >= 0 && j < size) {
//            if (s[i] == s[j]) {
//                i--;
//                j++;
//            } else {
//                break;
//            }
//        }
//        return s.substr(i+1, j - i - 1);
//    }
//
//public:
//    string longestPalindrome(string s) {
//        int size = s.size();
//        if (size < 2) {
//            return s;
//        }
//        int maxLen = 1;
//        string res = s.substr(0,1);
//        for (int i = 0; i < size - 1; i++) {
//            string oddStr = centerSpread(s, i , i);
//            string evenStr = centerSpread(s, i, i+1);
//            string maxLenStr = oddStr.size() > evenStr.size() ? oddStr: evenStr;
//            if (maxLenStr.length() > maxLen) {
//                maxLen = maxLenStr.size();
//                res = maxLenStr;
//            }
//        }
//        return res;
//    }
//public:
//    string longestPalindrome(string s) {
//        int size = s.size();
//        if (size < 2) {
//            return s;
//        }
//        string res = "";
//        for (int i = 0; i < size; i++) {
//            string odd = valid(s, i, i);
//            string even = valid(s, i, i+1);
//            string maxLenStr = odd.size() > even.size() ? odd : even;
//            if (maxLenStr.size() > res.size()) {
//                res = maxLenStr;
//            }
//        }
//        return res;
//    }
//private:
//    string valid(string s, int left, int right) {
//        int size = s.size();
//        int i = left, j = right;
//        while (i >= 0 && j < size && s[i] == s[j]) {
//            i--;
//            j++;
//        }
//        return s.substr(i + 1, j - i - 1);
//    }

//private:
//    int centerSpread(string s, int center) {
//        int len = s.size();
//        int i = center - 1;
//        int j = center + 1;
//        int step = 0;
//        while (i >= 0 && j < len && s[i] == s[j]) {
//            i--;
//            j++;
//            step++;
//        }
//        return step;
//    }
//
//public:
//    string longestPalindrome(string s) {
//        int size = s.size();
//        if (size < 2) {
//            return s;
//        }
//        string str = "#";
//        for (int i = 0; i < s.size(); ++i) {
//            str += s[i];
//            str += "#";
//        }
//        int sSize = 2 * size + 1;
//        int maxLen = 1;
//        int start = 0;
//        for (int i = 0; i < sSize; i++) {
//            int curLen = centerSpread(str, i);
//            if (curLen > maxLen) {
//                maxLen = curLen;
//                start = (i - maxLen) / 2;
//            }
//        }
//        return s.substr(start, maxLen);
//    }
public:
    string longestPalindrome(string s) {
        int size = s.size();
        if (size < 2) {
            return s;
        }

        //pre process
        string str = "#";
        for (int i = 0; i < size; i++) {
            str +=s[i];
            str += "#";
        }

        // the new string's size
        int strSize = size * 2 + 1;
        vector<int> p(strSize, 0);

        int maxRight = 0;
        int center = 0;

        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < strSize; i++) {
            if (i < maxRight) {
                int mirror = (2 * center) - i;
                p[i] = min(maxRight - i, p[mirror]);
            }
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);
            while (left >= 0 && right <= strSize && str[left] == str[right]) {
                p[i]++;
                left--;
                right++;
            }

            if (i + p[i] > maxRight) {
                maxRight = i + p[i];
                center = i;
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substr(start, maxLen);
    }

};

//int main(){
//    string str = "abab";
//    Solution *solution = new Solution();
//    cout << solution->longestPalindrome(str) << endl;
//}
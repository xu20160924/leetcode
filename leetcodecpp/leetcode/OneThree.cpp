//
// Created by John on 2022/5/21.
//
#include "string"
#include "unordered_map"
#include "iostream"

using namespace std;

class Solution {
public:
    // static int romanToInt(string s) {
    //     unordered_map<int, int> roman = {
    //             {'I',  1},
    //             {'V',  5},
    //             {'X',  10},
    //             {'L',  50},
    //             {'C',  100},
    //             {'D',  500},
    //             {'M',  1000},
    //             {'I' - 'V', 4},
    //             {'I' - 'X', 9},
    //             {'X' - 'L', 40},
    //             {'X' - 'C', 90},
    //             {'C' - 'D', 400},
    //             {'C' - 'M', 900}
    //     };
    //     int res = 0;
    //     for (int i = s.size() - 1; i >= 0; i--) {
    //         if (i > 0 && roman.count(s[i - 1] - s[i])) {
    //             res += roman[s[i - 1] - s[i]];
    //             i--;
    //             continue;
    //         } else {
    //             res += roman[s[i]];
    //         }
    //     }
    //     return res;
    // }


    // int romanToInt(string s) {
    //
    //     int res = 0;
    //     int totalSize = s.size();
    //     for (int i = 0; i < s.size(); i++) {
    //         char ch = s[i];
    //         int remain = totalSize - i;
    //         switch (ch) {
    //             case 'I':
    //                 if (remain >= 2 && s[i+1] == 'V') {
    //                     i++;
    //                     res += 4;
    //                 } else if (remain >= 2 && s[i+1] == 'X') {
    //                     i++;
    //                     res += 9;
    //                 } else {
    //                     res++;
    //                 }
    //                 break;
    //             case 'V':
    //                 res += 5;
    //                 break;
    //             case 'X':
    //                 if (remain >= 2 && s[i+1] == 'L') {
    //                     i++;
    //                     res += 40;
    //                 } else if (remain >= 2 && s[i+1] == 'C') {
    //                     i++;
    //                     res += 90;
    //                 } else {
    //                     res += 10;
    //                 }
    //                 break;
    //             case 'L':
    //                 res += 50;
    //                 break;
    //             case 'C':
    //                 if (remain >= 2 && s[i+1] == 'D') {
    //                     i++;
    //                     res += 400;
    //                 } else if (remain >= 2 && s[i+1] == 'M') {
    //                     i++;
    //                     res += 900;
    //                 } else {
    //                     res += 100;
    //                 }
    //                 break;
    //             case 'D':
    //                 res += 500;
    //                 break;
    //             case 'M':
    //                 res += 1000;
    //                 break;
    //         }
    //     }
    //     return res;
    // }


    int romanToInt(string s) {
        int res = 0;
        unordered_map<char, int> roman = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        for (int i = 0; i < s.size(); i++) {
            if (i <  s.size() - 1 && roman[s[i]] < roman[s[i + 1]]) {
                res -= roman[s[i]];
            } else {
                res += roman[s[i]];
            }
        }

        return res;
    }
};

int main() {
    // cout << Solution::romanToInt("LVIII") << endl;
    Solution* solution = new Solution();
    cout << solution->romanToInt("III") << endl;
//    unordered_map<int, int> roman = {
//            {'I',  1},
//            {'V',  5},
//            {'X',  10},
//            {'L',  50},
//            {'C',  100},
//            {'D',  500},
//            {'M',  1000},
//            {'I' + 'V', 4},
//            {'I' + 'X', 9},
//            {'X' + 'L', 40},
//            {'X' + 'C', 90},
//            {'C' + 'D', 400},
//            {'C' + 'M', 900}
//    };
//    cout << roman['V' + 'I'] << endl;
//    string a = "IV";
//    string c = "" + a[1 - 1];
//    cout << c << endl;
//    cout << a[1] << endl;
}
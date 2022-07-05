//
// Created by John on 2022/5/21.
//
#include "string"
#include "unordered_map"
#include "iostream"

using namespace std;

class Solution {
public:
    static int romanToInt(string s) {
        unordered_map<int, int> roman = {
                {'I',  1},
                {'V',  5},
                {'X',  10},
                {'L',  50},
                {'C',  100},
                {'D',  500},
                {'M',  1000},
                {'I' - 'V', 4},
                {'I' - 'X', 9},
                {'X' - 'L', 40},
                {'X' - 'C', 90},
                {'C' - 'D', 400},
                {'C' - 'M', 900}
        };
        int res = 0;
        for (int i = s.size() - 1; i >= 0; i--) {
            if (i > 0 && roman.count(s[i - 1] - s[i])) {
                res += roman[s[i - 1] - s[i]];
                i--;
                continue;
            } else {
                res += roman[s[i]];
            }
        }
        return res;
    }

};

int main() {
    cout << Solution::romanToInt("LVIII") << endl;

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
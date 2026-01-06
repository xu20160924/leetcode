//
// Created by John on 2020/4/11.
//

#include "vector"
#include "iostream"

using namespace std;

class Solution{
public:
    string convert(string s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }

        int t = numRows * 2 - 2;
        vector<string> v(numRows, "");
        string res;
        int ct = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n - i; j += t) {
                res += s[j + i];
                if (0 < i < numRows - 1 && j + t - i < numRows) {
                    res += s[j + t - i];
                }
            }
        }

        return res;
    }





//    string convert(string s, int numRows) {
//
//        int n = s.length();
//        if (numRows == 1 || numRows >= n) {
//            return s;
//        }
//        int t = numRows * 2 - 2;
//        vector<vector<char>> v(numRows, vector<char>((n + t - 1) / t * (numRows - 1), '\0'));
//
//        int x = 0, y = 0;
//        for (int i = 0; i < s.length(); i++) {
//            v[x][y] = s[i];
//            if (i % t < (numRows - 1)) {
//                x++;
//            } else {
//                x--;
//                y++;
//            }
//        }
//
//        string res;
//        for (vector<char> vl : v) {
//            for (char c : vl) {
//                if (c != '\0') {
//                    res.push_back(c);
//                }
//            }
//        }
//        return res;
//    }
};

int main() {
    Solution *solution = new Solution();
    // PAHNAPLSIIGYIR
    cout << solution->convert("PAYPALISHIRING", 3) << endl;
}

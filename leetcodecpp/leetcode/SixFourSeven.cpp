//
// Created by John on 2022/5/25.
//
#include "string"
#include "iostream"

using namespace std;

class Solution {
public:
    int countSubstrings(string s) {
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            count += countSubstrings(s, i, i);
            count += countSubstrings(s, i, i + 1);
        }
        return count;
    }

    int countSubstrings(string s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s[i] == s[j]) {
            count++;
            i--;
            j++;
        }
        return count;
    }
};

int main() {
    Solution* solution = new Solution();
    cout << solution->countSubstrings("aabca") << endl;
}
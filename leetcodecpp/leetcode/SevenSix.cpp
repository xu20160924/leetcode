//
// Created by John on 2020/1/23.
//

#include "SevenSix.h"
#include "string"
#include "unordered_map"
using namespace std;

class Solution {
public:
    static string minWindow(string s, string t) {
        // record smallest sub string's start and end
        int start = 0, minLen = INT8_MAX;
        // left and right pointer
        int left = 0, right = 0;
        string res = s;

        // like two counter
        unordered_map<char, int> window;
        unordered_map<char, int> needs;

        for (char c : t) {
            needs[c]++;
        }

        // record how many char that have meet the requirement
        int match = 0;
        while (right < s.size()) {
            char c1 = s[right];
            if (needs.count(c1)) {
                window[c1]++;
                if (window[c1] == needs[c1]) {
                    match++;
                }
            }
            right++;
            while (match == needs.size()) {
                if (right - left < minLen) {
                    // update smallest substring's position and length
                    start = left;
                    minLen = right - left;
                }
                char c2 = s[left];
                if (needs.count(c2)) {
                    window[c2]--;
                    if (window[c2] < needs[c2]) {
                        match--;
                    }
                }
            }
            left++;
        }
        return minLen == INT8_MAX ? "" : s.substr(start, minLen);
    }

};

//int main() {
//    string s = "ADOBECODEBANC";
//    string t = "ABC";
//    Solution::minWindow(s, t);
//}
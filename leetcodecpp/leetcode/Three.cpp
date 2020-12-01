//
// Created by John on 2020/1/23.
//

#include "Three.h"
#include "unordered_map"
#include "string"

using namespace std;

class Solution {
public:
    static int lengthOfLongestSubstring(string s) {
        int left = 0, right = 0;
        unordered_map<char, int> window;
        int res = 0;

        while (right < s.size()) {
            char c1 = s[right];
            window[c1]++;
            right++;
            while (window[c1] > 1) {
                char c2 = s[left];
                window[c2]--;
                left++;
            }
            res = max(res, right - left);
        }
        return res;
    }
};

//int main () {
//    string input = "abcabcbb";
//    Solution::lengthOfLongestSubstring(input);
//};
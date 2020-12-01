//
// Created by John on 2020/1/23.
//

#include <iostream>
#include "FourThreeEight.h"
#include "vector"
#include "string"
#include "unordered_map"

using namespace std;

class Solution {
public:
    static vector<int> findAnagrams(string s, string t) {
        vector<int> res;
        int left = 0, right = 0;

        unordered_map<char, int> needs;
        unordered_map<char, int> window;
        for (char c : t) {
            needs[c]++;
        }
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
                if (right - left == t.size()) {
                    res.push_back(left);
                }
                char c2 = s[left];
                if (needs.count(c2)) {
                    window[c2]--;
                    if (window[c2] < needs[c2]) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }
//    void print(std::vector<int> const &input)
//    {
//        for (int i = 0; i < input.size(); i++) {
//            std::cout << input.at(i) << ' ';
//        }
//    }
};
//int main() {
//    string s = "cbaebabacd";
//    string p = "abc";
//    vector<int> res =  Solution::findAnagrams(s, p);
////    std::cout <<  << std::endl;
//    //    print(res);
//}


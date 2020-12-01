
//
// Created by John on 2020/3/2.
//
#include <string>
#include <iostream>
#include <unordered_map>
#include "vector"

using namespace std;
class Solution{
//public:
//    vector<vector<string> > groupAnagrams(vector<string> & strs) {
//        vector<vector<string> > res(strs.size());
//        hash<string> hs;
//        for (string s : strs) {
//            cout << hs(s) << endl;
//            res[hs(s) % strs.size()].push_back(s);
//
////            if (res[hs(s) % strs.size()].empty()) {
////                vector<string> group;
////                group.push_back(s);
////                res.push_back(group);
////            } else {
////            }
//        }
//        return res;
//    }

public:
//    vector<vector<string> > groupAnagrams(vector<string> & strs) {
//        unordered_map<string, vector<string> > mp;
//        for (string s : strs) {
//            string t = s;
//            sort(t.begin(), t.end());
//            mp[t].push_back(s);
//        }
//        vector<vector<string> > anagrams;
//        for (auto p : mp) {
//            anagrams.push_back(p.second);
//        }
//        return anagrams;
//    }

    //using counting sort
//    vector<vector<string> > groupAnagrams(vector<string> & strs) {
//        unordered_map<string, vector<string> > mp;
//        for (string s : strs) {
//            mp[strSort(s)].push_back(s);
//        }
//        vector<vector<string> > anagrams;
//        for (auto p : mp) {
//            anagrams.push_back(p.second);
//        }
//        return anagrams;
//    }
//
//    string strSort(string s) {
//        int counter[26] = {0};
//        for (char c : s) {
//            counter[c - 'a']++;
//        }
//        string t;
//        for (int c = 0; c < 26; c++) {
//            t += string(counter[c], c + 'a');
//        }
//        return t;
//    }
//
//    string sortLowercase(string s) {
//        int charExist[26] = {0};
//        for (int i = 0 ; i < s.size(); i++) {
//            charExist[s[i] - 'a']++;
//        }
//        string res;
//        int j = 0;
//        while (j < 26) {
//            if (charExist[j] == 0) {
//                j++;
//            } else {
//                res.push_back(j + 'a');
//                charExist[j]--;
//            }
//        }
//        return res;
//    }
//
//    string strSort(string & s) {
//        int count[26] = {0}, n = s.length();
//        for (int i = 0; i < n; i++) {
//            count[s[i] - 'a']++;
//        }
//        int p = 0;
//        string t(n, 'a');
//        for (int j = 0; j < 26; j++) {
//            for (int i = 0; i < count[j]; i++) {
//                t[p++] += j;
//            }
//        }
//        return t;
//    }
};
//int main() {
////    vector<string> strs;
////    strs.push_back("eat");
////    strs.push_back("tea");
////    strs.push_back("tan");
////    strs.push_back("ate");
////    strs.push_back("nat");
////    strs.push_back("bat");
////
////    Solution * solution = new Solution();
////    solution->groupAnagrams(strs);
//    string a = "eat";
//    cout << (int)a << endl;
//}
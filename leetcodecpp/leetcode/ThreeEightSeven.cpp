//
// Created by caidaoliuhai on 2022/10/26.
//
#include "string"
#include "map"
#include "unordered_map"
#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution {
public:
//    int firstUniqChar(string s) {
//        unordered_map<char, int> m;
//        for (char& c: s) {
//            m[c]++;
//        }
//        for (int i = 0; i < s.size(); i++) {
//            if (m[s[i]] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    int firstUniqChar(str`ing s) {
//        unordered_map<char, pair<int, int>> m;
//        int idx = s.size();
//        for (int i = 0; i < idx; i++) {
//            m[s`[i]].first++;
//            m[s[i]].second = i;
//        }
//        for (const auto& [c, p] : m) {
//            if (p.first == 1) {
//                idx = min(idx, p.second);
//            }
//        }
//        return idx == s.size() ? -1 : idx;
//    }

    int firstUniqChar(string s) {
        int* countMap = new int[s.size()]();
        memset(countMap, 0,  sizeof(countMap));
        int size = s.size();
        for (int i = 0; i < size; i++) {
//            cout << abs((s[i] - 'a') % size) << endl;
            countMap[abs((s[i] - 'a') % size)]++;
        }
        for (int i = 0; i < size; i++) {
            cout << abs((s[i] - 'a') % size) << endl;
            if (countMap[abs((s[i] - 'a') % size)] == 1) {
                return i;
            }
        }
        delete[] countMap;
        return -1;
    }
};

int main() {
//    Solution* solution = new Solution();
//    string s = "loveleetcode";
//    solution->firstUniqChar(s);


    Solution* solution = new Solution();
    string s = "leetcode";
    cout << solution->firstUniqChar(s) << endl;

//    int* test = new int[26];
//    memset(test, 0, sizeof *test * 26);
//    fill_n(test, 26, 0);

//    int* p = new int[10];
//    std::memset(p, 3, sizeof(p));


//    unordered_map<string, string> obj;
//    obj.insert({"1", "1"});
//    obj.insert({"2", "2"});
//    obj.insert({"3", "3"});
//    obj.insert({"4", "4"});
//    cout << "tt" << endl;

}
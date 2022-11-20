//
// Created by caidaoliuhai on 2022/8/31.
//
#include "vector"
#include "string"
#include "map"
#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution {
public:


    vector<int> findSubstring(string s, vector<string>& words) {
        int n = s.length();
        k = words.size();
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (string word : words) {
//            wordCount.insert(pair<string, int>(word, ));
//            wordCount.emplace(word, 0)
            wordCount[word] = wordCount[word] + 1;
        }

        vector<int> res;
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                res.push_back(i);
            }
        }
        return res;
    }

    bool check(int i, string s) {
        map<string, int> remaining = wordCount;
        int wordsUsed = 0;

        for (int j = i; j < i + substringSize; j += wordLength) {
            string sub = s.substr(j, wordLength);
            if (remaining.count(sub) && remaining.at(sub) != 0) {
                remaining[sub] = remaining[sub] - 1;
                wordsUsed++;
            } else {
                break;
            }
        }
        return wordsUsed == k;
    }

private:
    map<string, int> wordCount;
    int wordLength;
    int substringSize;
    int k;
};

//int main() {
////    "barfoothefoobarman"
////    ["foo","bar"]
//
////    vector<string> words = {"foo", "bar"};
////    vector<string> words;
////    Solution *solution = new Solution();
////    vector<int> res = solution->findSubstring("barfoothefoobarman", words);
//}
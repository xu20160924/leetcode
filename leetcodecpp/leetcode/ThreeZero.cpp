//
// Created by caidaoliuhai on 2022/9/7.
//
#include "../algorithm/LeetCodeInterview.h"


using namespace std;

class Solution {
private:
    unordered_map<string, int> wordCount;
    int n;
    int wordLength;
    int substringSize;
    int k;

    void slidingWindow(int left, string s, vector<int>* res) {
        unordered_map<string, int> wordsFound;
        int wordUsed = 0;
        bool excessWord = false;

        for (int right = left; right <= n - substringSize; right += wordLength) {
            string sub = s.substr(right, wordLength);
            if (wordCount.count(sub) > 0) {
                while (right - left == substringSize || excessWord) {
                    string leftString = s.substr(left, wordLength);
                    left += wordLength;
                    wordsFound[leftString] = wordsFound[leftString] - 1;

                    if (wordsFound[leftString] == wordCount[leftString]) {
                        excessWord = false;
                    } else {
                        wordUsed--;
                    }
                }

                wordsFound[sub] = wordsFound[sub] + 1;
                if (wordsFound[sub] <= wordCount[sub]) {
                    wordUsed++;
                } else {
                    excessWord = true;
                }
                if (wordUsed == k && !excessWord) {
                    res->push_back(left);
                }
            } else {
                wordsFound.clear();
                wordUsed = 0;
                excessWord = false;
                left = right + wordLength;
            }
            if ((right + wordLength) == n - substringSize) {
                cout << "" << endl;
            }
        }
    }
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        n = s.length();
        wordLength = words[0].length();
        k = words.size();
        substringSize = wordLength * k;

        for (string word : words) {
            wordCount[word] = wordCount[word] + 1;
        }

        vector<int> res;
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, &res);
        }
        return res;
    }

//    vector<int> findSubstring(string s, vector<string>& words) {
//        int n = s.length();
//        k = words.size();
//        wordLength = words[0].length();
//        substringSize = wordLength * k;
//
//        for (string word : words) {
////            wordCount.insert(pair<string, int>(word, ));
////            wordCount.emplace(word, 0)
//            wordCount[word] = wordCount[word] + 1;
//        }
//
//        vector<int> res;
//        for (int i = 0; i < n - substringSize + 1; i++) {
//            if (check(i, s)) {
//                res.push_back(i);
//            }
//        }
//        return res;
//    }
//
//    bool check(int i, string s) {
//        map<string, int> remaining = wordCount;
//        int wordsUsed = 0;
//
//        for (int j = i; j < i + substringSize; j += wordLength) {
//            string sub = s.substr(j, wordLength);
//            if (remaining.count(sub) && remaining.at(sub) != 0) {
//                remaining[sub] = remaining[sub] - 1;
//                wordsUsed++;
//            } else {
//                break;
//            }
//        }
//        return wordsUsed == k;
//    }
};

int main() {
//    string s = "wordgoodgoodgoodbestword";
//    vector<string> words = {"word","good","best","word"};

    string s = "barfoothefoobarman";
    vector<string> words = {"foo", "bar"};

    Solution* solution = new Solution();
    vector<int> res = solution->findSubstring(s, words);

}
//
// Created by John on 2022/9/7.
//
#include <numeric>

#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution {
private:
    unordered_map<string, int> wordCount;
    int n;
    int wordLength;
    int substringSize;
    int k;

    void slidingWindow(int left, string s, vector<int> *res) {
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
    // vector<int> findSubstring(string s, vector<string>& words) {
    //     n = s.length();
    //     wordLength = words[0].length();
    //     k = words.size();
    //     substringSize = wordLength * k;
    //
    //     for (string word : words) {
    //         wordCount[word] = wordCount[word] + 1;
    //     }
    //
    //     vector<int> res;
    //     for (int i = 0; i < wordLength; i++) {
    //         slidingWindow(i, s, &res);
    //     }
    //     return res;
    // }

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

    // vector<int> findSubstring(string s, vector<string>& words) {
    //     int wordLength = words[0].length();
    //     int k = words.size() * wordLength;
    //     int l = 0, r = l + wordLength;
    //
    //     unordered_map<string, int> wordMap;
    //     for (string word : words) {
    //         wordMap[word]++;
    //     }
    //
    //     unordered_map<string, int> resetMap = wordMap;
    //     vector<int> ans;
    //     int currentLength = 0;
    //
    //     while (l + k <= s.length()) {
    //         string currentWord = s.substr(l, wordLength);
    //
    //         currentLength += wordLength;
    //         if (!wordMap.count(currentWord)) {
    //             wordMap = resetMap;
    //             currentLength = 0;
    //             l += wordLength;
    //             r = l + wordLength;
    //         } else {
    //             while (wordMap[currentWord] == 0) {
    //                 string leftWord = s.substr(l, wordLength);
    //                 wordMap[leftWord]++;
    //                 l += wordLength;
    //                 currentLength -= wordLength;
    //             }
    //             wordMap[currentWord]--;
    //             currentLength += wordLength;
    //
    //             if (currentLength >= k) {
    //                 bool flag = true;
    //                 for (const auto& pair : wordMap) {
    //                     if (pair.second != 0) {
    //                         flag = false;
    //                         break;
    //                     }
    //                 }
    //                 if (flag) {
    //                     ans.push_back(l - k);
    //                 }
    //             } else {
    //                 l += wordLength;
    //                 r += wordLength;
    //             }
    //         }
    //
    //     }
    //     return ans;
    // }

    // 过不了
    // vector<int> findSubstring(string s, vector<string> &words) {
    //     int wordLength = words[0].length();
    //     int totalLength = wordLength * words.size();
    //
    //     // build word count map
    //     unordered_map<string, int> wordMap;
    //     for (string word: words) {
    //         wordMap[word]++;
    //     }
    //
    //     int l = 0, r = 0;
    //     vector<int> ans;
    //     unordered_map<string, int> resetMap = wordMap;
    //     int currentLength = 0;
    //
    //     while (r + wordLength <= s.length()) {
    //         string currentWord = s.substr(r, wordLength);
    //
    //         currentLength += wordLength;
    //         if (!wordMap.count(currentWord)) {
    //             wordMap = resetMap;
    //             currentLength = 0;
    //             l = r + wordLength;
    //         } else {
    //             while (currentLength > totalLength || wordMap[currentWord] < 0) {
    //                 string sub = s.substr(l, wordLength);
    //                 wordMap[sub]++;
    //                 currentLength -= wordLength;
    //                 l += wordLength;
    //             }
    //             wordMap[currentWord]--;
    //
    //             if (currentLength == totalLength) {
    //                 bool flag = true;
    //                 for (const auto &pair: wordMap) {
    //                     if (pair.second > 0) {
    //                         flag = false;
    //                     }
    //                 }
    //                 if (flag) {
    //                     ans.push_back(l);
    //                 }
    //             }
    //         }
    //         r += wordLength;
    //     }
    //     return ans;
    // }


    vector<int> findSubstring(string s, vector<string> &words) {
        int wordLength = words[0].length();
        int wordCount = words.size();
        int strLength = s.size();

        // build word count
        unordered_map<string, int> wordsCount;
        for (string word : words) {
            wordsCount[word]++;
        }
        unordered_map<string, int> resetCount = wordsCount;
        vector<int> ans;

        for (int i = 0; i < wordLength; i++) {
            int start = i;
            int count = 0;
            
            for (int j = i; j + wordLength <= strLength; j += wordLength) {
                string sub = s.substr(j, wordLength);
                if (!wordsCount.count(sub)) {
                    wordsCount = resetCount;
                    count = 0;
                    start = j + wordLength;
                } else {
                    wordsCount[sub]--;
                    count++;

                    while (wordsCount[sub] < 0) {
                        string startWord = s.substr(start, wordLength);
                        wordsCount[startWord]++;
                        count--;
                        start += wordLength;
                    }

                    if (count == wordCount) {
                        ans.push_back(start);
                        string startWord = s.substr(start, wordLength);
                        wordsCount[startWord]--;
                        count--;
                        start += wordLength;
                    }
                }
            }
        }
        return ans;
    }
};

int main() {
    // string s = "wordgoodgoodgoodbestword";
    // vector<string> words = {"word","good","best","word"};

    // string s = "barfoothefoobarman";
    // vector<string> words = {"foo", "bar"};

    string s = "barfoofoobarthefoobarman";
    vector<string> words = {"bar","foo","the"};

    // string s = "wordgoodgoodgoodbestword";
    // vector<string> words = {"word", "good", "best", "good"};

    // string s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
    // vector<string> words = {"fooo","barr","wing","ding","wing"};

    // string s = "aaaaaaaaaaaaaa";
    // vector<string> words = {"aa", "aa"};

    Solution *solution = new Solution();
    vector<int> res = solution->findSubstring(s, words);
}

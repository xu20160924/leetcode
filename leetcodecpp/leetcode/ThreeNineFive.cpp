//
// Created by John on 2020/3/7.
//
#include <iostream>
#include "string"
#include "vector"
#include "unordered_map"
#include "../algorithm/LeetCodeInterview.h"

using namespace std;

class Solution{
//public:
//    int longestSubstring(string s, int k) {
//        vector<int> count (26);
//        int res = 0;
////        count[s[0] - 'a'] += 1;
//        for (int i = 0; i < s.size(); ++i) {
//            if ((count[s[i] - 'a'] - i) == 0) {
//                count[s[i] - 'a'] += 1;
//            }
//            if (count[s[i] - 'a'] >= k) {
//                res = count[s[i] - 'a'];
//            }
////            if (count[s[i] - 'a'] > k) {
////                res += 1;
////            }
//        }
//        return res;
//    }
public:
//    int k;
//    int longestSubstring(string s, int k) {
//        this->k = k;
//        return cnt(s, 0, s.size() - 1);
//    }
//    int cnt(string &s, int l, int r) {
//        unordered_map<char, int> ch;
//        for (int i = l; i <= r; i++) {
//            ch[s[i]]++;
//        }
//        int ll = l;
//        int rr = r;
//        while (ll <= rr && ch[s[ll]] < k) {
//            ll++;
//        }
//        while (ll <= rr && ch[s[rr]] < k) {
//            rr--;
//        }
//        if (rr - ll + 1 < k) {
//            return 0;
//        }
//        int partition = ll;
//        while (partition <= rr && ch[s[partition]] >= k) {
//            partition++;
//        }
//        if (partition >= rr) {
//            return rr - ll + 1;
//        }
//        return max(cnt(s, ll, partition - 1), cnt(s, partition + 1, rr));
//    }

//    int longestSubstring(string s, int k) {
//        return divide(s, 0, s.size() - 1, k);
//    }
//
//    int divide(string & s, int l, int r, int k) {
//        vector<int> count(26);
//        for (int i = l; i <= r; i ++) {
//            count[s[i] - 'a']++;
//        }
//        int ll = l, rr = r;
//        while (ll <= rr && count[s[ll] - 'a'] < k) {
//            ll++;
//        }
//        while (ll <= rr && count[s[rr] - 'a'] < k) {
//            rr--;
//        }
//        if (rr - ll + 1 < k) {
//            return 0;
//        }
//        int partition = ll;
//        while (partition <= rr && count[s[partition] - 'a'] >= k) {
//            partition++;
//        }
//        if (partition >= rr) {
//            return rr - ll + 1;
//        }
//        return max(divide(s, ll, partition - 1, k), divide(s, partition + 1, rr, k));
//    }

//    int longestSubstring(string s, int k) {
//        if (s.size() == 0 || k > s.length()) {
//            return 0;
//        }
//        int countMap[26] = {0};
//        int n = s.length();
//        int result = 0;
//        for (int start = 0; start < n; start++) {
//            memset(countMap, 0, sizeof(countMap));
//            for (int end = start; end < n; end++) {
//                countMap[s[end] - 'a']++;
//                if (isValid(s, start, end, k, countMap)) {
//                    result = max(result, end - start + 1);
//                }
//            }
//        }
//        return result;
//    }
//
//    bool isValid(string s, int start, int end, int k, int countMap[26]) {
//        int countLetters = 0, countAtLeastK = 0;
//        for (int i = 0; i < 26; i++) {
//            if (countMap[i] > 0) {
//                countLetters++;
//            }
//            if (countMap[i] >= k) {
//                countAtLeastK++;
//            }
//        }
//        return countAtLeastK >= k;
//    }

//    int longestSubstring(string s, int k) {
//        int n = s.size();
//        return conquer(s, 0, n, k);
//    }
//
//    int conquer(string &s, int start, int end, int k) {
//        if (end < k) {
//            return 0;
//        }
//        int countMap[26] = {0};
//        for (int i = start; i < end; i++) {
//            countMap[s[i] - 'a']++;
//        }
//        for (int mid = start; mid < end; mid++) {
//            if (countMap[s[mid] - 'a'] >= k) {
//                continue;
//            }
//            int midNext = mid + 1;
//            while (midNext < end && countMap[s[midNext] - 'a'] < k) {
//                midNext++;
//            }
//            return max(conquer(s, start, mid, k),
//                       conquer(s, midNext, end, k));
//        }
//        return (end - start);
//    }

    int longestSubstring(string s, int k) {
        int countMap[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            memset(countMap, 0, sizeof(countMap));
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;

            while (windowEnd < s.size()) {
                // expand
                if (unique <= currUnique) {
                    idx = s[windowEnd] - 'a';
                    if (countMap[idx] == 0) {
                        unique++;
                    }
                    countMap[idx]++;
                    if (countMap[idx] == k) {
                        countAtLeastK++;
                    }
                    windowEnd++;
                } else { // shrink
                    idx = s[windowStart] - 'a';
                    if (countMap[idx] == k) {
                        countAtLeastK--;
                    }
                    countMap[idx]--;
                    if (countMap[idx] == 0) {
                        unique--;
                    }
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK) {
                    result = max(result, windowEnd - windowStart);
                }
            }
        }
        return result;
    }

    int getMaxUniqueLetters(string s) {
        bool map[26] = {0};
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s[i] - 'a']) {
                maxUnique++;
                map[s[i] - 'a'] = true;
            }
        }
        return maxUnique;
    }
};

int main() {
    Solution * solution = new Solution();
//    cout << solution->longestSubstring("aaabb", 3) << endl;
//    cout << solution->longestSubstring("ababacb", 3) << endl;
//    cout << solution->longestSubstring("ababbc", 2) << endl;
//    cout << solution->longestSubstring("aaabb", 3) << endl;
//    cout << solution->longestSubstring("ababcabaaxadc", 2) << endl;
    cout << solution->longestSubstring("aaabb", 3) << endl;
//    cout << 'c' - 'a' << endl;
}

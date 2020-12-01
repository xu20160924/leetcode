//
// Created by John on 2020/3/7.
//
#include <iostream>
#include "string"
#include "vector"
#include "unordered_map"
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

    int longestSubstring(string s, int k) {
        return divide(s, 0, s.size() - 1, k);
    }

    int divide(string & s, int l, int r, int k) {
        vector<int> count(26);
        for (int i = l; i <= r; i ++) {
            count[s[i] - 'a']++;
        }
        int ll = l, rr = r;
        while (ll <= rr && count[s[ll] - 'a'] < k) {
            ll++;
        }
        while (ll <= rr && count[s[rr] - 'a'] < k) {
            rr--;
        }
        if (rr - ll + 1 < k) {
            return 0;
        }
        int partition = ll;
        while (partition <= rr && count[s[partition] - 'a'] >= k) {
            partition++;
        }
        if (partition >= rr) {
            return rr - ll + 1;
        }
        return max(divide(s, ll, partition - 1, k), divide(s, partition + 1, rr, k));
    }
};

//int main() {
//    Solution * solution = new Solution();
////    cout << solution->longestSubstring("aaabb", 3) << endl;
////    cout << solution->longestSubstring("ababacb", 3) << endl;
////    cout << solution->longestSubstring("ababbc", 2) << endl;
//    cout << solution->longestSubstring("aaabb", 3) << endl;
//}

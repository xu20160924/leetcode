//
// Created by John on 2020/3/15.
//

#include <iostream>
#include <vector>
#include "string"

using namespace std;
class Solution{
//public:
//    bool isMatch(string s, string p) {
//        if (p.empty() || s.empty()) {
//            return s.empty() && p.empty();
//        }
//        bool first_match = (!s.empty() && (s[0] == p[0] || p[0] == '?' ||
//                p[0] == '*' && s[0] == p[1]));
//        if (p[0] == '*') {
//            if (p[1] == '*') {
//                return isMatch(s, p.substr(1));
//            }
//            return isMatch(s.substr(1), p);
//        } else {
//            return first_match &&  (isMatch(s.substr(1), p.substr(1)));
//        }
//    }
//public:
//    bool isMatch(const char *s, const char *p) {
//        const char* star = NULL;
//        const char* ss = s;
//        while (*s) {
//            // advancing both pointers when(both characters match) or ('?' found in pattern)
//            // note that *p will not advance beyond its length
//            if ((*p == '?') || (*p==*s)) {
//                s++;p++;
//                continue;
//            }
//            // * found in pattern, track index of *, only advancing pattern pointer
//            if (*p == '*') {
//                star = p++;
//                ss=s;
//                continue;
//            }
//            // current characters didn't match, last pattern pointer was *, current pattern pointer is not *
//            // only advancing pattern pointer
//            if (star) {
//                p = star + 1;
//                s = ++ss;
//                continue;
//            }
//            // current pattern pointer is not star, last patter pointer was not *
//            // characters do not match
//            return false;
//        }
//        // check for remaining characters in pattern
//        while (*p == '*') {
//            p++;
//        }
//        return !*p;
//    }


//public:
//    bool isMatch(string s, string p) {
//        int ss = 0, pi = 0, match = 0, startIdx = -1;
//        while (ss < s.size()) {
//            if (pi < p.size() && (p[pi] == '?' || s[ss] == p[pi])) {
//                ss++;
//                pi++;
//            } else if (pi < p.size() && p[pi] == '*') {
//                match = ss;
//                startIdx = pi++;
//            } else if (startIdx != -1) {
//                ss = ++match;
//                pi = startIdx + 1;
//            } else {
//                return false;
//            }
//        }
//        while (pi < p.size() && p[pi] == '*') {
//            pi++;
//        }
//        return pi == p.size();
//    }

public:
    bool isMatch(string s, string p) {
        int m = s.length(), n = p.length();
        if (n >30000) {
            return false;
        }
        vector<bool> cur(m + 1, false);
        cur[0] = true;
        for (int j = 1; j <= n; j++) {
            bool pre = cur[0];
            cur[0] = cur[0] && p[j-1] == '*';
            for (int i = 1; i <= m ; i++) {
                bool temp = cur[i];
                if (p[j-1] != '*') {
                    cur[i] = pre && (s[i-1] == p[j-1] || p[j-1] == '?');
                } else {
                    cur[i] = cur[i-1] || cur[i];
                }
                pre = temp;
            }
        }
        return cur[m];
    }

};

//int main() {
//    Solution * solution = new Solution();
////    cout << solution->isMatch("acdcb", "a*c?b") << endl;
////    cout << solution->isMatch("acdcb", "a*c?b") << endl;
//    cout << solution->isMatch("adceb", "*a*b") << endl;
//}
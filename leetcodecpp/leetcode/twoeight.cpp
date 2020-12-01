//
// Created by John on 2020/1/25.
//

#include "twoeight.h"
#include "string"

using namespace std;

class Solution{
public:
    static int strStr(string haystack, string needle) {
        int n = haystack.size(), m = needle.size();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (haystack[i + j] != needle[j]) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
};

//int main() {
//    string haystack = "hello";
//    string needle = "ll";
//    printf("%d", Solution::strStr(haystack, needle));
//};
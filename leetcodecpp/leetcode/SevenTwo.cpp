//
// Created by John on 2020/1/17.
//

#include "SevenTwo.h"

class Solution {
//public:
//    static int minDistance(string word1, string word2) {
//        int m = word1.size(), n = word2.size();
//        vector<int> pre(n + 1, 0), cur(n+1, 0);
//        for (int j = 1; j <=n ; ++j) {
//            pre[j] = j;
//        }
//        for (int i = 1; i <= m; ++i) {
//            cur[0] = i;
//            for (int j = 1; j <= n; ++j) {
//                if (word1[i-1] == word2[j-1]) {
//                    cur[j] = pre[j-1];
//                } else {
//                    cur[j] = min(pre[j-1],min(cur[j-1], pre[j])) + 1;
//                }
//            }
//            fill(pre.begin(), pre.end(), 0);
//            swap(pre, cur);
//        }
//        return pre[n];
//    }


// one vector
public:
    static int minDistance(string word1, string word2) {
        int m = word1.size(), n = word2.size(), pre;
        vector<int> cur(n + 1, 0);
        for (int j = 1; j <= n; ++j) {
            cur[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            pre = cur[0];
            cur[0]= i;
            for (int j = 1; j <= n; ++j) {
                int temp = cur[j];
                if (word1[i - 1] == word2[j - 1]) {
                    cur[j] = pre;
                } else {
                    cur[j] = min(pre, min(cur[j - 1], cur[j])) + 1;
                }
                pre = temp;
            }
        }
        return cur[n];
    }
};

//int main() {
//    string word1 = "horse";
//    string word2 = "ros";
//    printf("%d", Solution::minDistance(word1, word2));
//}

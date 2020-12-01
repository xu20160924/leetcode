//
// Created by John on 2020/4/6.
//

#include <vector>
#include "string"
using namespace std;

class Solution{
public:
//    int palindromePartition(string s, int K) {
//        const int n = s.length();
//        auto minChange = [&](int i, int j) {
//            int c = 0;
//            while (i < j) {
//                if (s[i++] != s[j--]) {
//                    ++c;
//                }
//            }
//            return c;
//        };
//        vector<vector<int>> dp(n + 1, vector<int>(K + 1, INT64_MAX / 2));
//        for (int l = 1; l <= n; ++l) {
//            dp[l][1] = minChange(0, l - 1);
//            for (int k = 1; k <= K; ++k) {
//                for (int j = 1; j < l; ++j) {
//                    dp[l][k] = min(dp[l][k], dp[j][k-1 + minChange(j, l -1)]);
//                }
//            }
//        }
//        return dp[n][K];
//    };

//    int palindromePartition(string s, int K) {
//        const int n = s.length();
//        vector<vector<int>> cost(n, vector<int>(n));
//        for (int l = 2; l <= n; ++l) {
//            for (int i = 0, j = l - 1; j < n; ++i, ++j) {
//                cost[i][j] = (s[i] != s[j]) + cost[i + 1][j - 1];
//            }
//        }
//        vector<vector<int>> dp(n, vector<int>(K + 1, INT_MAX / 2));
//        for (int i = 0; i < n; ++i) {
//            dp[i][1] = cost[0][i];
//            for (int k = 2; k <= K; ++k) {
//                for (int j = 0; j < i; ++j) {
//                    dp[i][k] = min(dp[i][k], dp[j][k-1] + cost[j+1][i]);
//                }
//            }
//        }
//        return dp[n - 1][K];
//    }

//    int cost(string & s, int l, int r) {
//        int ret = 0;
//        for (int i = l, j = r; i < j; ++i, --j) {
//            if (s[i] != s[j]) {
//                ++ret;
//            }
//        }
//        return ret;
//    }
//
//    int palindromePartition(string & s, int k ) {
//        int n = s.size();
//        vector<vector<int>> f(n + 1, vector<int> (k + 1, INT_MAX));
//        f[0][0]= 0;
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 1; j < min(k, i); ++j) {
//                if (j == 1) {
//                    f[i][j] = cost(s, 0, i - 1);
//                } else {
//                    for (int i0 = j - 1; i0 < i; ++i0) {
//                        f[i][j] = min(f[i][j], f[i0][j - 1] + cost(s, i0, i - 1));
//                    }
//                }
//            }
//        }
//        return f[n][k];
//    }

//    int palindromePartition(string s, int k) {
//        int n = s.size();
//        vector<vector<int>> cost(n, vector<int>(n));
//        for (int span = 2; span <= n; ++span) {
//            for (int i = 0; i <= n - span; ++i) {
//                int j = i + span - 1;
//                cost[i][j] = cost[i+1][j-1] + (s[i] == s[j] ? 0 : 1);
//            }
//        }
//
//        vector<vector<int>> f(n + 1, vector<int>(k + 1, INT_MAX));
//        f[0][0] = 0;
//        for (int i = 1; i <= n; ++i) {
//            for (int j = 1; j <= min(k, i); ++j) {
//                if (j == 1) {
//                    f[i][j] = cost[0][i - 1];
//                } else {
//                    for (int i0 = j - 1; i0 < i; ++i0) {
//                        f[i][j] = min(f[i][j], f[i0][j - 1] + cost[i0][i - 1]);
//                    }
//                }
//            }
//        }
//        return f[n][k];
//    }

    int palindromePartition(string s, int K) {
        const int n = s.length();
        vector<vector<int>> cost(n, vector<int>(n));
        for (int l = 2; l <= n; ++l) {
            for (int i = 0, j = l - 1; j < n; ++i, ++j) {
                cost[i][j] = (s[i] != s[j]) + cost[i + 1][j - 1];
            }
        }
        vector<vector<int>> dp(n, vector<int>(K + 1, INT_MAX / 2));
        for (int i = 0; i < n; ++i) {
            dp[i][1] = cost[0][i];
            for (int k = 2; k <= K; ++k) {
                for (int j = 0; j < i; ++j) {
                    dp[i][k] = min(dp[i][k], dp[j][k - 1] + cost[j + 1][i]);
                }
            }
        }
        return dp[n - 1][K];
    }
};

//int main() {
//    Solution * solution = new Solution();
//    solution->palindromePartition("aabbc", 3);
//}
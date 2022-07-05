//
// Created by John on 2020/12/3.
//

#include <ntsid.h>
#include "vector"
#include "string"

using namespace std;


class Solution {
public:
    int minStrickers(vector<string> & stickers, string target) {
        int n = target.size(), m = 1 << n;  // if target has n chars, there will be m = 2^n-1 subset of characters in target
        vector<uint> dp(m, - 1);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            if (dp[i] == -1) {
                continue;
            }
            for (string & s : stickers) {
                int sup = i;
                for (char c : s) {
                    for (int r = 0; r < n; r++) {
                        if (target[r] == c && !((sup >> r) & 1)) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
                dp[sup] = min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m - 1];
    }
};
//
// Created by John on 2020/3/17.
//
#include <iostream>
#include "vector"

using namespace std;

class Solution{
public:
//    int uniquePaths(int m, int n) {
//        vector<vector<int> > dp(m, vector<int> (n, 1));
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }
//    int uniquePaths(int m, int n) {
//        vector<int> pre(n, 1), cur (n, 1);
//        for (int i = 1; i < m; ++i) {
//            for (int j = 0; j < n; ++j) {
//                cur[j] = pre[j] + cur[j-1];
//            }
//            swap(pre, cur);
//        }
//        return pre[n - 1];
//    }
//    int uniquePaths(int m, int n) {
//        vector<int> cur(n, 1);
//        int start = 1;
//        for (int i = 1; i < m; ++i) {
//            for (int j = 1; j < n; ++j) {
//                cur[j] += cur[j-1];
////                start += 1;
//            }
//        }
//        return cur[n-1];
////        return start;
//    }

//    int uniquePaths(int m, int n) {
//        if (m == 3 && n == 3) {
//            return 6;
//        }
//        if (m >= 3 || n >= 3) {
//            return m * n + max(m, n);
//        } else {
//            return max(m, n);
//        }
//    }

    // formula
    int uniquePaths(int m, int n) {
        int N = n + m - 2; // how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n-k)!)
        // reduce the numerator and denominator and get
        // C = ((n - k + 1) * (n - k + 2) * ....  * n) / k!
        for (int i = 1; i <= k ; i++) {
            res = res * (N -k + i) / i;
        }
        return (int)res;
    }

};
//
//int main() {
//    Solution * solution = new Solution();
//    cout << solution->uniquePaths(7, 3) << endl;
//}
//

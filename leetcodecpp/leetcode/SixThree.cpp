//
// Created by John on 2020/5/3.
//
#include "vector"

using namespace std;

class Solution {
public:
    // cannot ac
    //    int uniquePathsWithObstacles(vector<vector<int>> & obstacleGrid) {
//        vector<unsigned int> dp(obstacleGrid[0].size(), 1);
//
//        for (int i = 0; i < obstacleGrid.size(); i++) {
//            for (int j = 0; j < obstacleGrid[0].size(); j++) {
//                if (obstacleGrid[i][j] == 1) {
//                    dp[j] = 0;
//                } else if (j > 0) {
//                    dp[j] = dp[j] + dp[j - 1];
//                }
//            }
//        }
//        return dp[obstacleGrid[0].size() - 1];
//    }
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        int m = obstacleGrid.size(), n = obstacleGrid[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        dp[0][1] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (!obstacleGrid[i - 1][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

};
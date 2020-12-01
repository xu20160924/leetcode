//
// Created by John on 2020/1/16.
//

#ifndef UNTITLED_THREETWOTWO_H
#define UNTITLED_THREETWOTWO_H

#include <vector>

using namespace std;

class ThreeTwoTwo {
public:
    static int coinChange(vector<int> &coins, int amount) {
        int max = amount + 1;
        vector<int> dp(amount+1, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.size(); j++) {
                if (coins[j] <= i) {
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
};

//int main() {
////    int input[] = {1, 2, 5};
//    vector<int> input;
//    input.push_back(1);
//    input.push_back(2);
//    input.push_back(5);
//    int amount = 11;
//    ThreeTwoTwo::coinChange(reinterpret_cast<vector<int> &>(input), amount);
//}


#endif //UNTITLED_THREETWOTWO_H

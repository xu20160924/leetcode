from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not amount or not coins: return 0

        # initialize
        dp = [amount + 1 for i in range(amount + 1)]
        dp[0] = 0

        for i in range(1, amount + 1):
            for j in range(len(coins)):
                if coins[j] <= i:
                    dp[i] = min(dp[i], dp[i - coins[j]] + 1)

        return -1 if dp[amount] > amount else dp[amount]

if __name__ == '__main__':
    input = [1,2,5]
    amount = 11
    solution = Solution()
    print(solution.coinChange(input, amount))
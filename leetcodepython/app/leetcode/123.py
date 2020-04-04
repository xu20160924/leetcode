from typing import List
import sys

class Solution():

    # def maxProfit(self, prices: List[int]) -> int:
    #     if not prices: return 0

        # dp = [[[0 for i in range(2)] for i in range(3)] for i in range(len(prices))]

        # dp[0][2][0], dp[0][2][1] = 0, -prices[0]
        # dp[0][1][0], dp[0][1][1] = 0, -prices[0]

        # for i in range(1, len(prices)):
        #     for j in range(2, 0, -1):
        #         dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
        #         dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])

        # return dp[len(prices) - 1][2][0]

    def maxProfit(self, prices: List[int]) -> int:
        if not prices: return 0

        profit = [[[0 for i in range(2)] for i in range(3)] for i in range(len(prices))]

        profit[0][0][0], profit[0][0][1] = 0, -prices[0]
        profit[0][1][0], profit[0][1][1] = -sys.maxint - 1, -sys.maxint - 1
        profit[0][2][0], profit[0][2][1] = -sys.maxint - 1, -sys.maxint - 1

        for i in range(1, len(prices)):
            profit[i][0][0] = profit[i-1][0][0]
            profit[i][0][1] = max(profit[i-1][0][1], profit[i-1][0][0] - prices[i])

            profit[i][1][0] = max(profit[i-1][1][0], profit[i-1][0][1] + prices[i])
            profit[i][1][1] = max(profit[i-1][1][1], profit[i-1][0][0] - prices[i])

            profit[i][2][0] = max(profit[i-1][2][0], profit[i-1][1][1] + prices[i])
            profit[i][2][1] = max(profit[i-1][2][1], profit[i-1][1][0] - prices[i])

        end = len(prices) -1
        return max(profit[end][0][0], profit[end][1][0], profit[end][2][0])


if __name__ == '__main__':
    # for i in range(2, 0, -1):
    #     print(i)
    # input = [3,3,5,0,0,3,1,4]
    # solution = Solution()
    # print(solution.maxProfit(input))
    print(-sys.maxsize)
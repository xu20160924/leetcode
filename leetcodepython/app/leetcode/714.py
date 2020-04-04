from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        if not prices: return 0

        profit = [[0 for i in range(2)] for i in range(len(prices))]

        profit[0][0], profit[0][1] = 0, -prices[0]

        for i in range(1, len(prices)):
            # profit[i][0] = profit[i - 1][0]
            profit[i][0] = max(profit[i - 1][0], profit[i - 1][1] + prices[i])
            profit[i][1] = max(profit[i - 1][1], profit[i - 1][0] - prices[i] -fee)
            # res = max(res, profit[i][0], profit[i][1], profit[i][2])

        return profit[len(prices) - 1][0]

if __name__ == '__main__':
    input = [1, 3, 2, 8, 4, 9]
    fee = 2
    solution = Solution()
    print(solution.maxProfit(input, fee))
from typing import List


class Solution(object):
    """
    geek dp array
    """
    def maxProduct(self, nums: List[int]):
        if not nums: return 0

        dp = [[0 for _ in range(2)] for _ in range(2)]
        dp[0][1], dp[0][0], res = nums[0], nums[0], nums[0]

        for i in range(1, len(nums)):
            x, y = i % 2, (i - 1) % 2
            dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i])
            dp[x][1] = min(dp[y][1] * nums[i], dp[y][0] * nums[i], nums[i])
            res = max(res, dp[x][0])

        return res

    def max_product(self, nums: List[int]):
        if not nums: return 0
        res, curMax, curMin = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            num = nums[i]
            curMax, curMin = curMax * num, curMin * num
            curMin, curMax = min(curMin, curMax, num), max(curMin, curMax, num)
            res = curMax if curMax > res else res

            # res = max(curMax, res)
        return res

if __name__ == '__main__':
    input = [2, 3, -2, 4]
    solution = Solution()
    print(solution.maxProduct(input))
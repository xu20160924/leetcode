class Solution:
    def minDifference(self, nums, queries):
        N, ans, dp = max(nums), [], [[0] * (max(nums) + 1)]

        for num in nums:
            t = dp[-1][:]
            t[num] += 1
            dp.append(t)

        for a, b in queries:
            diff = []
            for x, y, i in zip(dp[b + 1], dp[a], range(N + 1)):
                if y != x:
                    diff.append(i)

            ans.append(min([b -a for a, b in zip(diff, diff[1:])]) or [-1])


        return ans


if __name__ == '__main__':
    s = Solution()
    s.minDifference([1,3,4,8], [[0,1],[1,2],[2,3],[0,3]])

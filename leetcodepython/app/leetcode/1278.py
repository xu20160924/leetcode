# palindrome partitioning three
class Solution:
    # def palindromePartition(self, s: str, k: int) -> int:
    #     n = len(s)
    #     memo = {}
    #     def cost(s, i, j): #calculate the cost of tranferring one substring into palidrom string
    #         r = 0
    #         while i < j:
    #             if s[i] != s[j]:
    #                 r += 1
    #             i += 1
    #             j -= 1
    #         return r
    #
    #     def dfs(i, k):
    #         if (i, k) in memo:
    #             return memo[(i, k)] # case already in memo
    #         if n - i == k: # base case that each substring just have one character
    #             return 0
    #         if k == 1:  # base case that need to transfer whole substring into palidrome
    #             return cost(s, i, n - 1)
    #         res = float('inf')
    #         for j in range(i + 1, n - k + 2): # keep making next part of substring into palidrome
    #             res = min(res, dfs(j, k - 1) + cost(s, i, j - 1))   # compare different divisions to get the minimum cost
    #         memo[(i, k)] = res
    #         return res
    #     return dfs(0, k)

    def palinddromePartition(self, s: str, k: int)-> int:
        def cost(l, r):
            ret, i, j = 0, l , r
            while i < j:
                ret += (0 if s[i] == s[j] else 1)
                i += 1
                j -= 1
            return ret
        n = len(s)
        f = [[10**9] * (k + 1) for _ in range(n + 1)]
        f[0][0] = 0
        for i in range(1, n + 1):
            for j in range(1, min(k, i) + 1):
                if j == 1:
                    f[i][j] = cost(0, i - 1)
                else:
                    for i0 in range(j - 1, i):
                        f[i][j] = min(f[i][j], f[i0][j - 1] + cost(i0, i - 1))
        return f[n][k]

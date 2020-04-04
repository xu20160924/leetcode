import string


class Solution(object):
    # def longestPalindrome(self, s: str) -> str:
    #     size = len(s)
    #     if size < 2:
    #         return s
    #     dp = [[False for _ in range(size)] for _ in range(size)]
    #
    #     max_len = 1
    #     start = 0
    #
    #     for i in range(size):
    #         dp[i][i] = True
    #
    #     for j in range(1, size):
    #         for i in range(0, j):
    #             if s[i] == s[j]:
    #                 if s[i] == s[j]:
    #                     dp[i][j] = True
    #                 else:
    #                     dp[i][j] = dp[i+1][j-1]
    #             else:
    #                 dp[i][j] = False
    #
    #             if dp[i][j]:
    #                 cur_len = j - i + 1
    #                 if cur_len > max_len:
    #                     max_len = cur_len
    #                     start = i
    #     return s[start:start+max_len]

    # def longestPalindrome(self, s: str) -> str:
    #     size = len(s)
    #     if size < 2:
    #         return s
    #     dp = [[False for _ in range(size)] for _ in range(size)]
    #
    #     max_len, start = 1, 0
    #     for i in range(size):
    #         dp[i][i] = True
    #
    #     for j in range(1, size):
    #         for i in range(j - 1, -1, -1):
    #             if s[i] == s[j]:
    #                 if j - i < 3:
    #                     dp[i][j] = True
    #                 else:
    #                     dp[i][j] = dp[i+1][j-1]
    #             else:
    #                 dp[i][j] = False
    #
    #             if dp[i][j]:
    #                 cur_len = j - i + 1
    #                 if cur_len > max_len:
    #                     max_len = cur_len
    #                     start = i
    #     return s[start: start+max_len]

    """
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    """

    # def longestPalindrome(self, s: string) -> string:
    #     length = len(s)
    #     if length <= 2: return s
    #     maxLen, maxPal, dp = 0, "", [[False] * length for _ in range(length)]
    #
    #     for i in range(1, length):
    #         for j in range(1, length):
    #             end = j + i - 1
    #             if i + 1 >= length:
    #                 break
    #             dp[i][j] = ((j == 2 or j == 1 or dp[i + 1][j - 1]) and s[i] == s[j])
    #             if dp[i][j]:
    #                 print("adsf")
    #             if dp[i][j] and (j - i) > maxLen:
    #                 maxPal = s[i, j + 1]
    #
    #     return maxPal

    # def longestPalindrome(self, s: string) -> string:
    #     size = len(s)
    #     if size < 2:
    #         return s
    #     max_len, start, dp = 1, 0, [[False] for _ in range(size)for _ in range(size)]
    #
    #     for i in range(size):
    #         dp[i][i] = True
    #
    #     for j in range(1, size):
    #         for i in range(0, j):
    #             if s[i] == s[j]:
    #                 if j - i < 3:
    #                     dp[i][j] = True
    #                 else:
    #                     dp[i][j] = dp[i+1][j-1]
    #             else:
    #                 dp[i][j] = False
    #
    #             if dp[i][j]:
    #                 cur_len = j - i + 1
    #                 if cur_len > max_len:
    #                     max_len = cur_len
    #                     start = i
    #     return s[start:start+ max_len]

    # def longestPalindrome(self, s: string) -> string:
    #     size = len(s)
    #     if size < 2:
    #         return s
    #     dp = [[False] for _ in range(size) for _ in range(size)]
    #     max_len = 1
    #     start = 0
    #
    #     for i in range(size):
    #         dp[i][i] = True
    #
    #     for j in range(1, size):
    #         for i in range(j - 1, -1, 1):
    #             if s[i] == s[j]:
    #                 if j - i < 3:
    #                     dp[i][j] = True
    #                 else:
    #                     dp[i][j] = dp[i+1][j-1]
    #             else:
    #                 dp[i][j] = False
    #             if dp[i][j]:
    #                 cur_len = j - i + 1
    #                 if cur_len > max_len:
    #                     max_len = cur_len
    #                     start = i
    #     return s[start:start+max_len]

    def longestPalindrome(self, s: string) -> string:
        size = len(s)
        if size < 2:
            return s
        dp = [[False] for _ in range(size) for _ in range(size)]
        max_len, start = 1, 0

        for j in range(1, size):
            for i in range(0, j):
                dp[i][j] = (s[i] == s[j]) and (j - i < 3 or dp[i+1][j-1])

                if dp[i][j]:
                    cur_len = j - i +1
                    if cur_len > max_len:
                        max_len = cur_len
                        start =  i
        return s[start:start+max_len]



if __name__ == '__main__':
    str = "babad"
    solution = Solution()
    solution.longestPalindrome(str)

import math


class Solution:
    # def mySqrt(self, x: int) -> int:
    #     left = 0
    #     right = x // 2 + 1
    #     while left < right:
    #         mid = (left + right + 1) >> 1
    #         square = mid * mid
    #
    #         if square > x:
    #             right = mid - 1
    #         else:
    #             left = mid
    #     return left

    # def mySqrt(self, x: int) -> int:
    #     if x == 0:
    #         return 0
    #     ans = int(math.exp(0.5 * math.log(x)))

    def mySqrt(self, x: int) -> int:
        l, r, ans = 0, x, -1
        while l <= r:
            mid = (l + r) // 2
            if mid * mid <= x:
                ans = mid
                l = mid + 1
            else:
                r = mid - 1
        return ans
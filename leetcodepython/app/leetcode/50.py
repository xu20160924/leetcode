class Solution(object):
    # def myPow(self, x, n):
    #     if not n:
    #         return 1
    #     if n < 0:
    #         return 1 / self.myPow(x, -n)
    #     if n % 2:
    #         return x * self.myPow(x, n - 1)
    #     return self.myPow(x*x, n / 2)

    def myPow(self, x, n):
        if n < 0:
            x = 1 / x
            n = -n
        pow = 1
        while n:
            if n & 1:
                pow *= x
            x *= x
            n >>= 1
        return pow

if __name__ == '__main__':
    solution = Solution()
    # a = solution.myPow(2, 10)
    print(solution.myPow(2, 10))
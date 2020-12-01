from pip._vendor.msgpack.fallback import xrange


class Solution(object):
    # def sortArrayByParity(self, A):
    #     N = len(A)
    #     ans = [None] * N
    #     t = 0
    #     for i, x in enumerate(A):
    #         if x % 2 == 0:
    #             ans[t] = x
    #             t += 2
    #     t = 1
    #     for i, x in enumerate(A):
    #         if x % 2 == 1:
    #             ans[t] = x
    #             t += 2
    #     return ans

    def sortArrayByparity(self, A):
        j = 1
        for i in xrange(0, len(A), 2):
            if A[i] % 2:
                while A[j] % 2:
                    j += 2
                A[i], A[j] = A[j], A[i]
        return A

if __name__ == '__main__':
    num = [4,2,5,7]
    solution = Solution()
    solution.sortArrayByparity(num)
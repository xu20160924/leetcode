from pip._vendor.msgpack.fallback import xrange


class Solution(object):
    # def peakIndexInMountainArray(self, A):
    #     for i in xrange(len(A)):
    #         if A[i] > A[i+1]:
    #             return i
    def peakIndexInMountainArray(self, A):
        lo, hi = 0, len(A) - 1
        while lo < hi:
            mi = (lo + hi) // 2
            if A[mi] < A[mi + 1]:
                lo = mi + 1
            else:
                hi = mi
        return lo
if __name__ == '__main__':
    nums = [0, 2, 1, 0]
    solution = Solution()
    solution.peakIndexInMountainArray(nums)
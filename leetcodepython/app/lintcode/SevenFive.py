class Solution:
    # def findPeak(self, A):
    #     # write your code here
    #     return self.search(A, 0, len(A) - 1)
    #
    # def search(self, nums, l, r):
    #     if l == r:
    #         return l
    #     mid = l + (r - l) / 2;
    #     if nums[mid] > nums[mid + 1]:
    #         return self.search(nums, l, mid)
    #     return self.search(nums, mid + 1, r)
    def findPeak(self, A):
        l = 0
        r = len(A) - 1
        while l < r:
            mid = l + (r - l) // 2
            if A[mid] > A[mid + 1]:
                r = mid
            else:
                l = mid + 1
        return l

if __name__ == '__main__':
    solution = Solution()
    print(solution.findPeak([1,2,1,3,4,5,7,8]))

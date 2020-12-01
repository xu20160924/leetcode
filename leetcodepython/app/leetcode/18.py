class Solution:
    # def fourSum(self, nums, target):
    #     nums.sort()
    #     results = []
    #     self.findNsum(nums, target, 4, [], results)
    #
    # def findNsum(self, nums, target, N, result, results):
    #     if len(nums) < N or N < 2:
    #         return
    #
    #     # solve 2 - sum
    #     if N == 2:
    #         l, r = 0, len(nums) - 1
    #         while l < r:
    #             if nums[l] + nums[r] == target:
    #                 results.append(result + [nums[l], nums[r]])
    #                 l += 1
    #                 r -= 1
    #                 while l < r and nums[l] == nums[l - 1]:
    #                     l += 1
    #                 while r > l and nums[r] == nums[r + 1]:
    #                     r -= 1
    #             elif nums[l] + nums[r] < target:
    #                 l += 1
    #             else:
    #                 r -= 1
    #     else:
    #         for i in range(0, len(nums) - N + 1): # careful about range
    #             if target < nums[i] * N or target > nums[-1] * N: # take adavantages of sorted list
    #                 break
    #             if i == 0 or i > 0 and nums[i - 1] != nums[i]:  # recursively reduce N
    #                 self.findNsum(nums[i+1:], target- nums[i], N - 1, result + [nums[i]], results)
    #     return


    # def fourSum(self, nums, target):
    #     def findNsum(nums, target, N, result, results):
    #         if len(nums) < N or N < 2 or target < nums[0] * N or target > nums[-1] * N: # early termination
    #             return
    #         if N == 2: # two pointers solve sorted 2-sum problem
    #             l, r = 0, len(nums) - 1
    #             while l < r:
    #                 s = nums[l] + nums[r]
    #                 if s == target:
    #                     results.append(result + [nums[l], nums[r]])
    #                     l += 1
    #                     while l < r and nums[l] == nums[l - 1]:
    #                         l += 1
    #                 elif s < target:
    #                     l += 1
    #                 else:
    #                     r -= 1
    #         else: # recursively reduce N
    #             for i in range(len(nums) - N + 1):
    #                 if i == 0 or (i > 0 and nums[i - 1] != nums[i]):
    #                     findNsum(nums[i+1:], target-nums[i], N - 1, result + [nums[i]], results)
    #
    #     results = []
    #     findNsum(sorted(nums), target, 4, [], results)
    #     return results


    # passing pointers, not sliced list
    def fourSum(self, nums, target):
        def findNsum(l, r, target, N, result, results):
            if r-l+1 < N or N < 2 or target < nums[l] * N or target > nums[r] * N: # early termination
                return
            if N == 2: # two pointers solve sorted 2-sum problem
                while l < r:
                    s = nums[l] + nums[r]
                    if s == target:
                        results.append(result + [nums[l], nums[r]])
                        l += 1
                        while l < r and nums[l] == nums[l - 1]:
                            l += 1
                    elif s < target:
                        l += 1
                    else:
                        r -= 1
            else: # recursively reduce N
                for i in range(l, r + 1):
                    if i == l or (i > l and nums[i - 1] != nums[i]):
                        findNsum(i + 1, r, target - nums[i], N - 1, result + [nums[i]], results)
        nums.sort()
        results = []
        findNsum(0, len(nums) - 1, target, 4, [], results)
        return results


if __name__ == '__main__':
    solution = Solution()
    print(solution.fourSum([1, 0, -1, 0, -2, 2], 0))

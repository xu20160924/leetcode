from typing import List


class Solution:
    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     n = len(nums)
    #     output = [[]]
    #
    #     for num in nums:
    #         output += [curr + [num] for curr in output]
    #     return output;

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     def backtrack(first = 0, curr = []):
    #         # if the Combination is done
    #         if len(curr) == k:
    #             output.append(curr[:])
    #         for i in range(first, n):
    #             # add nums[i] into the current Combination
    #             curr.append(nums[i])
    #             # use next integers to complete the Combination
    #             backtrack(i + 1, curr)
    #             # backtrack
    #             curr.pop()
    #
    #     output = []
    #     n = len(nums)
    #     for k in range(n + 1):
    #         backtrack()
    #     return output

    # def subsets(self, nums: List[int]) -> List[List[int]]:
    #     res = [[]]
    #     for i in nums:
    #         res = res + [[i] + num for num in res]
    #     return res

    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)

        def helper(i, tmp):
           res.append(tmp)
           for j in range(i, n):
               helper(j + 1, tmp + [nums[j]])
        helper(0, [])
        return res

if __name__ == '__main__':
    solution = Solution()
    solution.subsets([1, 2, 3])
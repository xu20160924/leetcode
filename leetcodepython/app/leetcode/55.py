from typing import List


class Solution:
    # def canJump(self, nums: List[int]) -> bool:
    #     for i in range(len(nums)):
    #         if not nums[i:i+nums[i]]:
    #             return False
    #     return True
    def canJump(self, nums: List[int]) -> bool:
        curr = nums[0]
        for i in range(1, len(nums)):
            if curr == 0:
                return False
            curr -= 1
            if nums[i] > curr:
                curr = nums[i]
        return True


if __name__ == '__main__':
    nums = [3,2,1,0,4]
    solution = Solution()
    solution.canJump(nums)

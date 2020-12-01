from typing import List


class Solution:
    def findRepeatNumber(self, nums: List[int]) -> int:
        for index, value in enumerate(nums):
            while index != value:
                if nums[value] == value:
                    return value
                nums[value], nums[index] = nums[index], nums[value]
        return -1
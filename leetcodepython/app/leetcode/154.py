from typing import List


class Solution(object):
    # def findMin(self, nums: List[int]) -> int:
    #     left, right = 0, len(nums) - 1
    #     while left < right:
    #         mid = (left + right) // 2
    #         if nums[mid] > nums[right]:
    #             left = mid + 1
    #         elif nums[mid] < nums[right]:
    #             right = mid
    #         else:
    #             right = right - 1
    #     return nums[left]

    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right = right - 1
        return nums[left]



if __name__ == '__main__':
    nums = [1,3,5]
    solution = Solution()
    print( solution.findMin(nums))
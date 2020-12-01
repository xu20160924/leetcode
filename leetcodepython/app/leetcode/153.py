class Solution(object):
    # def findMin(self, nums):
    #     if len(nums) == 1:
    #         return nums[0]
    #
    #     left = 0
    #     right = len(nums) - 1
    #
    #     if nums[right] > nums[0]:
    #         return nums[0]
    #
    #     while left > right:
    #         mid = left + (right - left) // 2
    #         if nums[mid] > nums[mid + 1]:
    #             return nums[mid + 1]
    #         elif nums[mid] < nums[mid - 1]:
    #             return nums[mid]
    #
    #         if nums[mid] > mid[right]:
    #             left = mid + 1
    #         elif nums[mid] < mid[right]:
    #             right = mid
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]
        l, r = 0, len(nums) - 1

        if nums[r] > nums[l]:
            return nums[l]

        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            elif nums[mid] < nums[mid - 1]:
                return nums[mid]

            if nums[mid] > mid[r]:
                l = mid + 1
            else:
                r = mid

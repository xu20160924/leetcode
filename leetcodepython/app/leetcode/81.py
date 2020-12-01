class Solution(object):
    # def search(self, nums, target):
    #     l, r = 0, len(nums) - 1
    #     while l <= r:
    #         mid = l + (r - l) // 2
    #         if nums[mid] == target:
    #             return True
    #         while l < mid and nums[l] == nums[mid]:
    #             l += 1
    #         if nums[l] <= nums[mid]:
    #             if nums[l] <= target < nums[mid]:
    #                 r = mid - 1
    #             else:
    #                 l = mid + 1
    #         else:
    #             if nums[mid] <= target < nums[r]:
    #                 l = mid + 1
    #             else:
    #                 r = mid - 1
    #     return False

    def search(self, nums, target):
        if not nums:
            return False
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                return True
            if nums[mid] < nums[r]:
                if nums[mid] < target <= nums[r]:
                    l = mid + 1
                else:
                    r = mid - 1
            elif nums[mid] > nums[r]:
                if nums[l] <= target < nums[mid]:
                    r = mid - 1
                else:
                    l = mid + 1
            else:
                r -= 1
        return nums[l] == target




if __name__ == '__main__':
    nums = [5,1,3]
    solution = Solution()
    solution.search(nums, 3)

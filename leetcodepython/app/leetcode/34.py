class Solution(object):
    def extreme_insertion_index(self, nums, target, left):
        lo = 0
        hi = len(nums)
        while lo < hi:
            mid = (lo + hi) // 2
            if nums[mid] > target or (left and nums[mid] == target):
                hi = mid
            else:
                lo = mid + 1
        return lo

    def searchRange(self, nums, target):
        left_indx = self.extreme_insertion_index(nums, target, True)
        if left_indx == len(nums) or nums[left_indx] != target:
            return [-1, -1]

        return [left_indx, self.extreme_insertion_index(nums, target, False) - 1]

if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    solution = Solution()
    solution.searchRange(nums, 8)
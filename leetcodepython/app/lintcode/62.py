class Solution:
    # def search(self, A, target):
    #     if not A:
    #         return -1
    #     left = 0
    #     right = len(A) - 1
    #     while left < right:
    #         mid = left + (right - left) // 2
    #         if A[mid] == target:
    #             return mid
    #         elif A[mid] > A[left] &&
    #         # elif A[left] > target and A[mid] > target:
    #         #     left = mid + 1
    #         # elif A[right] > target and A[mid] > target:
    #         #     right = mid
    #         else:
    #             left += 1
    #     return left if A[left] == target else -1

    # def search(self, nums, target):
    #     lo = 0
    #     hi = len(nums) - 1
    #     while lo <= hi:
    #         mid = lo + (hi - lo) // 2
    #         num = nums[mid]
    #         # nums[mid] and target at same side
    #         if (nums[mid] < nums[0]) == (target < nums[0]):
    #             num = nums[mid]
    #         else:
    #             num = float('-inf') if target < nums[0] else float('inf')
    #
    #         if num < target:
    #             lo = mid + 1
    #         elif num > target:
    #             hi = mid - 1
    #         else:
    #             return mid
    #     return -1

    def search(self, nums, target):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if target == nums[mid]:
                return mid

            # left part sorted
            if nums[start] <= nums[mid]:
                # target at here
                # cause into this include nums[start] == nums[mid] situation, so should include target >= nums[start]
                if target >= nums[start] and target < nums[mid]:
                    end = mid - 1
                else:
                    start = mid + 1
            # right part sorted
            else:
                # into this is greater nums[start] > nums[mid], so should include target <= nums[end]
                if target > nums[mid] and target <= nums[end]:
                    start = mid + 1
                else:
                    end = mid - 1

if __name__ == '__main__':
    solution = Solution()
    # print(solution.search([4,5,1,2,3], 1))
    # print(solution.search([4,5,1,2,3], 0))
    # print(solution.search([5], 5))
    # print(solution.search([6,8,9,1,3,5], 5))
    # print(solution.search([1, 2, 3], 1))
    # print(solution.search([1001,10001,10007,1,10,101,201], 10001))
    # print(solution.search([4, 5, 6, 7, 1, 2, 3], 1))
    print(solution.search([1, 2, 3], 1))

class Solution(object):
    def findDuplicate(self, nums):
        tortoise = nums[0]
        hare = nums[0]
        while True:
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
            if tortoise == hare:
                break
        ptr1 = nums[0]
        ptr2 = tortoise
        while ptr1 != ptr2:
            ptr1 = nums[ptr1]
            ptr2 = nums[ptr2]
        return ptr1


if __name__ == '__main__':
    nums = [2, 5, 9, 6, 9, 3, 8, 9, 7, 1]
    solution = Solution()
    solution.findDuplicate(nums)

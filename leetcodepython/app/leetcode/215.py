import random
from typing import List


class Solution(object):
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # 循环不变量 [left + 1, j] < pivot
        # (j, i) >= pivot
        def partition(nums, left, right):
            # 随机化切分元素
            # randint 是包括左右 区间的
            random_index = random.randint(left, right)
            nums[random_index], nums[left] = nums[left], nums[random_index]

            pivot = nums[left]
            j = left
            for i in range(left + 1, right + 1):
                if nums[i] < pivot:
                    j += 1
                    nums[i], nums[j] = nums[j], nums[i]
            nums[left], nums[j] = nums[j], nums[left]
            return j

        size = len(nums)
        target = size - k
        left = 0
        right = size - 1
        while True:
            index = partition(nums, left, right)
            if index == target:
                return nums[index]
            elif index < target:
                # 下一轮在[index + 1, right] 里找
                left = index + 1
            else:
                right = index - 1


    # def findKthLargest(self, nums: List[int], k: int) -> int:
    #     def __partition(nums, left, right):
    #         pivot = nums[left]
    #         j = left
    #         for i in range(left + 1, right + 1):
    #             if nums[i] < pivot:
    #                 j += 1
    #                 nums[i], nums[j] = nums[j], nums[i]
    #         nums[left], nums[j] = nums[j], nums[left]
    #         return j
    #
    #     size = len(nums)
    #
    #     target = size - k
    #     left = 0
    #     right = size - 1
    #     while True:
    #         index = __partition(nums, left, right)
    #         if index == target:
    #             return nums[index]
    #         elif index < target:
    #             # 下一轮再[index + 1, right] 里找
    #             left = index + 1
    #         else:
    #             right = index - 1

        # 循环不变量: [left + 1, j] < pivot
        # (j, i) >= pivot




    # def findKthLargest(self, nums, k):
    #     def partition(left, right, pivot_index):
    #         pivot = nums[pivot_index]
    #         # 1. move pivot to end
    #         nums[pivot_index], nums[right] = nums[right], nums[pivot_index]
    #
    #         # 2. move all smaller elements to the left
    #         store_index = left
    #         for i in range(left, right):
    #             if nums[i] < pivot:
    #                 nums[store_index], nums[i] = nums[i], nums[store_index]
    #                 store_index += 1
    #
    #         # 3. move pivot to its final place
    #         nums[right], nums[store_index] = nums[store_index], nums[right]
    #         return store_index
    #
    #     def select(left, right, k_smallest):
    #         if left == right:  # if the list contains only one element
    #             return nums[left]  # return
    #         # select a random pivot_index between
    #         pivot_index = random.randint(left, right)
    #
    #         # find the pivot position in a sorted list
    #         pivot_index = partition(left, right, pivot_index)
    #
    #         # the pivot is in its final sorted position
    #         if k_smallest == pivot_index:
    #             return nums[k_smallest]
    #         elif k_smallest < pivot_index:
    #             return select(left, pivot_index - 1, k_smallest)
    #         else:
    #             return select(pivot_index + 1, right, k_smallest)
    #     return select(0, len(nums) - 1, len(nums) - k)
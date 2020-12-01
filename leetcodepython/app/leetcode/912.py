import random


class Solution:
    def bubbleSort(self, nums):
        n = len(nums)
        for i in range(nums):
            for j in range(0, n - i - 1):
                if nums[j] > nums[j + 1]:
                    nums[j], nums[j + 1] = nums[j+1], nums[j]

    def insertionSort(self, nums):
        for i in range(1, len(nums)):
            key = nums[i]
            j = i - 1
            while j >= 0 and key < nums[j]:
                nums[j + 1] = nums[j]
                j -= 1
            nums[j + 1] = key

    def selectionSort(self, nums):
        for i in range(len(nums)):
            _min = min(nums[i:])
            min_index = nums[i:].index(_min)
            nums[i + min_index] = nums[i]
            nums[i] = _min
        return nums

    def quickSort(self, nums):
        def helper(head, tail):
            if head >= tail:
                return
            l, r = head, tail
            m = (r - l) // 2 + 1
            pivot = nums[m]
            while r >= l:
                while r >= l and nums[l] < pivot:
                    l += 1
                while r >= l and nums[r] > pivot:
                    r -= 1
                if r >= l:
                    nums[l], nums[r] = nums[r], nums[l]
                    l += 1
                    r -= 1
            helper(head, r)
            helper(l, tail)
        helper(0, len(nums) - 1)
        return nums

    def mergeSort(self, nums):
        if len(nums) > 1:
            mid = len(nums) // 2
            l = nums[:mid]
            r = nums[mid:]
            self.mergeSort(l)
            self.mergeSort(r)
            i = j = k = 0

            while i < len(l) and j < len(r):
                if l[i] < r[j]:
                    nums[k] = l[i]
                    i += 1
                else:
                    nums[k] = r[j]
                    j += 1
                k += 1
            while i < len(l):
                nums[k] = l[i]
                i += 1
                k += 1
            while j < len(r):
                nums[k] = r[j]
                j += 1
                k += 1

    def heapSort(self, nums):
        def heapify(nums, n, i):
            largest = i
            l = 2 * i + 1
            r = 2 * i + 2
            if l < n and nums[i] < nums[l]:
                largest = l
            if r < n and nums[largest] < nums[r]:
                largest = r
            if largest != i:
                nums[i], nums[largest] = nums[largest], nums[i]

                heapify(nums, n, largest)
        n = len(nums)
        for i in range(n, -1, -1):
            heapify(nums, n, i)
        for i in range(n - 1, 0, -1):
            nums[i], nums[0] = nums[0], nums[i]
            heapify(nums, i, 0)

    # def sortArray(self, nums):
    #     nodes = [Node(n) for n in nums]
    #     return [node.val for node in sorted(nodes)]

    def sortArray(self, nums):
        self.randomized_quicksort(nums, 0, len(nums) - 1)
        return nums

    ''' quick sort'''
    def randomized_partition(self, nums, l, r):
        pivot = random.randint(l, r)
        nums[pivot], nums[r] = nums[r], nums[pivot]
        i = l - 1
        for j in range(l, r):
            if nums[j] < nums[r]:
                i += 1
                nums[j], nums[i] = nums[i], nums[j]
        i += 1
        nums[i], nums[r] = nums[r], nums[i]
        return i

    def randomized_quicksort(self, nums, l, r):
        if r - l <= 0:
            return
        mid = self.randomized_partition(nums, l, r)
        self.randomized_quicksort(nums, l, mid - 1)
        self.randomized_quicksort(nums, mid + 1, r)



class Node:
    def __init__(self, val):
        self.val = val

    # lt means less than, le means less or equal than etc.
    def __lt__(self, other):
        return self.val < other.val
    # incase you need more logic
    # def __le__(self, other):
    #     return self.val <= other.val
    # def __eq__(self, other):
    #     return self.val == other.val
    # def __ne__(self, other):
    #     return self.val != other.val
    # def __gt__(self, other):
    #     return self.val > other.val
    # def __ge__(self, other):
    #     return self.val >= other.val






if __name__ == '__main__':
    solution = Solution()
    solution.sortArray([5, 2, 3, 1])

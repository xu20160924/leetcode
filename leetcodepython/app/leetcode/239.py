from collections import deque


class Solution(object):
    # def maxSlidingWindow(self, nums: 'List[int]', k: 'int') -> 'List[int]':
    #     n = len(nums)
    #     if n * k == 0:
    #         return []
    #     if k == 1:
    #         return nums
    #
    #     def clean_deque(i):
    #         # remove indexes of elements not from sliding window
    #         if deq and deq[0] == i - k:
    #             deq.popleft()
    #
    #         # remove from deq indexes of all elements
    #         # which are smaller than current element nums[i]
    #         while deq and nums[i] > nums[deq[-1]]:
    #             deq.pop()
    #
    #
    #     # init deque and output
    #     deq = deque()
    #     max_idx = 0
    #     for i in range(k):
    #         clean_deque(i)
    #         deq.append(i)
    #         # compute max in nums[:k]
    #         if nums[i] > nums[max_idx]:
    #             max_idx = i
    #
    #     output = [nums[max_idx]]
    #
    #     # build output
    #     for i in range(k, n):
    #         clean_deque(i)
    #         deq.append(i)
    #         output.append(nums[deq[0]])
    #     return output

    # def maxSlidingWindow(self, nums: 'List[int]', k: 'int') -> 'List[int]':
    #     n = len(nums)
    #     if n * k == 0:
    #         return []
    #     if k == 1:
    #         return nums
    #
    #     deq = deque()
    #     res = []
    #     for i in range(n):
    #         while deq and nums[deq[-1]] <= nums[i]:
    #             deq.pop()
    #
    #         deq.append(i)
    #
    #         if deq[0] == i - k:
    #             deq.popleft()
    #
    #         if i >= k - 1:
    #             res.append(nums[deq[0]])
    #
    #     return res

    def maxSlidingWindow(self, nums: 'List[int]', k: 'int') -> 'List[int]':
        n = len(nums)
        if n * k == 0:
            return []
        if k == 1:
            return nums

        left = [0] * n
        left[0] = nums[0]
        right = [0] * n
        right[n - 1] = nums[n - 1]

        for i in range(1, n):
            # from left to right
            if i % k == 0:
                left[i] = nums[i]
            else:
                left[i] = max(left[i - 1], nums[i])

            j = n - i - 1
            if (j + 1) % k == 0:
                right[j] = nums[j]
            else:
                right[j] = max(right[j + 1], nums[j])
        output = []
        for i in range(n - k + 1):
            output.append(max(left[i + k - 1], right[i]))

        return output






if __name__ == '__main__':
    # nums = [1,3,-1,-3,5,3,6,7]
    # k = 3
    nums = [4, -2]
    k = 2
    solution = Solution()
    print(solution.maxSlidingWindow(nums, k))
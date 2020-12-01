from collections import Counter
from typing import List


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counts = Counter(nums1)
        res = []
        for num in nums2:
            if counts[num] > 0:
                res += num,
                counts[num] -= 1
        return res

if __name__ == '__main__':
    nums1 = [1,2,2,1]
    nums2 = [2,2]
    solution = Solution()
    solution.intersect(nums1, nums2)
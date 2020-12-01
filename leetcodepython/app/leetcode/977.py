from typing import List


class Solution(object):
    def sortedSquares(self, A: List[int]) -> List[int]:
        return sorted(x * x for x in A)
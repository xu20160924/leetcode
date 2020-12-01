import heapq
from heapq import *


class MedianFinder:
    def __init__(self):
        # 当前大顶堆和小顶堆的元素个数之和
        self.count = 0
        self.max_heap = []
        self.min_heap = []

    def addNum(self, num: int) -> None:
        self.count += 1
        # 因为Python 中的堆默认是小顶堆, 所以要传入一个tuple,
        # 用于比较的元素需是相反数才能模拟出大顶堆的效果
        heapq.heappush(self.max_heap, -num)
        _, max_heap_top = heapq.heappop(self.max_heap)
        heapq.heappush(self.min_heap, max_heap_top)

        if self.count & 1:
            min_heap_top = heapq.heappop(self.min_heap)
            heapq.heappush(self.max_heap, -min_heap_top)

    def findMedian(self) -> float:
        if self.count & 1:
            # 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return self.max_heap[0]
        else:
            # 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (self.min_heap[0] + self.max_heap[0]) / 2

    # def __init__(self):
    #     self.small = []
    #     self.large = []
    #
    # def addNum(self, num):
    #     if len(self.small) == len(self.large):
    #         heappush(self.large, -heappushpop(self.small, -num))
    #     else:
    #         heappush(self.small, -heappushpop(self.large, num))
    #
    # def findMedian(self):
    #     if len(self.small) == len(self.large):
    #         return float(self.large[0] - self.small[0]) / 2.0
    #     else:
    #         return float(self.large[0])

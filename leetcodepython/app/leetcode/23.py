import heapq
from queue import PriorityQueue
from typing import List

from app.algorithm.Entity import ListNode


class Solution:
    # Merge with divide and conquer
    def mergeKLists(self, lists):
        amount = len(lists)
        interval = 1
        while interval < amount:
            for i in range(0, amount - interval, interval * 2):
                lists[i] = self.merge2Lists(lists[i], lists[i + interval])
            interval *= 2
        return lists[0] if amount > 0 else lists

    def merge2Lists(self, l1, l2):
        head = point = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                point.next = l1
                l1 = l1.next
            else:
                point.next = l2
                l2 = l2.next
            point = point.next
        if not l1:
            point.next = l2
        else:
            point.next = l1
        return head.next
    # def merge2Lists(self, l1, l2):
    #     head = point = ListNode(0)
    #     while l1 and l2:
    #         if l1.val <= l2.val:
    #             point.next = l1
    #             l1 = l1.next
    #         else:
    #             point.next = l2
    #             l2 = l2.next
    #         point = point.next
    #
    #     if not l1:
    #         point.next = l2
    #     else:
    #         point.next = l1
    #     return head.next

if __name__ == '__main__':
    solution = Solution()
    list_node11 = ListNode(1)
    list_node14 = ListNode(4)
    list_node15 = ListNode(5)
    list_node14.next = list_node15
    list_node11.next = list_node14


    list_node21 = ListNode(1)
    list_node23 = ListNode(3)
    list_node24 = ListNode(4)
    list_node23.next = list_node24
    list_node21.next = list_node23

    list_node32 = ListNode(2)
    list_node36 = ListNode(6)
    list_node32.next = list_node36

    lists = [list_node11, list_node21, list_node32]

    a = solution.mergeKLists(lists)
    print('dsf')


    # brute force
    # def mergeKLists(self, lists):
    #     self.nodes = []
    #     head = point = ListNode(0)
    #     for l in lists:
    #         while l:
    #             self.nodes.append(l.val)
    #             l = l.next
    #
    #     for x in sorted(self.nodes):
    #         point.next = ListNode(x)
    #         point = point.next
    #
    #     return head.next

    # def mergeKLists(self, lists):
    #     head = point = ListNode(0)
    #     q = PriorityQueue()
    #     for l in lists:
    #         if l:
    #             q.put((l.val, l))
    #
    #     while not q.empty():
    #         val, node = q.get()
    #         point.next = ListNode(val)
    #         point = point.next
    #         node = node.next
    #         if node:
    #             q.put((node.val, node))
    #     return head.next


    # def mergeKLists(self, lists):
    #     self.nodes = []
    #     head = point = ListNode(0)
    #
    #     for l in lists:
    #         while l:
    #             self.nodes.append(l.val)
    #             l = l.next
    #     for x in sorted(self.nodes):
    #         point.next = ListNode(x)
    #         point = point.next
    #     return head.next

    # PriorityQueue with Wrapper
    # def mergeKLists(self, lists):
    #     # Because ListNode dont havq __lt__ method, so make wrapper class
    #     class Wrapper():
    #         def __init__(self, node):
    #             self.node = node
    #         def __lt__(self, other):
    #             return self.node.val < other.node.val
    #
    #     head = point = ListNode(0)
    #     q = PriorityQueue()
    #     for l in lists:
    #         if l:
    #             # q.put((l.val, l))
    #             q.put(Wrapper(l))
    #     while not q.empty():
    #         # val, node = q.get()
    #         node = q.get().node
    #         point.next = node
    #         point = point.next
    #         node = node.next
    #         if node:
    #             # q.put((node.val, node))
    #             q.put(Wrapper(node))
    #     return head.next

    # using heapq
    # def mergeKLists(self, lists):
    #     h = [(l.val, idx) for idx, l in enumerate(lists) if l]
    #     heapq.heapify(h)
    #     head = cur = ListNode(None)
    #     while h:
    #         val, idx = heapq.heappop(h)
    #         cur.next = ListNode(val)
    #         cur = cur.next
    #         lists[idx] 前进一个 并将结果赋值给node
    #         node = lists[idx] = lists[idx].next
    #         if node:
    #             heapq.heapush(h, (node.val, idx))
    #     return head.next

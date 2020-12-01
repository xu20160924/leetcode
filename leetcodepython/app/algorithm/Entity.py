class ListNode(object):

    def __init__(self, x):
        self.val = x
        self.next = None

    def init_list(self, data):
        self.val = data[0]
        p = self
        for i in data[1:]:
            node = ListNode(i)
            p.next = node
            p = p.next
        return self

class RandomListNode(object):
    def __init__(self, x: int, next: 'ListNode' = None, random: 'ListNode' = None):
        self.val = int(x)
        self.next = next
        self.random = random

# class RandomListNode(ListNode):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#         self.rand = None
#
#     def init_list(self, data, rand):
#         self.val = data[0]
#         self.rand = rand[0]
#         p = self
#         for i, j in zip(data, rand):
#             node = RandomListNode(i)
#             p.next = node
#             p.rand =
#             p = p.next
#
#         return self

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Node:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None
    # @staticmethod
    # def build(data):
    #     while data:
    #         root = TreeNode(data[])
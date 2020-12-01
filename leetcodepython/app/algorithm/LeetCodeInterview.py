from collections import *
from typing import List
import json

from app.algorithm.Entity import TreeNode, ListNode


class Solution(object):
    def isUnique(self, str: str) -> bool:
        map = [False] * 26
        for s in str:
            if map[ord(s) - ord('a')]:
                return False
            map[ord(s) - ord('a')] = True
        return True

    def checkPermutation(self, s1: str, s2: str) -> bool:
        if len(s1) != len(s2): return False
        str1, str2 = 0, 0
        for i in range(len(s1)):
            str1 += ord(s1[i])
            str2 += ord(s2[i])

        return True if str1 == str2 else False

    def replaceSpaces(self, S: str, length: int) -> str:
        li = list(S)
        for i in range(length):
            if li[i] == ' ':
                li[i] = '%20'
        return li

    # def listOfDepth(self, tree: TreeNode) -> List[ListNode]:
    #
    #     res = []
    #     queue = deque()
    #     dummy, head = ListNode(0), ListNode(tree.val)
    #     dummy.next = head
    #     mark = tree.left
    #     while tree:
    #         if tree.left: queue.append(tree.left)
    #         if tree.right: queue.append(tree.right)
    #         if not mark and queue:
    #             mark = tree.right if not tree.left else tree.left
    #         if not queue or tree.val == mark.val and not mark:
    #             mark = tree.left if not tree.left else mark
    #             head = ListNode(tree.val)
    #             if dummy.next.next: res.append(dummy.next.next)
    #             dummy.next = head
    #             if not queue and dummy.next:
    #                 res.append(dummy.next)
    #                 break

    #
    # head.next = ListNode(tree.val)
    # head = head.next
    # tree = queue.popleft()

    # return res

    def listOfDepth(self, tree: TreeNode) -> List[ListNode]:
        res = []
        if not tree:
            return res
        stack = [tree]
        while stack:
            n = len(stack)
            head = ListNode(None)
            cur = head
            for i in range(n):
                node = stack.pop(0)
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
                cur.next = ListNode(node.val)

                cur = cur.next
            res.append(head.next)
        return res

    def inorderSuccessor(self, root: 'TreeNode', p: 'TreeNode') -> 'TreeNode':
        res = None
        if p.right:
            p = p.right
            while p.left:
                p = p.left
            return p
        while p != root:
            if p.val < root.val:
                res = root
                root = root.left
            else:
                root = root.right
        return res

    def BSTSequences(self, root: TreeNode) -> [[int]]:
        def merge(left, right, tmp, result, prefix):
            if len(left) == 0 and len(right) == 0:
                result.append([prefix] + tmp[:])
            if len(left) > 0:
                tmp.append(left[0])
                merge(left[1:], right, tmp, result, prefix)
                tmp.pop()
            if len(right) > 0:
                tmp.append(right[0])
                merge(left, right[1:], tmp, result, prefix)
                tmp.pop()

        def dfs(root):
            if root.left and root.right:
                left = dfs(root.left)
                right = dfs(root.right)
                cur_seq = []
                for l in left:
                    for r in right:
                        merge_result = []
                        merge(l, r, [], merge_result, root.val)
                        cur_seq.extend(merge_result)
                return cur_seq
            elif root.left:
                left = dfs(root.left)
                return [[root.val] + l for l in left]
            elif root.right:
                right = dfs(root.right)
                return [[root.val] + r for r in right]
            return [[root.val]]

        if root is None:
            return [[]]
        return dfs(root)



# head.val = tree.val
# head.next = ListNode(0)
# head = head.next
if __name__ == '__main__':
    pass
# [3,9,20,null,null,15,7]
# root = TreeNode(3)
# nine = TreeNode(9)
# twenty = TreeNode(20)
# fifty = TreeNode(15)
# seven = TreeNode(7)
# twenty.left = fifty
# twenty.right = seven
# root.left = nine
# root.right = twenty

# two = TreeNode(2)
# one = TreeNode(1)
# three = TreeNode(3)
# two.left = one
# two.right = three

# res = [[1] + l for l in range(3)]
# print(str())

# one = TreeNode(1)
# two = TreeNode(2)
# three = TreeNode(3)
# two.left = one
# two.right = three
# five = TreeNode(5)
# two = TreeNode(2)
# one = TreeNode(1)
# four = TreeNode(4)
# three = TreeNode(3)
#
# four.left = three
# two.left = one
# two.right = four
# five.left = two
#
# solution = Solution()
# res = solution.BSTSequences(five)
# print('over')



# root = TreeNode(5)
# two = TreeNode(2)
# three = TreeNode(3)
# four = TreeNode(4)
# five = TreeNode(5)
# six = TreeNode(6)
# seven = TreeNode(7)
# eight = TreeNode(8)
#
# four.left = eight
# two.left = four
# two.right = five
# three.right = seven
# root.left = two
# root.right = three

# solution = Solution()
# print(solution.listOfDepth(root))


class StackOfPlates(object):

    def __init__(self, cap: int):
        self.root = []
        self.cap = cap

    def push(self, val: int) -> None:
        if (not self.root or len(self.root[-1]) == self.cap) and self.cap > 0:
            d = deque()
            d.append(val)
            self.root.append(d)
        else:
            self.root[-1].append(val)

    def pop(self) -> int:
        if not self.root:
            return -1
        num = self.root[-1].pop()
        if len(self.root[-1]) == 0:
            self.root.pop()
        return num

    def popAt(self, index: int) -> int:
        if index >= len(self.root):
            return -1
        num = self.root[index].pop()
        if len(self.root[index]) == 0:
            self.root.pop(index)
        return num

# stackOfPlates.popAt(0)

# stackOfPlates.pop()
# stackOfPlates.pop()
# stackOfPlates.popAt(0)
# stackOfPlates.push(56)
# stackOfPlates.pop()
# stackOfPlates.popAt(4)
# stackOfPlates.pop()
# stackOfPlates.push(34)
# stackOfPlates.popAt(1)
# stackOfPlates.popAt(4)
# stackOfPlates.push(52)
# stackOfPlates.popAt(4)
# stackOfPlates.popAt(6)
# stackOfPlates.push(63)
# stackOfPlates.pop()
# stackOfPlates.popAt(6)
# stackOfPlates.popAt(6)
# stackOfPlates.popAt(1)
# stackOfPlates.pop()
# stackOfPlates.popAt(6)
# stackOfPlates.popAt(2)
# stackOfPlates.push(47)
# stackOfPlates.popAt(1)
# stackOfPlates.push(45)
# stackOfPlates.push(52)
# stackOfPlates.pop()
# stackOfPlates.popAt(6)
# stackOfPlates.popAt(6)
# stackOfPlates.push(20)
# stackOfPlates.popAt(4)
# stackOfPlates.push(17)
# stackOfPlates.pop()
# stackOfPlates.pop()
# stackOfPlates.push(43)
# stackOfPlates.push(6)
# stackOfPlates.push(30)
# stackOfPlates.popAt(2)
# stackOfPlates.popAt(3)
# stackOfPlates.pop()
# stackOfPlates.popAt(3)
# stackOfPlates.pop()
# stackOfPlates.pop()
# stackOfPlates.push(51)
# stackOfPlates.push(46)

# stackOfPlates.pop()
# stackOfPlates.pop()

# stackOfPlates.push(1)
# stackOfPlates.push(2)
# stackOfPlates.push(3)
# stackOfPlates.push(4)
# stackOfPlates.push(5)
# stackOfPlates.push(6)
# stackOfPlates.push(7)

# stackOfPlates.pop()
# stackOfPlates.pop()
# stackOfPlates.pop()
#
# stackOfPlates.popAt(2)


# print(ord('l') - ord('a'))
# print(ord('a') - ord('a'))
# print(ord('a') ^ ord('e'))
# solution = Solution()
# print(solution.isUnique("leetcode"))

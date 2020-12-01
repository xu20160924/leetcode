import bisect
from typing import List

from app.algorithm.Entity import TreeNode


class Solution:

    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        root = TreeNode(preorder[0])
        stack = [root]
        for value in preorder[1:]:
            if value < stack[-1].val:
                stack[-1].left = TreeNode(value)
                stack.append(stack[-1].left)
            else:
                while stack and stack[-1].val < value:
                    last = stack.pop()
                last.right = TreeNode(value)
                stack.append(last.right)
        return root
    # c = 0
    # def bstFromPreorder(self, A):
    #     if not A: return None
    #     self.c += 1
    #     print(self.c)
    #     root = TreeNode(A[0])
    #     i = bisect.bisect(A, A[0])
    #     root.left = self.bstFromPreorder(A[1:i])
    #     root.right = self.bstFromPreorder(A[i:])
    #     return root



        # self.c = 0
        # def helper(i, j):
        #     if i == j: return None
        #     self.c += 1
        #     print(self.c)
        #
        #     root = TreeNode(A[i])
        #     mid = bisect.bisect(A, A[i], i + 1, j)
        #     root.left = helper(i + 1, mid)
        #     root.right = helper(mid, j)
        #     return root
        # return helper(0, len(A))


if __name__ == '__main__':
    solution = Solution()
    solution.bstFromPreorder([8,5,1,7,10,12])


        # def helper(i, j):
        #     if i == j: return None
        #     root = TreeNode(A[i])
        #     mid = bisect.bisect(A, A[0])
        #     root.left = self.bstFromPreorder(A[1:i])
        #     root.right = self.bstFromPreorder(A[i:])
        #     return root

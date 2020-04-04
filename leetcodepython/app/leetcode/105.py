from typing import List

from app.algorithm.Entity import TreeNode


class Solution(object):
    # def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
    #     def helper(pre_start, in_start, in_end, preorder, inorder):
    #         if pre_start > len(preorder) - 1 or in_start > in_end:
    #             return
    #         root = TreeNode(preorder[pre_start])
    #         in_index = 0
    #         for i in range(in_start, in_end):
    #             if inorder[i] == root.val:
    #                 in_index = i
    #
    #         root.left = helper(pre_start + 1, in_start, in_index - 1, preorder, inorder)
    #         root.right = helper(preorder + in_index - in_start + 1, in_index + 1, in_end, preorder, inorder)
    #         return root
    #
    #     return helper(0, 0, len(inorder) - 1, preorder, inorder)


    # def buildTree(self, preorder, inorder):
    #     if inorder:
    #         ind = inorder.index(preorder.pop(0))
    #         root = TreeNode(inorder[ind])
    #         root.left = self.buildTree(preorder, inorder[0:ind])
    #         root.right = self.buildTree(preorder, inorder[ind+1:])
    #         return root

    def bulidTree(self, preorder, inorder):
        def build(stop):
            if inorder and inorder[-1] != stop:
                root = TreeNode(preorder.pop())
                root.left = build(root.val)
                inorder.pop()
                root.right = build(stop)
                return root
        preorder.reverse()
        inorder.reverse()
        return build(None)

if __name__ == '__main__':
        preorder = [3, 9, 20, 15, 7]
        inorder = [9, 3, 15, 20, 7]
        solution = Solution()
        solution.bulidTree(preorder, inorder)
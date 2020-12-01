from app.algorithm.Entity import TreeNode


class Solution(object):
    pass
    # def isBalanced(self, root: TreeNode) -> bool:
    #     return self.depth(root) != -1
    #
    # def depth(self, root):
    #     if not root: return 0
    #     left = self.depth(root.left)
    #     if left == -1:
    #         return -1
    #     right = self.depth(root.right)
    #     if right == -1:
    #         return -1
    #     return max(left, right) + 1 if abs(left - right) < 2 else -1


    #  top down
    # def depth(self, root):
    #     if not root:
    #         return 0
    #     left = self.depth(root.left)
    #     right = self.depth(root.right)
    #     return max(left, right) + 1
    #
    # def is_balanced(self, root: TreeNode) -> bool:
    #     if not root:
    #         return True
    #
    #     return abs(self.depth(root.left) - self.depth(root.right)) <= 1 and self.depth(root.left) and self.depth(root.right)

    # def dfsHeight(self, root: TreeNode):
    #     if not root:
    #         return 0
    #     left_height = self.dfsHeight(root.left)
    #     if left_height == -1:
    #         return -1
    #     right_height = self.dfsHeight(root.right)
    #     if right_height == -1:
    #         return -1
    #     if abs(left_height - right_height) > 1:
    #         return -1
    #     return max(left_height, right_height) + 1
    #
    #
    # def is_balanced(self, root: TreeNode) -> bool:
    #     return self.dfsHeight(root) != -1

if __name__ == '__main__':
    root = TreeNode(3)
    nine = TreeNode(9)
    twenty = TreeNode(20)
    fifty = TreeNode(15)
    seven = TreeNode(7)

    twenty.left = fifty
    twenty.right = seven

    root.left = nine
    root.right = twenty
    solution = Solution()
    solution.is_balanced(root)



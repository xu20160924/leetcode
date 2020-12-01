from typing import List

from app.algorithm.Entity import TreeNode


class Solution:
    # def kthSmallest(self, root: TreeNode, k: int) -> int:
    #     res = self.inorder(root, list())
    #     return res[k - 1]
    #
    # def inorder(self, root, l) -> List[int]:
    #     if not root:
    #         return l
    #     self.inorder(root.left, l)
    #     l.append(root.val)
    #     self.inorder(root.right, l)
    #     return l

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = list()

        while True:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right


root = TreeNode(5)
three = TreeNode(3)
two = TreeNode(2)
four = TreeNode(4)
six = TreeNode(6)
seven = TreeNode(7)

three.left = two
three.right = four
six.right = seven

root.left = three
root.right = six

solution = Solution()
print(solution.kthSmallest(root, 2))
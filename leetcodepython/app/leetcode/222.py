from app.algorithm.Entity import TreeNode


class Solution(object):
    def compute_depth(self, node: TreeNode):
        d = 0
        while node:
            d += 1
            node = node.left
        return d

    def exists(self, idx: int, d: int, node:TreeNode) -> bool:
        left, right = 0, 2**d - 1
        for _ in range(d):
            pivot = left + (right - left) / 2
            if idx <= pivot:
                node = node.left
                right = pivot
            else:
                node = node.right
                left = pivot + 1
        return node is not None

    def countNodes(self, root: TreeNode) -> int:
        if not root:
            return 0

        d = self.compute_depth(root)
        if d == 0:
            return 1

        left, right = 1, 2**d -1
        while left <= right:
            pivot = left + (right - left) // 2
            if self.exists(pivot, d, root):
                left = pivot + 1
            else:
                right = pivot - 1

        return (2**d - 1) + left


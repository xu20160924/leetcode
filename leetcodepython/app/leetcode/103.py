from typing import List

from app.algorithm.Entity import TreeNode


class Solution(object):
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        def dfs(node, res, level):
            if not node:
                return
            if len(res) <= level:
                res.append([])

            collection = res[level]
            if level % 2 == 0:
                collection.append(node.val)
            else:
                collection.insert(0, node.val)
            dfs(node.left, res, level + 1)
            dfs(node.right, res, level + 1)
        res = []
        if root:
            dfs(root, res, 0)
        return res
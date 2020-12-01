from app.algorithm.Entity import TreeNode


class Solution(object):
    def distributeCoins(self, root: TreeNode) -> int:
        self.ans = 0

        def dfs(node):
            if not node: return 0
            L, R = dfs(node.left), dfs(node.right)
            self.ans += abs(L) + abs(R)
            return node.val + L + R - 1
        dfs(root)
        return self.ans

if __name__ == '__main__':
    root = TreeNode(0)
    left = TreeNode(3)
    right = TreeNode(0)
    root.left = left
    root.right = right

    solution = Solution()
    solution.distributeCoins(root)

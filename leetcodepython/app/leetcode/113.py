import copy
from typing import List

from app.algorithm.Entity import TreeNode


class Solution(object):
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.res = []
        def dfs(root, sum, list=[]):
            if not root: return
            list.append(root.val)
            if not root.left and not root.right and sum == root.val:
                self.res.append(copy.copy(list))
                list.pop()
                return
            dfs(root.left, sum-root.val, list)
            dfs(root.right, sum-root.val, list)
            list.pop()
        dfs(root, sum)
        return self.res

if __name__ == '__main__':
    root = TreeNode(5)
    four = TreeNode(4)
    eight = TreeNode(8)
    eleven = TreeNode(11)
    thirteen = TreeNode(13)
    rightFour = TreeNode(4)
    seven = TreeNode(7)
    two = TreeNode(2)
    one = TreeNode(1)
    rightFive = TreeNode(5)

    eleven.left = seven
    eleven.right = two
    rightFour.right = one
    rightFour.left = rightFive
    eight.left = thirteen
    eight.right = rightFour
    four.left = eleven
    root.left = four
    root.right = eight

    solution = Solution()
    result = solution.pathSum(root, 22)
    print(result)
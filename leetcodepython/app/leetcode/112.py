from app.algorithm.Entity import TreeNode


class Solution(object):
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:
        if not root:
            return False
        if not root.left and not root.right:
            return sum == root.val
        return self.hasPathSum(root.left, sum=sum-root.val) or self.hasPathSum(root.right, sum=sum-root.val)


if __name__ == '__main__':
    # root = TreeNode(5)
    # four = TreeNode(4)
    # eight = TreeNode(8)
    # eleven = TreeNode(11)
    # thirteen = TreeNode(13)
    # rightFour = TreeNode(4)
    # seven = TreeNode(7)
    # two = TreeNode(2)
    # one = TreeNode(1)
    #
    # eleven.left = seven
    # eleven.right = two
    # rightFour.right = one
    # eight.left = thirteen
    # eight.right = four
    # four.left = eleven
    # root.left = four
    # root.right = eight

    solution = Solution()
    print(solution.hasPathSum(root, 22))



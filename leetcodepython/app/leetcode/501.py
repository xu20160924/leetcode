from typing import List

from app.algorithm.Entity import TreeNode


class Solution(object):
    def __init__(self):
        self.max_count, self.curr_count, self.mode_count, self.curr_val = 0, 0, 0, 0
        self.res = []

    def findMode(self, root: TreeNode) -> List[int]:

        def handle_value(val):
            if val != self.curr_val:
                self.curr_val = val
                self.curr_count = 0
            self.curr_count += 1
            if self.curr_count > self.max_count:
                self.max_count = self.curr_count
                self.mode_count = 1
            elif self.curr_count == self.max_count:
                if self.res:
                    self.res[self.mode_count] = self.curr_val
                self.mode_count += 1

        def inorder(root):
            if not root:
                return
            inorder(root.left)
            handle_value(root.val)
            inorder(root.right)

        # first get highest occurrences in tree
        inorder(root)
        self.res = [0 for _ in range(self.mode_count)]
        self.mode_count = 0
        self.curr_count = 0
        # find mode
        inorder(root)
        return self.res

if __name__ == '__main__':
    root = TreeNode(6)
    two = TreeNode(2)
    eight = TreeNode(8)
    zero = TreeNode(0)
    four = TreeNode(4)
    seven = TreeNode(7)
    nine = TreeNode(9)
    twotwo = TreeNode(2)
    eigtheight = TreeNode(8)

    zero.left = twotwo
    zero.right = eigtheight
    two.left = zero
    two.right = four
    eight.left = seven
    eight.right = nine
    root.left = two
    root.right = eight

    solution = Solution()
    print(solution.findMode(root))
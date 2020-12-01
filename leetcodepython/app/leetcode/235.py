from app.algorithm.Entity import TreeNode


class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        parent_val, p_val, q_val = root.val, p.val, q.val

        if p.val > parent_val and q.val > parent_val:
            self.lowestCommonAncestor(root.left, p, q)
        elif p.val < parent_val and q.val < parent_val:
            self.lowestCommonAncestor(root.right, p, q)
        else:
            return root


if __name__ == '__main__':
    six = TreeNode(6)
    two = TreeNode(2)
    eight = TreeNode(8)

    six.left = two
    six.right = eight
    solution = Solution()
    solution.lowestCommonAncestor(six, two, eight)
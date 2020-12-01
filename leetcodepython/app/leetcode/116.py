from app.algorithm.Entity import TreeNode


class Solution:
    def connect(self, root):
        rootp = root
        while rootp and rootp.left:
            next = rootp.left
            while rootp:
                rootp.left.next = rootp.right
                # shortcut for
                #     if root.next:
                #         root.right.next = root.next.left
                #     else:
                #         root.right.next = None
                rootp.right.next = rootp.next and rootp.next.left
                rootp = rootp.next
            rootp = next
        return root

if __name__ == '__main__':
    root = TreeNode(1)
    two = TreeNode(2)
    three = TreeNode(3)
    four = TreeNode(4)
    five = TreeNode(5)
    six = TreeNode(6)
    seven = TreeNode(7)

    two.left = four
    two.right = five
    three.left = six
    three.right = seven
    root.left = two
    root.right = three

    solution = Solution()
    solution.connect(root)
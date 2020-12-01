class Solution(object):
    # def __init__(self):
    #     self.ans = None
    #
    # def lowestCommonAncestor(self, root, p, q):
    #     def recurse_tree(current_node):
    #         if not current_node: return False
    #
    #         left = recurse_tree(current_node.left)
    #         right = recurse_tree(current_node.right)
    #
    #         mid = current_node == q or current_node == p
    #         if (mid + left + right) >= 2:
    #             self.ans = current_node
    #
    #         return mid or left or right
    #     recurse_tree(root)
    #     return self.ans

    # def lowestCommonAncestor(self, root, p, q):
    #     stack = [root]
    #     parent = {root: None}
    #     while p not in parent or q not in parent:
    #         node = stack.pop()
    #         if node.left:
    #             parent[node.left] = node
    #             stack.append(node.left)
    #         if node.right:
    #             parent[node.right] = node
    #             stack.append(node.right)
    #
    #     ancestors = set()
    #     while p:
    #         ancestors.add(p)
    #         p = parent[p]
    #
    #     while q not in ancestors:
    #         q = parent[q]
    #     return q

    BOTH_PENDING = 2
    LEFT_DONE = 1
    BOTH_DONE = 0
    def lowestCommonAncestor(self, root, p, q):
        stack = [(root, Solution.BOTH_PENDING)]
        one_node_found = False
        LCA_index = -1
        while stack:
            parent_node, parent_state = stack[-1]
            if parent_state != Solution.BOTH_DONE:
                if parent_state == Solution.BOTH_PENDING:
                    if parent_node == p or parent_node == q:
                        if one_node_found:
                            return stack[LCA_index][0]
                        else:
                            one_node_found = True
                            LCA_index = len(stack) - 1
                    child_node = parent_node.left
                else:
                    child_node = parent_node.right
                stack.pop()
                stack.append((parent_node, parent_state - 1))
                if child_node:
                    stack.append((child_node, Solution.BOTH_PENDING))
            else:
                if one_node_found and LCA_index == len(stack) - 1:
                    LCA_index -= 1
                stack.pop()
        return None
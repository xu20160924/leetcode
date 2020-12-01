from app.algorithm.Entity import RandomListNode, ListNode


class Solution(object):
    # Solution from leetcode
    def copyRandomList(self, head):

        # Insert each node's copy right after it, already copy .label
        node = head
        while node:
            copy = RandomListNode(node.val)
            copy.next = node.next
            node.next = copy
            node = copy.next

        # Set each copy's .random
        node = head
        while node:
            node.next.random = node.random and node.random.next
            node = node.next.next

        # Separate the copied list from the original, (re)setting every .next
        node = head
        copy = head_copy = head and head.next
        while node:
            node.next = node = copy.next
            copy.next = copy = node and node.next

        return head_copy

    def copyRandomList2(self, head: 'None') -> 'None':
        # create new nodes
        node = head
        while node:
            node.random, node = RandomListNode(node.val, node.random, None), node.next
        # populate random field of the new node
        node = head
        while node:
            node.random.random, node = node.random.next.random if node.random.next else None, node.next
            # restore original list and build new list
        head_copy, node = head.random if head else None, head
        while node:
            node.random.next, node.random, node = node.next.random if node.next else None, node.random.next, node.next
        return head_copy


if __name__ == '__main__':
    # listNode1 = RandomListNode(1)
    # listNode2 = RandomListNode(2)
    # listNode3 = RandomListNode(3)


    node3 = RandomListNode(3)
    node2 = RandomListNode(2, next=node3, random=None)
    node1 = RandomListNode(1, node2)
    node1.random = node3
    node3.random = node1

    solution = Solution()
    result = solution.copyRandomList2(node1)
    print(result)
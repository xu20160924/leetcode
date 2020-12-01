from app.algorithm.Entity import ListNode


class Solution(object):
    def rotateRight(self, head: 'ListNode', k: 'int') -> 'ListNode':
        if not head:
            return None
        if not head.next:
            return head

        old_tail = head
        n = 1
        while old_tail.next:
            old_tail = old_tail.next
            n += 1
        old_tail.next = head

        new_tail = head
        for i in range(n - k % n - 1):
            new_tail = new_tail.next
        new_head = new_tail.next
        new_tail.next = None
        return new_head

if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(3)
    node4 = ListNode(4)
    node5 = ListNode(5)

    node4.next = node5
    node3.next = node4
    node2.next = node3
    node1.next = node2

    solution = Solution()
    solution.rotateRight(node1, 2)
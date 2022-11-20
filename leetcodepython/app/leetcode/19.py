from app.algorithm.Entity import ListNode


class Solution(object):
    # def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
    #     dummy = ListNode()
    #     dummy.next = head
    #     length = 0
    #     first = head
    #     while first:
    #         length += 1
    #         first = first.next
    #
    #     length -= n
    #     first = dummy
    #     while length > 0:
    #         length -= 1
    #         first = first.next
    #
    #     first.next = first.next.next
    #     return dummy.next

    # def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
    #     dummy = ListNode(0)
    #     dummy.next = head
    #     first, second = dummy, dummy
    #     for i in range(n):
    #         first = first.next
    #     while first:
    #         first = first.next
    #         second = second.next
    #     second.next = second.next.next
    #     return dummy.next

    # def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
    #     dummy = ListNode(0)
    #     dummy.next, fast, slow = head, dummy,dummy
    #     while fast:
    #         fast, n = fast.next, n - 1
    #         if not n > -2:
    #             slow = slow.next
    #     slow.next = slow.next.next
    #     return dummy.next


    # def removeNthFromEnd(self, head, n):
    #     def index(node):
    #         if not node:
    #             return 0
    #         i = index(node.next) + 1
    #         if i > n:
    #             node.next.val = node.val
    #         return i
    #     index(head)
    #     return head.next

    # def removeNthFromEnd(self, head, n):
    #     def remove(head):
    #         if not head:
    #             return 0, head
    #         i, head.next = remove(head.next)
    #         return i+1, (head, head.next)[i+1 == n]
    #     return remove(head)[1]

    def removeNthFromEnd(self, head, n):
        fast = slow = head
        for _ in range(n):
            fast = fast.next
        if not fast:
            return head.next
        while fast.next:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return head

if __name__ == '__main__':
    one = ListNode(1)
    two = ListNode(2)
    three = ListNode(3)
    four = ListNode(4)
    five = ListNode(5)

    four.next = five
    three.next =  four
    two.next = three
    one.next = two
    solution = Solution()
    solution.removeNthFromEnd(one, 2)





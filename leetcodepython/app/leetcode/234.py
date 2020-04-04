from app.algorithm.Entity import ListNode


class Solution(object):
    # def isPalindrome(self, head):
    #     rev = None
    #     slow = fast = head
    #     while fast and fast.next:
    #         fast = fast.next.next
    #         rev, rev.next, slow = slow, rev, slow.next
    #     if fast:
    #         slow = slow.next
    #     while rev and rev.val == slow.val:
    #         slow = slow.next
    #         rev = rev.next
    #     return not rev
    #
    # def isPalindrome(self, head):
    #     rev = None
    #     fast = head
    #     while fast and fast.next:
    #         fast = fast.next.next
    #         rev, rev.next, head = head, rev, head.next
    #
    #     tail = head.next if fast else head
    #     isPali = True
    #     while rev:
    #         isPali = isPali and rev.val == tail.val
    #         head, head.next, rev = rev, head, rev.next
    #         tail = tail.next
    #     return isPali

    # def isPalindrome(self, head: ListNode) -> bool:
    #     vals = []
    #     current_node = head
    #     while current_node is not None:
    #         vals.append(current_node.val)
    #         current_node = current_node.next
    #     return vals == vals[::-1]

    # def isPalindrome(self, head: ListNode) -> bool:
    #     self.front_pointer = head
    #
    #     def recursively_check(current_node=head):
    #         if current_node is not None:
    #             if not recursively_check(current_node.next):
    #                 return False
    #             if self.front_pointer.val != current_node.val:
    #                 return False
    #             self.front_pointer = self.front_pointer.next
    #         return True
    #
    #     return recursively_check()
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None:
            return True
        first_half_end = self.end_of_first_half(head)
        second_half_start = self.reverse_list(first_half_end.next)

        result = True
        first_position = head
        second_position = second_half_start
        while result and second_half_start is not None:
            if first_position.val != second_position.val:
                result = False
            first_position = first_position.next
            second_position = second_position.next

        first_half_end.next = self.reverse_list(second_half_start)
        return result

    def end_of_first_half(self, head):
        fast = head
        slow = head
        while fast.next is not None and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next
        return slow

    def reverse_list(self, head):
        previous = None
        current = head
        while current is not None:
            next_node = current.next
            current.next = previous
            previous = current
            current = next_node
        return previous

if __name__ == '__main__':
    # node = ListNode(0)
    # node = node.init_list([1, 2, 3, 2, 1])
    # solution = Solution()
    # solution.isPalindrome(node)

    one = ListNode(1)
    two = ListNode(2)
    three = ListNode(2)
    four = ListNode(1)

    three.next = four
    two.next = three
    one.next = two

    solution = Solution()
    print(solution.isPalindrome(one))

class Solution(object):
    # def countSmaller(self, nums):
    #     def sort(enum):
    #         half = int(len(enum) / 2)
    #         if half:
    #             left, right = sort(enum[:half]), sort(enum[half:])
    #             for i in range(len(enum))[::-1]:
    #                 if not right or left and left[-1][1] > right[-1][1]:
    #                     smaller[left[-1][0]] += len(right)
    #                     enum[i] = left.pop()
    #                 else:
    #                     enum[i] = right.pop()
    #         return enum
    #     smaller = [0] * len(nums)
    #     sort(list(enumerate(nums)))
    #     return smaller

    # def countSmaller(self, nums):
    #     def sort(enum):
    #         half = len(enum) // 2
    #         if half:
    #             left = sort(enum[:half])
    #             right = sort(enum[half:])
    #             # left, right = sort(enum[:half]), sort(enum[half:])
    #             for i in range(len(enum))[::-1]:
    #                 if not right or left and left[-1][1] > right[-1][1]:
    #                     smaller[left[-1][0]] += len(right)
    #                     enum[i] = left.pop()
    #                 else:
    #                     enum[i] = right.pop()
    #         return enum
    #
    #     smaller = [0] * len(nums)
    #     sort(list(enumerate(nums)))
    #     return smaller

    # def countSmaller(self, nums):
    #     def sort(indexes):
    #         half = len(indexes) // 2
    #         if half:
    #             left, right = sort(indexes[:half]), sort(indexes[half:])
    #             for i in range(len(indexes))[::-1]:
    #                 if not right or left and nums[left[-1]] > nums[right[-1]]:
    #                     smaller[left[-1]] += len(right)
    #                     indexes[i] = left.pop()
    #                 else:
    #                     indexes[i] = right.pop()
    #         return indexes
    #     smaller = [0] * len(nums)
    #     sort(range(len(nums)))
    #     return smaller

    def countSmaller(self, nums):
        def sort(indexes):
            half = len(indexes) // 2
            if half:
                left, right = sort(indexes[:half]), sort(indexes[half:])
                for i in range(len(indexes))[::-1]:
                    if not right or left and nums[left[-1]] > nums[right[-1]]:
                        smaller[left[-1]] += len(right)
                        indexes[i] = left.pop()
                    else:
                        indexes[i] = right.pop()
            return indexes

        smaller = [0] * len(nums)
        sort(range(len(nums)))
        return smaller



if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solution = Solution()
    print(solution.countSmaller(nums))

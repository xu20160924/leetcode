import collections
import heapq
import re
from typing import List
from interval import Interval
import intervals as I

import numpy as np
import math

from pip._vendor.urllib3.connectionpool import xrange

from app.algorithm.Entity import ListNode, TreeNode


def quick_sort(L):
    return q_sort(L, 0, len(L) - 1)


def q_sort(L, left, right):
    if left < right:
        pivot = Partition(L, left, right)

        """
        通过上一步划分之后， 再对两部分及逆行同样的方法进行排序
        """
        q_sort(L, left, pivot - 1)
        q_sort(L, pivot + 1, right)
    return L


def Partition(L, left, right):
    """
    这里分组基准的选取只是取列表的第一个值，
    太过于随便，当取到序列的中间值时，
    快排效率是最高的，第一个值未必是列表的中间值。
    为了解决这个问题，我们可以选取列表中的几个值进行简单的比较，
    然后取这几个值的中间值 作为分组基准。
    """
    pivotkey = L[left]

    while left < right:
        while left < right and L[right] >= pivotkey:
            right -= 1
        L[left] = L[right]
        while left < right and L[left] <= pivotkey:
            left += 1
        L[right] = L[left]
    L[left] = pivotkey
    return left


# array = [5, 9, 1, 11, 6, 7, 2, 4]
# print('result:' + str(quick_sort(array)))
"""
get Near less num of current both sides
No Repeat
"""


def getNearLessNoRepeat(array):
    res = [[0 for y in range(2)] for x in range(len(array))]
    stack = []
    for index, item in enumerate(array):
        while stack and array[stack[-1]] > array[index]:
            popIndex = stack.pop()
            leftLessIndx = -1 if not stack else stack[-1]
            res[popIndex][0] = leftLessIndx
            res[popIndex][1] = index

        stack.append(index)

    while stack:
        popIndexs = stack.pop()
        leftLessIndexa = -1 if not stack else stack[-1]
        res[popIndexs][0] = leftLessIndexa
        res[popIndexs][1] = -1

    return res


"""
get near more num of current both sides
No repeat
"""


def getNearMoreNoReapeat(array):
    res = [[0 for y in range(2)] for x in range(len(array))]
    stack = []
    for index, item in enumerate(array):
        while stack and array[stack[-1]] < array[index]:
            popIndex = stack.pop()
            leftMoreIndex = -1 if not stack else stack[-1]
            res[popIndex][0] = leftMoreIndex
            res[popIndex][1] = index
        stack.append(index)

    while stack:
        popIndex = stack.pop()
        leftMoreIndex = -1 if not stack else stack[-1]
        res[popIndex][0] = leftMoreIndex
        res[popIndex][1] = -1

    return res


"""
get near less between left and right have repeat number
from book
"""


def getNearLess(arry):
    res = [[len(arry)], 2]
    stack = [[]]
    for index, item in enumerate(arry):
        while stack and stack[-1][0] > arry[index]:
            popIs = stack.pop()
            leftLessIndex = -1 if stack else stack[-1][len(stack[-1]) - 1]
            for item in popIs:
                res[item][0] = leftLessIndex
                res[item][1] = index
        if stack and arry[stack[-1][0]] == arry[index]:
            stack[-1].append(index)
        else:
            list = []
            list.append(index)
            stack.append(list)

    while stack:
        popIs = []
        leftLessIndex = -1 if stack else stack[-1][len(stack[-1]) - 1]

    for item in popIs:
        res[item][0] = leftLessIndex
        res[item][1] = -1

    return res


def set_intersection(self, set1, set2):
    return [x for x in set1 if x in set2]


def array_intersection(array1, array2):
    set1 = set(array1)
    set2 = set(array2)
    if len(array1) > len(array2):
        return set_intersection(set2, set1)
    else:
        return set_intersection(set1, set2)


def intersection(nums1, nums2):
    set1 = set(nums1)
    set2 = set(nums2)
    return list(set1 & set2)


def findKMax(array, k):
    stack = [k]
    for index, item in enumerate(array):
        while stack and stack[-1] < array[index]:
            stack.pop()
            stack.append(array[index])

    return stack[-1]


# def findKthLargest(array, k):
#     return head


"""
3 无重复字符的最长子串
"""


def getNoReapetSubStr(aaa):
    str = []
    for i in aaa:
        str.append(i)
        print(str[-1])
        print(i)
        if len(str) > 1 and str[-1] is i:
            str = []
    return len(str)


# str = 'abcabcbb'
# print(getNoReapetSubStr(str))

"""
1 two sum 
This way time is long
"""
# def twoSum(array, target):
#     length = len(array)
#     j = -1
#     for i in range(length):
#         if (target - array[i]) in array:
#             # if value that found equals current value and disappear once so means that is itself
#             if (array.count(target - array[i]) == 1) & (target - array[i] == array[i]):
#                 continue
#             else:
#                 j = array.index(target - array[i], i+1)
#                 break
#     if j > 0:
#         return [i, j]
#     else:
#         return []

# def twoSum(array, target):
#     dct = {}
#     for i, n in enumerate(array):
#         if target - n in dct:
#             return [dct[target -n], i]
#         dct[n] = i
# def two_sum(nums, target):
#     """这样写更直观，遍历列表同时查字典"""
#     dct = {}
#     for i, n in enumerate(nums):
#         if target - n in dct:
#             return [dct[target - n], i]
#         dct[n] = i   put item value:index

"""
1.       https://leetcode-cn.com/problems/two-sum/solution/xiao-bai-pythonji-chong-jie-fa-by-lao-la-rou-yue-j/
"""
# def twoSum(array, target):
#     length = len(array)
#     j = -1
#     for i in range(1, length):
#         temp = array[:i]
#         if (target - array[i]) in temp:
#             j = temp.index(target - array[i])
#             break
#     if j >= 0:
#         return [j, i]

"""
1   two sum using map 
"""
# def twoSum(arrary, target):
#     hashmap = {}
#     for ind, num in enumerate(array):
#        hashmap[num] = ind
#     for i, num in enumerate(hashmap):
#         j = hashmap.get(target - num)
#         if j is not None and i != j:
#             return [i, j]

"""
1. two sum
"""


def twoSum(array, target):
    hashmap = {}
    for i, n in enumerate(array):
        if hashmap.get(target - n):
            return [i, hashmap.get(target - n)]
        hashmap[n] = i


# def converseStrToInt(str):
#     if not str:
#         return 0
#     result = ''
#     for i in range(str):
#         if (i is not '-' and not str(i).isdigit()):
#             return 0
#         if i is None:
#             continue
#         str(result).append('-')
#
"""
8 
首先，这个假设对于 Python 不成立，
Python 不存在 32 位的 int 类型。其次，
即使搜索到的字符串转32位整数可能导致溢出，
我们也可以直接通过字符串判断是否存在溢出的情况
（比如 try 函数 或 判断字符串长度 + 字符串比较），
聪明的你应该会解决这个问题吧？
via regular expression
"""


def myAtoi(str):
    return max(min(int(*re.findall('^[\+\-]?\d+', str.lstrip())), 2 ** 31 - 1), -2 ** 31)


"""
15  three sum  error example  myself
"""


# def threeSum(array):
#     negativemap = {}
#     positivemap = {}
#     res = []
#     # zero = 0
#     for i, n in enumerate(array):
#         # if n == 0:
#         #     zero+=1
#         #     if zero == 3:
#         #         res.append([0,0,0])
#         if n >= 0:
#             positivemap[n] = 1 if positivemap.get(n) is None else positivemap.get(n) + 1
#         if n < 0:
#             negativemap[-n] = 1 if negativemap.get(n) is None else negativemap.get(n) + 1
#     for i, n in enumerate(negativemap):
#         if positivemap.get(0) is not None and positivemap.get(0) == 3:
#             res.append([0,0,0])
#         if positivemap.get(0) is not None and positivemap.get(n) is not None:
#             res.append([-n, 0, n])
#         if negativemap.get(n) > 1:
#            if positivemap.get(n + n) is not None:
#                res.append([-n, -jn, positivemap.get(n + jn)])
#         else:
#             for j, jn in enumerate(negativemap):
#                 if positivemap.get(n + jn) is not None:
#                     res.append([-n, -jn, positivemap.get(n + jn)])
#     return res

# temp = [0,0]
# while len(temp) < 3:
# for j in range(2):
# while len(temp) <= 3:
#     temp[j] = array[i]
#     if temp[0] + temp[1] >= 0 and positivemap.get(temp[0] + temp[1]):
#         temp.append(positivemap.get(temp[0] + temp[1]))
#         # temp[2] = positivemap.get(temp[0] + temp[1])
#     elif temp[0] + temp[1] < 0 and negativemap.get(temp[0] + temp[1]):
#         temp.append(-negativemap.get(temp[0] + temp[1]))
#         # temp[2] = -negativemap.get(temp[0] + temp[1])
# if len(temp) == 3:
#     res.append(temp)


def threeSum(nums: List[int]):
    n = len(nums)
    res = []
    if not nums or n < 3:
        return []
    nums.sort()
    for i in range(n):
        if (nums[i] > 0):
            return res
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        L = i + 1
        R = n - 1
        while (L < R):
            if nums[i] + nums[L] + nums[R] == 0:
                res.append(nums[i], nums[L], nums[R])
                while L < R and nums[L] == nums[L + 1]:
                    L = L + 1
                while L < R and nums[R] == nums[R - 1]:
                    R = R - 1
                L = L + 1
                R = R - 1
            elif (nums[i] + nums[L] + nums[R] > 0):
                R = R - 1
            else:
                L = L + 1
    return res


"""
error 
find max sub matrix
from book
"""
#  error
# def findMaxSubMatrix(matrix):
#     array = np.zeros(matrix[0].size)
#     for row in matrix:
#         for jdx, item in enumerate(row):
#             array[jdx] = (0 if item == 0 else array[jdx] + item)

# temp = array[0]
# for i, item in enumerate(array):
#     if array[i] != 0 and array[i] < temp:
#         temp = array[i]
#     if array[i] == 0:
#         array = np.delete(array, i)
# return temp * array.size

"""                   
error myself code                 
find max sub matrix   
from book             
"""
# def findMaxSubMatrix(matrix):
#     array = [0 for i in range(len(matrix[0]))]
#     for row in matrix:
#         for jdx, item in enumerate(row):
#             array[jdx] = (0 if row[jdx] == '0' else int(array[jdx]) + int(row[jdx]))

# temp = array[0]
# for i, item in enumerate(array):
#     if array[i] != '0' and array[i] < temp:
#         temp = array[i]
#     if array[i] == '0':
#         array.remove(i)
# return temp * len(array)


# matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
# print(findMaxSubMatrix(matrix))
"""
find max sub matrix
from book
"""


def maxRecSize(matrix):
    height = [0 for i in range(len(matrix[0]))]
    max_area = 0
    for j, row in enumerate(matrix):
        for i, nums in enumerate(row):
            height[i] = (0 if nums == 0 else height[i] + 1)
        max_area = max(max_rec_from_bottom(height), max_area)
    return max_area


def max_rec_from_bottom(height):
    max_area = 0
    stack = []
    for i, num in enumerate(height):
        while stack and num <= height[stack[-1]]:
            j = stack.pop()
            k = -1 if not stack else stack[-1]
            cur_area = (i - k - 1) * height[j]
            max_area = max(max_area, cur_area)
        stack.append(i)
    while stack:
        j = stack.pop()
        k = -1 if not stack else stack[-1]
        cur_area = (len(height) - k - 1) * height[j]
        max_area = max(max_area, cur_area)

    return max_area


"""
get nearest min number between left and right  
from book
"""


def getNearLessNoRepeat(arr):
    res = [[0 for i in range(2)] for j in range(len(arr))]
    stack = []
    for index, item in enumerate(arr):
        while stack and arr[stack[-1]] > item:
            popIndex = stack.pop()
            left_less_index = -1 if not stack else stack[-1]
            res[popIndex][0] = left_less_index
            res[popIndex][1] = index

        stack.append(index)

    # at end should clear stack
    while stack:
        pop_index = stack.pop()
        left_less_index = -1 if not stack else stack[-1]
        res[pop_index][0] = left_less_index
        res[pop_index][1] = -1

    return res


class Record():
    def __init__(self, value):
        self.value = value
        self.times = 1


"""
get num
from book
"""


def get_num(arr, num):
    qmin = []
    qmax = []
    i = 0
    j = 0
    res = 0
    while i < len(arr):
        while j < len(arr):
            if not qmin or qmin[-1] != j:
                while qmin and arr[qmin[-1]] >= arr[j]:
                    qmin.pop()
                qmin.append(j)
                while qmax and arr[qmax[-1]] <= arr[i]:
                    qmax.pop()
                qmax.append(j)
            if arr[qmax[0]] - arr[qmin[0]] > num:
                break
            j += 1
        res += j - i
        if qmin[0] == i:
            qmin.pop(0)
        if qmax[0] == i:
            qmax.pop(0)
        i += 1

    return res


"""                                              
visible mountains                                
from book                                        
"""


def get_internal_sum(k):
    return 0 if k == 1 else (k * (k - 1) / 2)


"""                                                 
visible mountains                                   
from book                                           
"""


def next_index(i, size):
    return (i + 1) if i < (size - 1) else 0


"""
visible mountains 
from book
"""


def get_visible_num(arr):
    if not arr or len(arr) < 2:
        return 0
    size = len(arr)
    max_index = 0
    # find max index
    for i, item in enumerate(arr):
        max_index = i if arr[max_index] < item else max_index

    stack = []
    stack.append(Record(arr[max_index]))
    index = next_index(max_index, size)
    res = 0
    while index != max_index:
        while stack[-1].value < arr[index]:
            k = stack.pop().times
            res += get_internal_sum(k) + 2 * k

        if stack[-1].value == arr[index]:
            stack[-1].times += 1
        else:
            stack.append(Record(arr[index]))

        index = next_index(index, size)

    while len(stack) > 2:
        times = stack.pop().times
        res += get_internal_sum(times) + 2 * times

    if len(stack) == 2:
        times = stack.pop().times
        res += get_internal_sum(times) + times if stack[-1] == 1 else 2 * times

    res += get_internal_sum(stack.pop().times)
    return res


"""
2. tow number add
"""


def add_two_numbers(l1, l2):
    list_node = ListNode(0)
    p, q, curr, carry = l1, l2, list_node, 0
    x, y = 0, 0
    while p or q:
        if p.val:
            x = p.val
        if q.val:
            y = q.val
        res = (carry + x + y)
        carry = int(res / 10)
        curr.next = ListNode(res % 10)
        curr = curr.next
        if q:
            q = q.next
        if p:
            p = p.next
    # for i, item in enumerate(l1):
    #     stack.append((l1[i] + l2[i]) % 10)
    if carry > 0:
        curr.next = ListNode(carry)

    return list_node.next


# l1 = ListNode(2)
# l1.next = ListNode(4)
# l1.next = ListNode(3)
# l1 = ListNode(2)
# l11 = ListNode
#
# l2 = ListNode(5)
# l2.next = ListNode(6)
# l2.next = ListNode(4)
# l1 = ListNode.init_list(data=[2,4,3])
# l2 = ListNode.init_list(data=[5,6,4])
# l1 = ListNode(0).init_list([2, 4, 3])
# l2 = ListNode(0).init_list([5, 6, 4])
# aa = add_two_numbers(l1, l2)
# print(aa)

"""
from https://github.com/taizilongxu/interview_python
frog jump， can jump one step and two steps， 
How many solution in the forg jump ？
1. lambda
"""
fib = lambda n: n if n <= 2 else fib(n - 1) + fib(n - 2)
# import pdb
# pdb.set_trace()
# print(fib(10))
"""
2. memo function
"""


def memo(func):
    cache = {}

    def warp(*args):
        if args not in cache:
            cache[args] = func(*args)
        return cache[args]

    return warp


@memo
def fib(i):
    if i < 2:
        return 1
    return fib(i - 1) + fib(i - 2)


"""
3. three method
"""


def fib(n):
    a, b = 0, 1
    for _ in xrange(n):
        a, b = b, a + b
    return b


"""
matrix cover 
from https://github.com/taizilongxu/interview_python
"""
f = lambda n: 1 if n < 2 else f(n - 1) + f(n - 2)

"""
step-wise linear search
"""


def get_value(l, r, c):
    return l[r][c]


def find(l, x):
    m = len(l) - 1
    n = len(l[0]) - 1
    r = 0
    c = n
    while c >= 0 and r <= m:
        value = get_value(l, r, c)
        if value == x:
            return True
        elif value > x:
            c = c - 1
        elif value < x:
            r = r + 1
    return False


"""
valid parentheses
"""


def is_valid(str):
    stack = []
    mapping = {")": "(", "}": "{", "]": "["}
    for char in str:
        if char in mapping:
            top_element = stack.pop() if stack else '#'
            if mapping[char] != top_element:
                return False
        else:
            stack.append(char)
    return not stack


def merge_two_list(l1, l2):
    if l1 is None:
        return l2
    elif l2 is None:
        return l1
    elif l1.val < l2.val:
        l1.next = merge_two_list(l1.next, l2)
        return l1
    else:
        l2.next = merge_two_list(l1, l2.next)
        return l2


def strStr(haystack, needle):
    temp = haystack
    if haystack is None or needle is None:
        return -1
    for char in haystack:
        if char == needle[0]:
            for i, item in enumerate(haystack):
                if item != needle[i]:
                    break
                return str(temp).index(haystack)
        else:
            haystack = str(haystack).replace(char, "")


"""
merge intervals
56
"""


def overlap(a, b):
    return a.start <= b.end and b.start <= a.end


# generate graph where there is an undirected edge between intervals u
# and v iff u and v overlap.
def build_graph(intervals):
    graph = collections.defaultdict(list)

    for i, interval_i in enumerate(intervals):
        for j in range(i + 1, len(intervals)):
            if overlap(interval_i, intervals[j]):
                graph[interval_i].append(intervals[j])
                graph[intervals[j]].append(interval_i)

    return graph


# merges all of the nodes in this connected component into one interval.
def merge_nodes(nodes):
    min_start = min(node.start for node in nodes)
    max_end = max(node.end for node in nodes)
    return Interval(min_start, max_end)


# gets the connected components of the interval overlap graph.
def get_components(graph, intervals):
    visited = set()
    comp_number = 0
    nodes_in_comp = collections.defaultdict(list)

    def mark_component_dfs(start):
        stack = [start]
        while stack:
            node = stack.pop()
            if node not in visited:
                visited.add(node)
                nodes_in_comp[comp_number].append(node)
                stack.extend(graph[node])

    # mark all nodes in the same connected component with the same integer.
    for interval in intervals:
        if interval not in visited:
            mark_component_dfs(interval)
            comp_number += 1

    return nodes_in_comp, comp_number


def merge(intervals):
    graph = build_graph(intervals)
    nodes_in_comp, number_of_comps = get_components(graph, intervals)

    # all intervals in each connected component must be merged.
    return [merge_nodes(nodes_in_comp[comp]) for comp in range(number_of_comps)]


def set_zeroes(matrix):
    R = len(matrix)
    C = len(matrix[0])
    rows, cols = set(), set()

    # Essentially, we mark the rows and columns that are to be made zero
    for i in range(R):
        for j in range(C):
            if matrix[i][j] == 0:
                rows.add(i)
                cols.add(j)

    # Iterate over the array once again and using the rows and cols sets, update the elements
    for i in range(R):
        for j in range(C):
            if i in rows or j in cols:
                matrix[i][j] = 0


def set_zeroes(matrix):
    MODIFIED = -1000000
    R = len(matrix)
    C = len(matrix[0])
    for r in range(R):
        for c in range(C):
            if matrix[r][c] == 0:
                # we modify the elements in place. Note， we only change the non zeros to MODIFIED
                for k in range(C):
                    matrix[r][k] = MODIFIED if matrix[r][k] != 0 else 0
                for k in (R):
                    matrix[k][c] = MODIFIED if matrix[k][c] != 0 else 0

    for r in range(R):
        for c in range(C):
            # Make a second pass and change all MODIFIED elements to 0
            if matrix[r][c] == MODIFIED:
                matrix[r][c] = 0


def set_zeroes(matrix):
    is_col = False
    R = len(matrix)
    C = len(matrix[0])
    for i in range(R):
        if matrix[i][0] == 0:
            is_col = True
        for j in range(1, C):
            if matrix[i][j] == 0:
                matrix[0][j] = 0
                matrix[i][0] = 0

        for i in range(1, R):
            for j in range(1, C):
                if not matrix[i][0] or not matrix[0][j]:
                    matrix[i][j] = 0
        if matrix[0][0] == 0:
            for j in range(C):
                matrix[0][j] = 0

        if is_col:
            for i in range(R):
                matrix[i][0] = 0


"""
88.
merge two sorted array
from LeetCode
"""
# def merge(nums1, m, nums2, n):
#     # There mean all item
#     nums1[:] = sorted(nums1[:m] + nums2)


"""
88.
merge two sorted array
from LeetCode
double pointer
"""


def merge(nums1, m, nums2, n):
    # Make a copy of nums1
    nums1_copy = nums1[:m]
    nums1[:] = []

    # Two get pointers for nums1_copy and nums2
    p1 = 0
    p2 = 0
    # Compare elements from nums1_copy and nums2
    # and add the smallest one into num1
    while p1 < m and p2 < n:
        if nums1_copy[p1] < nums2[p2]:
            nums1.append(nums1_copy[p1])
            p1 += 1
        else:
            nums1.append(nums2[p2])
            p2 += 1

    # if there are still elements to add
    if p1 < m:
        nums1[p1 + p2:] = nums1_copy[p1:]
    if p2 < n:
        nums1[p1 + p2:] = nums2[p2:]


def merge(nums1, m, nums2, n):
    p1 = m - 1
    p2 = n - 1
    # set pointer for nums1
    p = m + n - 1

    while p1 >= 0 and p2 >= 0:
        if nums1[p1] < nums2[p2]:
            nums1[p] = nums2[p2]
            p2 -= 1
        else:
            nums1[p] = nums1[p1]
            p1 -= 1
        p -= 1

    # add missing elements from nums2
    nums1[:p2 + 1] = nums2[:p2 + 1]


def is_validbst(root):
    def helper(node, lower=float('inf'), upper=float('inf')):
        if not node:
            return True
        val = node.val
        if val <= lower or val >= upper:
            return False
        if not helper(node.right, val, upper):
            return False
        if not helper(node.left, lower, val):
            return False
        return True

    return helper(root)


"""
98 from LeetCode
valid binary tree
"""


def is_valid_bst(root):
    if not root:
        return True

    stack = [(root, float('-inf'), float('inf')), ]
    while stack:
        root, lower, upper = stack.pop()
        if not root:
            continue
        val = root.val
        if val <= lower or val >= upper:
            return False
        stack.append((root.right, val, upper))
        stack.append((root.left, lower, val))
    return True


"""
94 from LeetCode
Inorder traversal
"""


def is_valid_bst(root):
    stack, inorder = [], float('-inf')
    while stack or root:
        while root:
            stack.append(root)
            root = root.left
        root = stack.pop()
        # If next element in inorder traversal is smaller than the previous one that's not BST
        if root.val <= inorder:
            return False
        inorder = root.val
        root = root.right
    return True


# treeNode = TreeNode(2)
# treeNodeLeft = TreeNode(1)
# treeNode.left = treeNodeLeft
# treeNodeRight = TreeNode(3)
# treeNode.right = treeNodeRight
# print(is_valid_bst(treeNode))


def BFS(graph, s):
    queue = []
    queue.append(s)
    seen = set()
    seen.add(s)
    while (len(queue) > 0):
        vertex = queue.pop(0)
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                queue.append(w)
                seen.add(w)
        print(vertex)


def DFS(graph, s):
    stack = []
    stack.append(s)
    seen = set()
    seen.add(s)
    while (len(stack) > 0):
        vertex = stack.pop()
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                stack.append(w)
                seen.add(w)
        print(vertex)


"""
find nearest between two point by BFS
"""


def BFS(graph, s):
    queue = []
    queue.append(s)
    seen = set()
    seen.add(s)
    parent = {s: None}
    while (len(queue) > 0):
        vertex = queue.pop(0)
        nodes = graph[vertex]
        for w in nodes:
            if w not in seen:
                queue.append(w)
                seen.add(w)
                parent[w] = vertex
            print(vertex)
    return parent


def topk_frequent(nums, k):
    count = collections.Counter(nums)
    return heapq.nlargest(k, count.keys(), key=count.get)


graph = {
    "A": ["B", "C"],
    "B": ["A", "C", "D"],
    "C": ["A", "B", "D", "E"],
    "D": ["B", "C", "E", "F"],
    "E": ["C", "D"],
    "F": ["D"]
}

# parent = BFS(graph, "E")
# print(parent)
# v = 'B'
# while v != None:
#     print(v)
#     v = parent[v]

"""
236. from LeetCode
lca
Recursive 
"""
# def lowest_common_ancestor(root, p, q):
#     ans = None
#     def recurse_tree(current_node):
#         nonlocal ans
#         if not current_node:
#             return False
#
#         left = recurse_tree(current_node.left)
#
#         right = recurse_tree(current_node.right)
#
#         mid = current_node.val == p or current_node.val == q
#
#         if mid + left + right >=2:
#            ans = current_node
#
#         return mid or left or right
#     recurse_tree(root)
#     return ans

"""
236.  from LeetCode
lca  Iterative using parent pointers
"""


def lowest_common_ancestor(root, p, q):
    stack = [root]
    parent = {root: None}
    while p not in parent or q not in parent:
        node = stack.pop()
        if node.left:
            parent[node.left] = node
            stack.append(node.left)
        if node.right:
            parent[node.right] = node
            stack.append(node.right)
    ancestors = set()

    while p:
        ancestors.add(p)
        p = parent[p]

    # The first ancestor of q which appears in
    # p's ancestor set() is their lowest common ancestor.
    while q not in ancestors:
        q = parent[q]
    return q


# Three static flags to keep track of post-order traversal.

# Both left and right traversal pending for a node.
# Indicates the nodes children are yet to be traversed.
BOTH_PENDING = 2
# Left traversal done
LEFT_NODE = 1
# Both left and right traversal done for a node.
# Indicates the node can be popped off the stack.
BOTH_DONE = 0

# def lowestCommonAncestor(root, p, q):
#     """
#     :type root: TreeNode
#     :type p: TreeNode
#     :type q: TreeNode
#     :rtype: TreeNode
#     """
#
#     # Initialize the stack with the root node.
#     stack = [(root, BOTH_PENDING)]
#
#     # This flag is set when either one of p or q is found.
#     one_node_found = False
#
#     # This is used to keep track of LCA index.
#     LCA_index = -1
#
#     # We do a post order traversal of the binary tree using stack
#     while stack:
#
#         parent_node, parent_state = stack[-1]
#
#         # If the parent_state is not equal to BOTH_DONE,
#         # this means the parent_node can't be popped of yet.
#         if parent_state != BOTH_DONE:
#
#             # If both child traversals are pending
#             if parent_state == BOTH_PENDING:
#
#                 # Check if the current parent_node is either p or q.
#                 if parent_node == p or parent_node == q:
#
#                     # If one_node_found is set already, this means we have found both the nodes.
#                     if one_node_found:
#                         return stack[LCA_index][0]
#                     else:
#                         # Otherwise, set one_node_found to True,
#                         # to mark one of p and q is found.
#                         one_node_found = True
#
#                         # Save the current top index of stack as the LCA_index.
#                         LCA_index = len(stack) - 1
#
#                 # If both pending, traverse the left child first
#                 child_node = parent_node.left
#             else:
#                 # traverse right child
#                 child_node = parent_node.right
#
#             # Update the node state at the top of the stack
#             # Since we have visited one more child.
#             stack.pop()
#             stack.append((parent_node, parent_state - 1))
#
#             # Add the child node to the stack for traversal.
#             if child_node:
#                 stack.append((child_node, BOTH_PENDING))
#         else:
#
#             # If the parent_state of the node is both done,
#             # the top node could be popped off the stack.
#
#             # i.e. If LCA_index is equal to length of stack. Then we decrease LCA_index by 1.
#             if one_node_found and LCA_index == len(stack) - 1:
#                 LCA_index -= 1
#             stack.pop()
#
#     return None

"""
236. from LeetCode 
solution from geek
"""
# def lowestCommonAncestor(root, p, q):
#     if p.val < root.val > q.val:
#         return lowestCommonAncestor(root.left, p, q)
#     if q.val < root.val > p.val:
#         return lowestCommonAncestor(root.right, p, q)
#     return root

"""
236. from LeetCode
solution from geek
"""


def lowestCommonAncestor(root, p, q):
    while root:
        if p.val < root.val > q.val:
            root = root.left
        elif p.val > root.val < q.val:
            root = root.right
        else:
            return root


"""
pow  50 from LeetCode
solution from geek
"""


def myPow(x, n):
    if not n:
        return 1
    if n < 0:
        return 1 / myPow(x, -n)
    if n % 2:
        return x * myPow(x, n - 1)
    return myPow(x * x, n / 2)


"""
pow  50 from LeetCode  
solution from geek    
"""


def myPow(x, n):
    if n < 0:
        x = 1 / x
        n = -n
    pow = 1
    while n:
        if n & 1:
            pow *= x
        x *= x
        n >>= 1
    return pow


"""
169 from LeetCode
         Moore vote
"""


def majorityElement(nums: List[int]):
    candidate = None
    count = 0
    for num in nums:
        if num == candidate:
            count += 1
        elif count > 0:
            count -= 1
        else:
            candidate, count = num, 1
    return candidate


"""
level order from LeetCode

"""


def level_order(root):
    if not root: return []

    result = []
    queue = collections.deque()
    queue.append(root)

    # visited = set(root)

    while queue:
        level_size = len(queue)
        current_level = []

        for _ in range(level_size):
            node = queue.popleft()
            current_level.append(node.val)
            if node.left: queue.append(node.left)
            if node.right: queue.append(node.right)

        result.append(current_level)
    return result


def max_deth(root):
    if not root: return 0
    return 1 + max(max_deth(root.left), max_deth(root.right))


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
END_OF_WORD = "#"

class Solution(object):
    def _dfs(self, board, i, j, cur_word, cur_dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]

        if END_OF_WORD in cur_dict:
            self.result.add(cur_word)

        temp, board[i][j] = board[i][j], '@'
        for k in xrange(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)

        board[i][j] = temp


    def findWords(self, board, words):
        if not board or not board[0]: return []
        if not words: return []

        self.result = set()

        root = collections.defaultdict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, collections.defaultdict())
            node[END_OF_WORD] = END_OF_WORD

        self.m, self.n = len(board), len(board[0])

        for i in xrange(self.m):
            for j in xrange(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, "", root)






    def levelOroder(self, root):
        if not root: return []
        self.result = []
        self._dfs(root, 0)
        return self.result

    # def _dfs(self, node, level):
    #     if not node: return
    #     if len(self.result) < level + 1:
    #         self.result.append([])
    #
    #     self.result[level].append(node.val)
    #     self._dfs(node.left, level + 1)
    #     self._dfs(node.right, level + 1)

    """
    22. Generate Parentheses from LeetCode
    solution from geek
    """

    def generateParenthesis(self, n):
        self.list = []
        self._gen(0, 0, n, "")
        return self.list

    def _gen(self, left, right, n, result):
        if left == n and right == n:
            self.list.append(result)
            return
        if left < n:
            self._gen(left + 1, right, n, result + "(")
        if left > right and right < n:
            self._gen(left, right + 1, n, result + ")")

    """
        22. Generate Parentheses from LeetCode
        solution from LeetCode
    """

    # def generateParentthesis(self, N):
    #     ans = []
    #     def backtrack(S  = '', left = 0, right = 0):
    #         if len(S) == 2 * N:
    #             ans.append(S)
    #             return
    #         if left < N:
    #             backtrack(S + '(', left + 1, right)
    #         if right < left:
    #             backtrack(S + ')', left, right + 1)
    #
    #     backtrack()
    #     return ans

    def generateParenthesis(self, N):
        if N == 0: return ['']
        ans = []
        for c in xrange(N):
            for left in self.generateParenthesis(c):
                for right in self.generateParenthesis(N - 1 - c):
                    ans.append('({}){}'.format(left, right))
        return ans

def solveNQueens(n):
    def could_place(row, col):
        return not (cols[col] + hill_diagonals[row - col] + dale_diagonals[row + col])

    def place_queen(row, col):
        queens.add((row, col))
        cols[col] = 1
        hill_diagonals[row - col] = 1
        dale_diagonals[row + col] = 1

    def remove_queen(row, col):
        queens.remove((row, col))
        cols[col] = 0
        hill_diagonals[row - col] = 0
        dale_diagonals[row + col] = 0

    def add_solution():
        solution = []
        for _, col in sorted(queens):
            solution.append('.' * col + 'Q' + '.' * (n - col - 1))
        output.append(solution)

    def backtrack(row=0):
        for col in range(n):
            if could_place(row, col):
                place_queen(row, col)
                if row + 1 == n:
                    add_solution()
                else:
                    backtrack(row + 1)
                remove_queen(row, col)

    cols = [0] * n
    hill_diagonals = [0] * (2 * n - 1)
    dale_diagonals = [0] * (2 * n - 1)
    queens = set()
    output = []
    backtrack()
    return output


"""
36 from LeetCode
official solution
"""


def is_valid_sudoku(board):
    rows = [{} for i in range(9)]
    columns = [{} for i in range(9)]
    boxes = [{} for i in range(9)]

    for i in range(9):
        for j in range(9):
            num = board[i][j]
            if num != '.':
                num = int(num)
                box_index = (i // 3) * 3 + j // 3

                rows[i][num] = rows[i].get(num, 0) + 1
                columns[j][num] = columns[j].get(num, 0) + 1
                boxes[box_index][num] = boxes[box_index].get(num, 0) + 1

                if rows[i][num] > 1 or columns[j][num] > 1 or boxes[box_index][num] > 1:
                    return False
    return True


"""
37 LeetCode
my solution, it's not work; lack of backtracking
"""


def sovle_sudoku(input):
    all_num = set(('1', '2', '3', '4', '5', '6', '7', '8', '9'))
    row_list, columns_list = {}, {}
    could_set = set()

    # import pdb
    # pdb.set_trace()

    iilength, jjlenght = 0, 0
    iilengthend, jjlenghtend = 3, 3
    for i in range(int(len(input) / 3)):
        for j in range(int(len(input[0]) / 3)):
            non_place = []
            boxes = set()
            for ii in range(iilength, iilengthend):
                for jj in range(jjlenght, jjlenghtend):
                    row_set = set()
                    column_set = set()
                    if input[ii][jj] != '.':
                        boxes.add(input[ii][jj])
                    elif input[ii][jj] == '.':
                        non_place.append(str(ii) + ',' + str(jj))
                        for k in range(len(input[jj])):
                            if input[jj][k] != '.' and i not in row_list:
                                row_set.add(input[jj][k])
                        if row_set: row_list[jj] = row_set

                        for n in range(len(input)):
                            if input[n][jj] != '.' and jj not in columns_list:
                                column_set.add(input[n][jj])
                        if column_set: columns_list[jj] = column_set

            jjlenght += 3
            jjlenghtend += 3

            could_set = all_num - boxes
            for q in range(len(non_place)):
                x, y = list(map(int, str(non_place[q]).split(',')))
                # now_could = (could_set - row_list[x] - columns_list[y])
                # print('no_place:' + str(len(non_place)))
                # print('could_set:' + str(len(could_set)))
                # print('x:' + str(x))
                # print('row_list:' + str(row_list))
                # num = now_could.pop()
                # could_set.remove(num)
                print('could_set: ' + str(could_set) + ' \n rowlist:' + str(row_list) + '\n columnslist:' +
                      str(columns_list) + '\n x:' + str(x) + '\n y:' + str(y) + ' \n boxes:' + str(boxes)
                      + ' \n input:' + str(input))
                num = (could_set - row_list[x] - columns_list[y]).pop()
                could_set.remove(num)
                input[x][y] = num
                row_list[x].add(num)
                columns_list[y].add(num)
        iilength += 3
        iilengthend += 3
        jjlenght, jjlenghtend = 0, 3

    return input


"""
37 LeetCode
official solution
"""


def solveSudoku(board):
    def could_place(d, row, col):

        """
        check if one could place a number d in (row, col) cell
        """
        return not (d in rows[row] or d in columns[col] or d in boxes[box_index(row, col)])

    def place_number(d, row, col):
        rows[row][d] += 1
        columns[col][d] += 1
        boxes[box_index(row, col)][d] += 1
        board[row][col] = str(d)

    def remove_number(d, row, col):
        """
        remove a number which didnt lead to a solution
        """
        del rows[row][d]
        del columns[col][d]
        del boxes[box_index(row, col)][d]
        board[row][col] = '.'

    def place_next_numbers(row, col):
        """
        Call backtrack function in recursion
            to continue to place numbers
            till the moment we have a solution
        """
        if col == N - 1 and row == N - 1:
            nonlocal sudoku_solved
            sudoku_solved = True
        else:
            if col == N - 1:
                backtrack(row + 1, 0)
            else:
                backtrack(row, col + 1)

    def backtrack(row=0, col=0):
        """
        Backtracking
        """
        #  if the cell is empty
        if board[row][col] == '.':
            # iterate ovewr all numbers from 1 to 9
            for d in range(1, 10):
                if could_place(d, row, col):
                    place_number(d, row, col)
                    place_next_numbers(row, col)
                    # if sudoku is solved, there is no need to backtrack
                    # since the single unique solution is promised
                    if not sudoku_solved:
                        remove_number(d, row, col)
        else:
            place_next_numbers(row, col)

    # box size
    n = 3
    # row size
    N = n * n
    # lambda function to compute box index
    box_index = lambda row, col: (row // n) * n + col // n
    # init rows, columns and boxes
    rows = [collections.defaultdict(int) for i in range(N)]
    columns = [collections.defaultdict(int) for i in range(N)]
    boxes = [collections.defaultdict(int) for i in range(N)]
    for i in range(N):
        for j in range(N):
            if board[i][j] != '.':
                d = int(board[i][j])
                place_number(d, i, j)
    sudoku_solved = False
    backtrack()


"""
69 LeetCode
"""


def mySqrt(x):
    if x <= 1:
        return x
    r = x
    while r > x / r:
        r = (r + x / r) // 2
    return int(r)

"""
becase it is monotone increasing so can use binary search
"""
def mySqrt(x):
    # to take care of 0, so set left boundary is 0
    left = 0
    # to take care of 1, so set right boundary is x // 2 + 1
    right = x // 2 + 1
    while left < right:
        # attention there must choose right mid number, if choose left mid number， the code  may fall in endless loop
        mid = (left + right + 1) >> 1
        square = mid * mid

        if square > x:
            right = mid - 1
        else:
            left = mid

    return left


def mySqrt(x):
    if x < 0:
        raise Exception('cannot input negative number')
    if x == 0:
        return 0
    # 初始的时候在 1 这可以比较随意设置
    cur = 1
    while True:
        pre = cur
        cur = (cur + x / cur) / 2
        if abs(cur - pre) < 1e-6:
            return int(cur)

"""
69 sqrt LeetCode
solution from geek
"""
def mySqrt(x):
    r = x
    while r * r > x:
        r = (r + x / r) / 2
    return r


# def init(input):
#     boxes = set()
#     for i in range(len(input)):
#         row_set = set()
#         for j in range(len(input)):
#             column_set = set()
#             row_set.add()

"""
208 LeetCode
"""
class Trie:
    def __init__(self):
        self.root = {}
    def insert(self, word: str) -> None:
        node = self.root
        for s in word:
            if s in node.keys():
                node = node[s]
            else:
                node[s] = {}
                node = node[s]
        node['is_word'] = True

    def search(self, word: str) -> bool:
        node = self.root
        for s in word:
            print(node.keys())
            if s in node.keys():
                node = node[s]
            else:
                return False
        if 'is_word' in node.keys():
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        node = self.root
        for s in prefix:
            if s in node.keys():
                node = node[s]
            else:
                return False

        return True


def hammingWeight(n: int) -> int:
    res = 0
    mask = 1
    for i in range(64):
        if n & mask:
            res += 1
        mask = mask << 1
    return res

class NQueen(object):
    def totalNQueens(self, n):
        if n < 1: return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count

    def DFS(self, n, row, cols, pie, na):
        if row >= n:
            self.count += 1
            return

        bits = (~(cols | pie | na) & ((1 << n) - 1))
        while bits:
            p = bits & -bits
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
            bits = bits & (bits - 1)

class NQueen1(object):
    def totalNQueens(self, n):
        def is_not_under_attack(row, col):
            return not(rows[col] or hills[row - col] or dales[row + col])

        def place_queen(row, col):
            rows[col] = 1
            hills[row - col] = 1
            dales[row + col] = 1

        def remove_queen(row, col):
            rows[col] = 0
            hills[row - col] = 0
            hills[row + col] = 0


        def backtrack(row = 0, count = 0):
            for col in range(n):
                if is_not_under_attack(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        count += 1
                    else:
                        count = backtrack(row + 1, count)
                    remove_queen(row, col)
            return count

        rows = [0] * n
        hills = [0] * (2 * n - 1)
        dales = [0] * (2 * n - 1)
        return backtrack()

class NQueen2(object):
    def totalNQueens(self, n):
        if n < 1: return []
        self.count = 0
        self.DFS(n, 0, 0, 0, 0)
        return self.count

    def DFS(self, n, row, cols, pie, na):
        if row >= n:
            self.count += 1
            return
        print('cols:'+ bin(cols))
        print('pie:'+ bin(pie))
        print('na:'+ bin(na))
        print('bin cols | pie | na :'+ bin(cols | pie | na))
        print('bin ~ cols | pie | na :'+ bin(~(cols | pie | na)))
        print('(1 << n) - 1: ' + bin((1 << n) - 1))
        print('(1 << n): ' + bin((1 << n)))

        bits = (~(cols | pie | na) & ((1 << n) - 1))

        while bits:
            p = bits & -bits
            print('bits:' + bin(bits))
            print('- bits:' + bin(-bits))
            print('p: ' + bin(p))
            self.DFS(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1)
            print('bits:' + bin(bits))
            print('bits:' + bin(bits & (bits - 1)))
            bits = bits & (bits - 1)


if __name__ == '__main__':
    queen = NQueen2()
    print(queen.totalNQueens(4))

    # print(hammingWeight(0o0000000000000000000000000001011))
#     trie = Trie()
#     trie.insert('apple')
#     trie.search("apple")
#     trie.search("app")
#     trie.startsWith("app")
#     trie.insert("app")
#     trie.search("app")

    # solution = Solution()
    # input = [
    #     ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    #     ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    #     [".", "9", "8", ".", ".", ".", ".", "6", "."],
    #     ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    #     ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    #     ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    #     [".", "6", ".", ".", ".", ".", "2", "8", "."],
    #     [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    #     [".", ".", ".", ".", "8", ".", ".", "7", "9"]
    # ]
    #
    # print(solveSudoku(input))
    # print(input)

    # print(solveNQueens(8))
    # rootNode = TreeNode(3)

    # left1 = TreeNode(9)
    # right1 = TreeNode(20)
    # rootNode.left = left1
    # rootNode.right = right1
    # left2 = TreeNode(15)
    # right2 = TreeNode(7)
    # left3 = TreeNode(4)
    # left2.left = left3
    # right1.left = left2
    # right1.right = right2

    # solution = Solution()

    # print(max_deth(rootNode))

    # left3 = TreeNode(6)
    # right3 = TreeNode(7)
    # right1.left = left3
    # right1.right = right3

    # left4 = TreeNode(8)
    # right4 = TreeNode(9)
    # left2.left = left4
    # left2.right = right4
    #
    # left5 = TreeNode(10)
    # right5 = TreeNode(11)
    # right2.left = left5
    # right2.right = right5
    #
    # left6 = TreeNode(12)
    # right6 = TreeNode(13)
    # left3.left = left6
    # left3.right = right6
    #
    # left7 = TreeNode(14)
    # right7 = TreeNode(15)
    # right3.left = left7
    # right3.right = right7
    # print(lowestCommonAncestor(rootNode, rootNode.left.left.right, rootNode.left.right.right).val)
    # print(lowest_common_ancestor(rootNode, TreeNode(9), TreeNode(11)).val)

# nums1 = [1,2,3,4,5,6]
# nums2 = [2,5,6]
# merge(nums1, 3, nums2, 3)

# matrix = [[1,1,1], [1,0,1], [1,1,1]]
# print(set_zeroes(matrix))
# array=[[1,3],[2,6],[8,10],[15,18]]
# intervals = list(I.open(1, 3) | I.open(2, 6) | I.open(8, 10) | I.open(15, 18))
# print(merge(intervals))

# haystack = "aaaaa"
# needle = "bba"
# print(strStr(haystack, needle))
# print(is_valid("()()()()"))
# a = Record(1)
# print(a)

# array = [5,3,2,5,4,3,5,4,2,4,4]
# array = [1, 5, 5, 2]
# print(get_visible_num(array))

# arr = [2, 4]
# print(get_num(arr, 2))

#
# arr = [3, 4, 1, 5, 6, 2, 7]
# print(getNearLessNoRepeat(arr))

# nums = np.array([[1, 4], [1, 1, 1, 0]])
# print(findMaxSubMatrix(nums))

# array = [-1,0,1,2,-1,-4]
# array = [1,1,-2]
# array = [0,0,0]
# print(threeSum(array))
# array = [2, 7, 1, 15]
# print(twoSum(array, 9))
# ar著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。ray = [3, 4, 1, 5, 6, 2, 7]
# array = [3, 1, 3, 4, 3, 5, 3, 2, 2]
# result = findKMax(array, 2)
# print(result)
# array2 = [3, 1, 11, 22, 44, 5, 3, 2, 2]
# result = intersection(array, array2)
# print(getNearLess(array))

# test = []
# print(-1 if not test else -2)

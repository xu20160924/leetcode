import heapq
import itertools


class Solution(object):
    # brute force
    # def kSmallestPairs(self, nums1, nums2, k):
    #     return sorted(itertools.product(nums1, nums2), key = sum)[:k]

    # clean brute force
    # def kSmallestPairs(self, nums1, nums2, k):
    #     return map(list, sorted(itertools.product(nums1, nums2), key = sum)[:k])

    # Less Brute Force
    # def kSmallestPairs(self, nums1, nums2, k):
    #     return map(list, heapq.nsmallest(k, itertools.product(nums1, nums2), key = sum))

    # def kSmallestPairs(self, nums1, nums2, k):
    #     return heapq.nsmallest(k, ([u, v] for u in nums1 for v in nums2), key=sum)

    # def kSmallestPairs(self, nums1, nums2, k):
    #     streams = map(lambda u: ([u+v, u, v] for v in nums2), nums1)
    #     stream = heapq.merge(*streams)
    #     return [suv[1:] for suv in itertools.islice(stream, k)]

    def kSmallestPairs(self, nums1, nums2, k):
        queue = []
        def push(i, j):
            if i < len(nums1) and j < len(nums2):
                heapq.heappush(queue, [nums1[i] + nums2[j], i, j])
        push(0, 0)
        pairs = []
        while queue and len(pairs) < k:
            _, i, j = heapq.heappop(queue)
            pairs.append([nums1[i], nums2[j]])
            push(i, j + 1)
            if j == 0:
                push(i + 1, 0)
        return pairs

if __name__ == '__main__':
    nums1 = [1,7,11]
    nums2 = [2,4,6]
    solution = Solution()
    solution.kSmallestPairs(nums1, nums2, 3)
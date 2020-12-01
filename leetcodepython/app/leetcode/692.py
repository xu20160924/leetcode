import collections
import heapq

from pip._vendor.msgpack.fallback import xrange


class Solution:
    # heapify solution
    def topKFrequent(self, words, k):
        count = collections.Counter(words)
        heap = [(-freq, word) for word, freq in count.items()]
        heapq.heapify(heap)
        return [heapq.heappop(heap)[1] for _ in xrange(k)]


    # sort solution
    # def topKFrequent(self, words, k):
    #     count = collections.Counter(words)
    #     candidates = count.keys()
    #     candidates.sort(key=lambda w: (-count[w], w))
    #     return candidates[:k]

if __name__ == '__main__':
    solution = Solution()
    solution.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2)

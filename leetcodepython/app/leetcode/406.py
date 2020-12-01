from pip._vendor.msgpack.fallback import xrange


class Solution(object):
    # def reconstructQueue(self, people):
    #     if not people: return []
    #
    #     peopledct, height, res = {}, [], []
    #
    #     for i in xrange(len(people)):
    #         p = people[i]
    #         if p[0] in peopledct:
    #             peopledct[p[0]] += (p[1], i),
    #         else:
    #             peopledct[p[0]] = [(p[1], i)]
    #             height += p[0],
    #
    #     height.sort()
    #
    #     # sort from the tallest group
    #     for h in height[::-1]:
    #         peopledct[h].sort()
    #         for p in peopledct[h]:
    #             res.insert(p[0], people[p[1]])
    #
    #     return res

    def reconstructQueue(self, people):
        people.sort(key=lambda x_y:[-x_y[0], x_y[1]])
        queue = []
        for p in people:
            queue.insert(p[1], p)
        return queue

people = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
solution = Solution()
solution.reconstructQueue(people)
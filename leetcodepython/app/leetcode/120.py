from pip._vendor.msgpack.fallback import xrange


class Solution(object):
    def minimumTotal(self, triangle):
        if not triangle: return []
        res = triangle[-1]

        for i in xrange(len(triangle) - 2, -1, -1):
            for j in xrange(len(triangle[i])):
                print('res[j]:' + str(res[j]))
                print('res[j + 1]:' + str(res[j + 1]))
                print('triangle[i][j]:' + str(triangle[i][j]))

                res[j] = min(res[j], res[j + 1]) + triangle[i][j]
                # print(res[j])
        return res[0]


if __name__ == '__main__':
    input = [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
    solution = Solution()
    print(solution.minimumTotal(input))
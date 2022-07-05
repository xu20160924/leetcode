class Solution(object):
    def countArrangement(self, N):
        cache = {}
        def helper(i, X):
            if i == 1:
                return 1
            print(X)
            key = i, X
            if key in cache:
                return cache[key]
            total = sum(helper(i - 1, X[:j] + X[j + 1:]) for j, x in enumerate(X) if x % i == 0 or i % x == 0)
            cache[key] = total
            return total
        return helper(N, tuple(range(1, N + 1)))


# cache = {}
# class Solution(object):
#     def countArrangement(self, N):
#         def helper(i, X):
#             if i == 1:
#                 return 1
#             key = i, X
#             if key in cache:
#                 return cache[key]
#             total = sum(helper(i - 1, X[:j] + X[j + 1:])
#                         for j, x in enumerate(X)
#                         if x % i == 0 or i % x == 0)
#             cache[key] = total
#             return total
#         return helper(N, tuple(range(1, N + 1)))

if __name__ == '__main__':
    solution = Solution()
    solution.countArrangement(5)
    # print(tuple(range(5)))
    # a = [1,2,3,4]
    # print(a[:2])
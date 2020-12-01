from typing import List


class Solution:
    def maxAreaOfIsland(self, grid):
        grid = {i + j*1j: val for i , row in enumerate(grid) for j, val in enumerate(row)}
        ss = set(grid)
        def area(z):
            for k in range(4):
                print("1j**k:" + str(1j**k))
                # print(2j**k)
                print("z + 1j ** k:" + str(z + 1j ** k))

            return grid.pop(z, 0) and 1 + sum(area(z + 1j**k) for k in range(4))
        return max(map(area, set(grid)))
    # def maxAreaOfIsland(self, grid):
    #     m, n = len(grid), len(grid[0])
    #     def dfs(i, j):
    #         if 0 <= i < m and 0 <= j < n and grid[i][j]:
    #             grid[i][j] = 0
    #             return 1+ dfs(i - 1, j) + dfs(i+1, j) + dfs(i, j-1) + dfs(i, j+1)
    #         return 0
    #     areas = [dfs(i, j ) for i in range(m) for j in range(n)]
    #     return max(areas) if areas else 0


#     direction = [[0, 1], [1, 0], [-1, 0], [0, -1]]
#
#     def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
#         n, m = len(grid), len(grid[0])
#         uf = UF(grid)
#         for i in range(n):
#             for j in range(m):
#                 if grid[i][j] == 1:
#                     for d in self.direction:
#                         x = i + d[0]
#                         y = j + d[1]
#                         if 0 <= x < n and 0 <= y < m and grid[x][y] == 1:
#                             uf.union(i * m + j, x * m + y)
#
#         return uf.max
#
#
# class UF:
#
#     def __init__(self, grid):
#         n, m = len(grid), len(grid[0])
#         self.count = 0
#         self.parent = [-1] * (m * n)
#         self.rank = [0] * (m * n)
#         self.max = 0
#         for i in range(n):
#             for j in range(m):
#                 if grid[i][j] == 1:
#                     self.parent[i * m + j] = i * m + j
#                     self.count += 1
#
#     def find(self, x):
#         if x != self.parent[x]:
#             self.parent[x] = self.find((self.parent[x]))
#         return self.parent[x]
#
#     def union(self, x, y):
#         id1 = self.find(x)
#         id2 = self.find(y)
#
#         if id1 == id2:
#             return
#         if self.rank[id1] > self.rank[id2]:
#             self.parent[id2] = self.parent[id1]
#         elif self.rank[id1] < self.rank[id2]:
#             self.parent[id1] = self.parent[id2]
#         else:
#             self.parent[id1] = self.parent[id2]
#             self.rank[id1] += 1
#
#         self.max = max(self.max, self.rank[id1], self.rank[id2])


if __name__ == '__main__':
    grid = [[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
            [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
            [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]
    solution = Solution()
    print(solution.maxAreaOfIsland(grid))

    # j = 2
    # k = 2
    # print(2j**k)

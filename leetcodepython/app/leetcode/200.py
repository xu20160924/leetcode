import collections

from pip._vendor.urllib3.connectionpool import xrange

from app.algorithm.UnionFind import UnionFind


class Solution:

    # floodfill

    # self.dx = [-1, 1, 0, 0]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    def numIslands(self, grid):
        if not grid or not grid[0]: return 0
        self.max_x = len(grid)
        self.max_y = len(grid[0])
        self.grid = grid
        self.visited = set()
        res = 0
        # there have some unnecessary interate, because position that marked visited dont need iterate
        for i in range(self.max_x):
            for j in range(self.max_y):
                res += self.floodfill_BFS(i, j)
        return res
        # return sum([self.floodfill_DFS(i, j) for i in range(self.max_x) for j in range(self.max_y)])

    def floodfill_DFS(self, x, y):
        if not self._is_valid(x, y):
            return 0
        self.visited.add((x, y))
        for k in range(4):
            self.floodfill_DFS(x + self.dx[k], y + self.dy[k])
        return 1

    def floodfill_BFS(self, x, y):
        if not self._is_valid(x, y):
            return 0
        self.visited.add((x, y))
        queue = collections.deque()
        queue.append((x, y))

        while queue:
            cur_x, cur_y = queue.popleft()
            for i in range(4):
                new_x, new_y = cur_x + self.dx[i], cur_y + self.dy[i]
                if self._is_valid(new_x, new_y):
                    self.visited.add((new_x, new_y))
                    queue.append((new_x, new_y))

    def _is_valid(self, x, y):
        if x < 0 or x >= self.max_x or y < 0 or y >= self.max_y:
            return False
        if self.grid[x][y] == '0' or ((x, y) in self.visited):
            return False
        return True


class UnionFindSolution:
    def numIslands(self, grid):
        if not grid or not grid[0]:
            return 0
        uf = UnionFind(grid)
        directions = [(0,1), (0,-1), (-1,0), (1,0)]
        m, n = len(grid), len(grid[0])

        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == '0':
                    continue
                for d in directions:
                    nr, nc = i + d[0], j + d[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and grid[nr][nc] == 1:
                        # print('i*n+j:' + str((i*m+j)))
                        # print('nr*n+nc:' + str((nr*n+nc)))
                        uf.union(i*n+j, nr*n+nc)
        return uf.count


class Solution3(object):
    def numIslands(self, grid):
        def sink(i, j):
            if 0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == '1':
                grid[i][j] = '0'
                map(sink, (i+1, i-1, i, i), (j,j,j+1,j-1))
                return 1
            return 0
        return sum(sink(i, j) for i in range(len(grid) for j in range(len(grid[i]))))

if __name__ == '__main__':
    # queue = collections.deque()
    # queue.append((1, 1))
    # queue.append((2, 2))
    # queue.append((3, 3))
    # x, y = queue.popleft()
    # print(x)
    # print(y)

    input = [
        [1,1,1,1,0],
        [1,1,0,1,0],
        [1,1,0,0,0],
        [0,0,0,0,0]
    ]
    solution = Solution()
    print(solution.numIslands(input))
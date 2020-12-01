from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])

        queue = [[i, j] for i in range(rows) for j in range(cols) if grid[i][j] == 2]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        time = 0
        while True:
            new = []
            for [i, j] in queue:
                for d in directions:
                    ni, nj = i + d[0], j + d[1]
                    if 0 <= ni < rows and 0 <= nj < cols and grid[ni][nj] == 1:
                        grid[ni][nj] = 2
                        new.append([ni, nj])

            q = new
            if not q:
                break
            time += 1
        return time

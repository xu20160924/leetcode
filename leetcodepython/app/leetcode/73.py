class Solution(object):
    # def setZeroes(self, matrix):
    #     R = len(matrix)
    #     C = len(matrix[0])
    #     rows, cols = set(), set()
    #
    #     for i in range(R):
    #         for j in range(C):
    #             if matrix[i][j] == 0:
    #                 rows.add(i)
    #                 cols.add(j)
    #
    #     for i in range(R):
    #         for j in range(C):
    #             if i in rows or j in cols:
    #                 matrix[i][j] = 0


    # def setZeroes(self, matrix):
    #     MODIFIED = -1000000
    #     R = len(matrix)
    #     C = len(matrix[0])
    #     for r in range(R):
    #         for c in range(C):
    #             if matrix[r][c] == 0:
    #                 for k in range(C):
    #                     matrix[r][k] = MODIFIED if matrix[r][k] != 0 else 0
    #                 for k in range(R):
    #                     matrix[k][c] = MODIFIED if matrix[k][c] != 0 else 0
    #
    #     for r in range(R):
    #         for c in range(C):
    #             if matrix[r][c] == MODIFIED:
    #                 matrix[r][c] = 0

    def setZeroes(self, matrix):
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


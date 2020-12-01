from typing import List

from pip._vendor.msgpack.fallback import xrange


class Solution:
    # def exist(self, board: List[List[str]], word: str) -> bool:
    #     if not board:
    #         return False
    #     for i in xrange(len(board)):
    #         for j in xrange(len(board[0])):
    #
    #     pass
    #
    # def dfs(self, board, i, j, word):
    #     if len(word) == 0:
    #         return True
    #     if i < 0 or j < 0 or i == len(board) or j == len(board[j])

    def exist(self, board, word):
        if not board:
            return False
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                if self.dfs(board, i, j, word):
                    return True
        return False

    def dfs(self, board, i, j, word):
        if len(word) == 0:
            return True

        if i < 0 or j < 0 or i == len(board) or j == len(board[i]) \
                or word[0] != board[i][j]:
            return False
        tmp = board[i][j]
        board[i][j] = "#"
        res = self.dfs(board, i + 1, j, word[1:]) \
        or self.dfs(board, i, j + 1, word[1:]) \
        or self.dfs(board, i - 1, j, word[1:]) \
        or self.dfs(board, i, j - 1, word[1:])
        board[i][j] = tmp
        return res


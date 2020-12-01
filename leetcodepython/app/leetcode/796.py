from pip._vendor.urllib3.connectionpool import xrange


class Solution(object):
    def rotateString(self, A, B):
        N = len(A)
        if N != len(B):
            return False
        if N == 0:
            return True

        shifts = [1] * (N + 1)
        left = -1
        for right in xrange(N):
            while left >= 0 and B[left] != B[right]:
                left -= shifts[left]
            shifts[right + 1] = right - left
            left += 1

        match_len = 0
        for char in A+A:
            while match_len >= 0 and B(match_len) != char:
                match_len -= shifts[match_len]

            match_len += 1
            if match_len == N:
                return True

        return False

if __name__ == '__main__':
    A = "abcde"
    B = "cdeab"
    solution = Solution()
    solution.rotateString(A, B)

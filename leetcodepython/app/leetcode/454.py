from collections import Counter


class Solution(object):
    def fourSumCount(self, A, B, C, D):
        AB = Counter(a+b for a in A for b in B)
        return sum(AB[-c-d] for c in C for d in D)
if __name__ == '__main__':
    A = [1, 2]
    B = [-2, -1]
    C = [-1, 2]
    D = [0, 2]
    for a in A:
        for b in B:
            print("a:" + str(a))
            print("b" + str(b))
            # print(a + b)
    # solution = Solution()
    # solution.fourSumCount(A, B, C, D)

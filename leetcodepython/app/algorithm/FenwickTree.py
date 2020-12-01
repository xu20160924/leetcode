class FenwickTree:
    def __int__(self, n):
        self._sums = [0 for _ in range(n + 1)]

    def update(self, i, delta):
        while i < len(self._sums):
            self._sums[i] += delta
            i += i & -i

    def query(self, i):
        s = 0
        while i > 0:
            s += self._sums[i]
            i -= i & -i
        return s
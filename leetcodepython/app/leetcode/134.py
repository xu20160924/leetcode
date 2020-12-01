from typing import List


class Solution(object):
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        start, total, tank = 0, 0, 0
        for i in range(len(gas)):
            tank = tank + gas[i] - cost[i]
            if tank < 0:
                start = i + 1
                total += tank;
                tank = 0;

        return -1 if (total + tank < 0) else start


if __name__ == '__main__':
    gas = [5, 1, 2, 3, 4]
    cost = [4, 4, 1, 5, 1]
    solution = Solution()
    print(solution.canCompleteCircuit(gas, cost))
import collections
from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        merged = []
        for interval in intervals:
            if not merged or merged[-1][1] < interval[0]:
                merged.append(interval)
            else:
                merged[-1][1] = max(merged[-1][1], interval[1])

        return merged

    # def overlap(self, a, b):
    #     return a[0] <= b[1] and b[0] <= a[1]
    #
    # def build_graph(self, intervals):
    #     graph = collections.defaultdict(list)
    #     print(type(graph))
    #     for i, interval_i in enumerate(intervals):
    #         for j in range(i + 1, len(intervals)):
    #             if self.overlap(interval_i, intervals[j]):
    #                 # graph[tuple(interval_i)].append(intervals[j])
    #                 # graph[tuple(intervals[j])].append(interval_i)
    #                 graph[interval_i].append(intervals[j])
    #                 graph[intervals[j]].append(interval_i)
    #
    #     return graph
    #
    # def merge_nodes(self, nodes):
    #      min_start = min(node[0] for node in nodes)
    #      max_end = max(node[1] for node in nodes)
    #      return [min_start, max_end]
    #
    # def get_components(self, graph, intervals):
    #     visited = set()
    #     comp_number = 0
    #     nodes_in_comp = collections.defaultdict(list)
    #
    #     def mark_component_dfs(start):
    #         stack = [start]
    #         while stack:
    #             node = tuple(stack.pop())
    #             if node not in visited:
    #                 visited.add(node)
    #                 nodes_in_comp[comp_number].append(node)
    #                 stack.extend(graph[node])
    #
    #     for interval in intervals:
    #         if tuple(interval) not in visited:
    #             mark_component_dfs(interval)
    #             comp_number += 1
    #
    #     return nodes_in_comp, comp_number
    #
    # def merge(self, intervals: List[List[int]]) -> List[List[int]]:
    #     graph = self.build_graph(intervals)
    #     node_in_comp, number_of_comps = self.get_components(graph, intervals)
    #
    #     return [self.merge_nodes(node_in_comp[comp]) for comp in range(number_of_comps)]
    # def overlap(self, a, b):
    #     return a[0] <= b[1] and b[0] <= a[1]
    #
    # def build_graph(self, intervals):
    #     graph = collections.defaultdict(list)
    #     for i, interval_i in enumerate(intervals):
    #         for j in range(i + 1, len(intervals)):
    #             if self.overlap(interval_i, intervals[j]):
    #                 graph[tuple(interval_i)].append(intervals[j])
    #                 graph[tuple(intervals[j])].append(interval_i)
    #     return graph
    #
    # def merge_nodes(self, nodes):
    #     min_start = min(node[0] for node in nodes)
    #     max_end = max(node[1] for node in nodes)
    #     return [min_start, max_end]
    #
    # def get_components(self, graph, intervals):
    #     visited = set()
    #     comp_number = 0
    #     nodes_in_comp = collections.defaultdict(list)
    #
    #     def mark_component_dfs(start):
    #         stack = [start]
    #         while stack:
    #             node = tuple(stack.pop())
    #             if node not in visited:
    #                 visited.add(node)
    #                 nodes_in_comp[comp_number].append(node)
    #                 stack.extend(graph[node])
    #
    #     for interval in intervals:
    #         if tuple(interval) not in visited:
    #             mark_component_dfs(interval)
    #             comp_number += 1
    #
    #     return nodes_in_comp
    #
    # def merge(self, intervals: List[List[int]]) -> List[List[int]]:
    #     graph = self.build_graph(intervals)
    #     node_in_comp = self.get_components(graph, intervals)
    #
    #     # for node in node_in_comp:
    #     #     print(node)
    #
    #     return [self.merge_nodes(node_in_comp[node]) for node in node_in_comp]
    #     # return [self.merge_nodes(node_in_comp[comp]) for comp in range(number_of_comps)]


# if __name__ == '__main__':
a = [[1, 3], [2, 6], [8, 10], [15, 18]]
solution = Solution()
print(solution.merge(a))

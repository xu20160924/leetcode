import collections

from pip._vendor.urllib3.connectionpool import xrange


class Solution(object):
    # def accountsMerge(self, accounts):
    #     def find(email, parent):
    #         return email if parent[email] == email else find(parent[email], parent)
    #     owner, parents, unions, res = {}, {}, collections.defaultdict(set), list()
    #     for account in accounts:
    #         for item in account[1:]:
    #             parents[item] = item
    #             owner[item] = account[0]
    #
    #     for account in accounts:
    #         email = find(account[1], parents)
    #         for item in account[2:]:
    #             parents[find(item, parents)] = email
    #
    #     for account in accounts:
    #         email = find(account[1], parents)
    #         if not unions[email]:
    #             unions[email] = set()
    #         for item in account[1:]:
    #             unions[email].add(item)
    #     for account in unions.keys():
    #         emails = sorted(list(unions.get(account)))
    #         emails.insert(0, owner[account])
    #         res.append(emails)
    #
    #     return res


    def accountsMerge(self, accounts):
        parent = {}
        email_to_name = {}

        def find(i):
            if parent[i] != i:
                parent[i] = find(parent[i])
            return parent[i]

        def union(i, j):
            parent[find(i)] = find(j)

        for account in accounts:
            name = account[0]
            for email in account[1:]:
                if email not in parent:
                    parent[email] = email
                email_to_name[email] = name
                union(email, account[1])
        trees = collections.defaultdict(list)
        for email in parent.keys():
            trees[find(email)].append(email)

        return [[email_to_name[root]] + sorted(emails) for (root, emails) in trees.items()]



# class DSU:
#     def __init__(self):
#         self.p = list(range(10001))
#
#     def find(self, x):
#         if self.p[x] != x:
#             self.p[x] = self.find(self.p[x])
#         return self.p[x]
#
#     def union(self, x, y):
#         self.p[self.find(x)] = self.find(y)
#
# class Solution(object):
#     def accountsMerge(self, accounts):
#         dsu = DSU()
#         em_to_name = {}
#         em_to_id = {}
#         i = 0
#         for acc in accounts:
#             name = acc[0]
#             for email in acc[1:]:
#                 em_to_name[email] = name
#                 if email not in em_to_id:
#                     em_to_id[email] = i
#                     i += 1
#                 dsu.union(em_to_id[acc[1]], em_to_id[email])
#
#         ans = collections.defaultdict(list)
#         for email in em_to_name:
#             ans[dsu.find(em_to_id[email])].append(email)
#
#         return [[em_to_name[v[0]]] + sorted(v) for v in ans.values()]



    # def accountsMerge(self, accounts):
    #     em_to_name = {}
    #     graph = collections.defaultdict(set)
    #     for acc in accounts:
    #         name = acc[0]
    #         for email in acc[1:]:
    #             graph[acc[1]].add(email)
    #             graph[email].add(acc[1])
    #             em_to_name[email] = name
    #     seen = set()
    #     ans = []
    #     for email in graph:
    #         if email not in seen:
    #             seen.add(email)
    #             stack = [email]
    #             component = []
    #             while stack:
    #                 node = stack.pop()
    #                 component.append(node)
    #                 for nei in graph[node]:
    #                     if nei not in seen:
    #                         seen.add(nei)
    #                         stack.append(nei)
    #             ans.append([em_to_name[email]] + sorted(component))
    #     return ans

if __name__ == '__main__':
    solution = Solution()
    accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
    print(solution.accountsMerge(accounts))
    # s = [('red', 1), ('blue', 2), ('red', 3), ('blue', 4), ('red', 1), ('blue', 4)]
    # d = collections.defaultdict(set)
    # for k, v in s:
    #     d[k].add(v)
    #
    # print('12')
    # sorted(d.items())
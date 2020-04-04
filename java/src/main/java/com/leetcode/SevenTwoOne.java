package com.leetcode;

import java.nio.file.StandardWatchEventKinds;
import java.util.*;

/**
 * @author: John
 * @date: 2020-02-10 18:59
 * @description: 721
 **/
public class SevenTwoOne {
    class DSU {
        int[] parent;
        public DSU() {
            parent = new int[10001];
            for (int i = 0; i <= 10000; ++i) {
               parent[i] = i;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++) {
                parents.put(find(a.get(i), parents), p);
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) {
               unions.put(p, new TreeSet<>());
            }
            for (int i = 1; i < a.size(); i++) {
                unions.get(p).add(a.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p) {
       return p.get(s) == s ? s : find(p.get(s), p);
    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, Set<String>> g = new HashMap<>();
//        Map<String, String> emailToName = new HashMap<>();
//        buildGraph(g, emailToName, accounts);
//        List<List<String>> res = new ArrayList<>();
//        Set<String> visited = new HashSet<>();
//
//        for (String mail: emailToName.keySet()) {
//            if (visited.add(mail)) {
//                List<String> list = new ArrayList<>();
//                list.add(mail);
//                dfs(g, list, mail, visited);
//                Collections.sort(list);
//                list.add(0, emailToName.get(mail));
//                res.add(list);
//            }
//        }
//        return res;
//    }
//
//    private void buildGraph(Map<String, Set<String>> g, Map<String, String> emailToName, List<List<String>> accounts) {
//        for (List<String> account : accounts) {
//            String name = account.get(0);
//            for (int i = 1; i < account.size(); i++) {
//                String mail = account.get(i);
//                emailToName.put(mail, name);
//                g.putIfAbsent(mail, new HashSet<>());
//                if (i == 1) {
//                    continue;
//                }
//                String prev = account.get(i - 1);
//                g.get(prev).add(mail);
//                g.get(mail).add(prev);
//            }
//        }
//    }
//
//    private void dfs(Map<String, Set<String>> g, List<String> list, String mail, Set<String> visited) {
//        if (g.get(mail) == null || g.size() == 0) {
//            return;
//        }
//        for (String neigh: g.get(mail)) {
//            if (visited.add(neigh)) {
//                list.add(neigh);
//                dfs(g, list, mail, visited);
//            }
//        }
//    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //        DSU dsu = new DSU();
//        Map<String, String> emailToName = new HashMap<>();
//        Map<String, Integer> emailToID = new HashMap<>();
//        int id = 0;
//        for (List<String> account: accounts) {
//            String name = "";
//            for (String email: account) {
//                if (name == "") {
//                    name = email;
//                    continue;
//                }
//                emailToName.put(email, name);
//                if (!emailToID.containsKey(email)) {
//                    emailToID.put(email, id++);
//                }
//                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
//            }
//        }
//
//        Map<Integer, List<String>> ans = new HashMap<>();
//        for (String email: emailToName.keySet()) {
//            int index = dsu.find(emailToID.get(email));
//            ans.computeIfAbsent(index, x-> new ArrayList<>()).add(email);
//        }
//        for (List<String> component: ans.values()) {
//            Collections.sort(component);
//            component.add(0, emailToName.get(component.get(0)));
//        }
//        return new ArrayList<>(ans.values());
//    }

//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//       Map<String, String> emailToName = new HashMap<>();
//       Map<String, ArrayList<String>> graph = new HashMap<>();
//       for (List<String> account : accounts) {
//           String name = "";
//           for (String email : account) {
//               if (name == "") {
//                   name = email;
//                   continue;
//               }
//               graph.computeIfAbsent(email, x-> new ArrayList<>()).add(account.get(1));
//               graph.computeIfAbsent(account.get(1), x-> new ArrayList<>()).add(email);
//               emailToName.put(email, name);
//           }
//       }
//
//       Set<String> seen = new HashSet<>();
//       List<List<String>> ans = new ArrayList<>();
//       for (String email : graph.keySet()) {
//           if (!seen.contains(email)) {
//               seen.add(email);
//               Stack<String> stack = new Stack<>();
//               stack.add(email);
//               List<String> component = new ArrayList<>();
//               while (!stack.isEmpty()) {
//                    String node = stack.pop();
//                    component.add(node);
//                    for (String nei : graph.get(node)) {
//                        if (!seen.contains(nei)) {
//                            seen.add(nei);
//                            stack.add(nei);
//                        }
//                    }
//               }
//               Collections.sort(component);
//               component.add(0, emailToName.get(email));
//               ans.add(component);
//           }
//       }
//        return ans;
//    }





    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnnybravo@mail.com");

        List<String> account3 = new ArrayList<>();
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");

        List<String> account4 = new ArrayList<>();
        account4.add("Mary");
        account4.add("mary@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        SevenTwoOne sevenTwoOne = new SevenTwoOne();
        sevenTwoOne.accountsMerge(accounts);
//        SevenTwoOne.accountsMerge(accounts);

    }
}

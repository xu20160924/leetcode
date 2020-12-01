package com.john;

import java.util.LinkedList;

/**
 * @author: John
 * @date: 2020-02-25 11:04
 * @description: Graph
 **/
public class Graph {
    private int v;
    private LinkedList<Integer> adj[];
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * Kahn
     */
    public void topSortByKahn() {
        int[] inDegree = new int[v];  //统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.println("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(i);
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }

    /**
     * DFS
     */
    public void topoSortByDFS() {
        // 先构建逆邻接表, 边s-> t 表示  s依赖于t   t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // i -> w
                inverseAdj[w].add(i); // w -> i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {   //深度优先遍历图
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }
    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] == true) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }  // 先把vertex 这个顶点可达的所有顶点都打印出来之后， 再打印它自己
        System.out.println("->" + vertex);
    }
}

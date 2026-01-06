//
// Created by John on 2020/2/24.
//

#include "TwoZeroSeven.h"
#include <vector>
#include <list>
#include <deque>
#include <iostream>
#include <queue>
#include <set>

using namespace std;

class Solution{
//public:
//    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
//        vector<vector<int>> graph = buildGraph(numCourses, prerequisites);
//        vector<bool> todo(numCourses, false), done(numCourses, false);
//        for (int i = 0; i < numCourses; i++) {
//            if (!done[i] && !acyclic(graph, todo, done, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//private:
//    vector<vector<int>> buildGraph(int numCourses, vector<vector<int>>& prerequisites) {
//        vector<vector<int>> graph(numCourses);
//        for (auto p : prerequisites) {
//            graph[p[1]].push_back(p[0]);
//        }
//        return graph;
//    }
//
//    bool acyclic(vector<vector<int>>& graph, vector<bool>& todo, vector<bool>& done, int node) {
//        if (todo[node]) {
//            return false;
//        }
//        if (done[node]) {
//            return true;
//        }
//        todo[node] = done[node] = true;
//        for (int v : graph[node]) {
//            if (!acyclic(graph, todo, done, v)) {
//                return false;
//            }
//        }
//        todo[node] = false;
//        return true;
//    }

// topological sort
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> adj(numCourses, vector<int>());
        vector<int> degree(numCourses, 0);
        for (auto p : prerequisites) {
            degree[p[0]]++;
            adj[p[1]].push_back(p[0]);
        }

        queue<int> queue;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.push(i);
            }
        }

        while (!queue.empty()) {
            int top = queue.front();
            queue.pop();
            for (int next : adj[top]) {
                numCourses--;
                if (--degree[next] == 0) {
                    queue.push(next);
                }
            }
        }
        return numCourses == 0;
    }
//
//        while (!queue.empty()) {
//            int top = queue.front();
//            queue.pop_front();
//            for (int next : graph[top]) {
//                if (find(queue.begin(), queue.end(),next) != queue.end()) {
//                    return false;
//                }
//                indegree[next]--;
//                if (indegree[next] == 0) {
//                    queue.push_back(next);
//                }
//            }
//        }
//        return true;




//public:
//    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
//        vector<vector<int> > graph = buildGraph(numCourses, prerequisites);
//        vector<int> degree = computeIndegrees(graph);
//        for (int i = 0; i < numCourses; i++) {
//            int j = 0;
//            for (; j < numCourses; j++) {
//                if (!degree[j]) {
//                    break;
//                }
//            }
//            if (j == numCourses) {
//                return false;
//            }
//            degree[j]--;
//            for (auto v : graph[j]) {
//                degree[v]--;
//            }
//        }
//        return true;
//    }
//
//private:
//    vector<vector<int>> graph;
//    vector<vector<int>> buildGraph(int numCourses, vector<vector<int>>& prerequisite) {
//        vector<vector<int>> graph(numCourses);
//        for (auto p : prerequisite) {
//            graph[p[1]].push_back(p[0]);
//        }
//        return graph;
//    }
//
//    vector<int> computeIndegrees(vector<vector<int> > graph) {
//        vector<int> degree(graph.size(), 0);
//        for (auto g : graph) {
//            for (int v : g) {
//                degree[v]++;
//            }
//        }
//        return degree;
//    }


//public:
//    bool canFinish(int numCourses, vector<pair<int, int> > & prerequisite) {
//        graph g = buildGraph(numCourses, prerequisite);
//        vector<int> degrees = computeIndegrees(g);
//        for (int i = 0; i < numCourses; i++) {
//            int j = 0;
//            for (; j < numCourses; j++) {
//                if (!degrees[j]) {
//                    break;
//                }
//            }
//            if (j == numCourses) {
//                return false;
//            }
////            degrees[j]--;
////            for (int v : g[j]) {
////                degrees[v]--;
////            }
//        }
//        return true;
//    }
//
//private:
//    typedef vector<vector<int> > graph;
//    graph buildGraph(int numCourses, vector<pair<int, int> > & prerequisite) {
//        graph g(numCourses);
//        for (auto p : prerequisite) {
//            g[p.second].push_back(p.first);
//        }
//        return g;
//    }
//
//    vector<int> computeIndegrees(graph & g) {
//        vector<int> degrees(g.size(), 0);
//        for (auto adj : g) {
//            for (int v: adj) {
//                degrees[v]++;
//            }
//        }
//        return degrees;
//    }

//public:
//    bool canFinish(int numCourses, vector<vector<int> > & prerequisites) {
//        vector<int> indegrees(numCourses);
//        for (vector<int> cp : prerequisites) {
//            indegrees[cp[0]]++;
//        }
//        deque<int> deque;
//        for (int i = 0; i < numCourses; i++) {
//            if (indegrees[i] == 0) {
//                deque.push_back(i);
//            }
//        }
//        while (!deque.empty()) {
//            int pre = deque.front();
//            deque.pop_front();
//            numCourses--;
//            for (vector<int> req : prerequisites) {
//                if (req[1] != pre) {
//                    continue;
//                }
//                if (--indegrees[req[0]] == 0) {
//                    deque.push_back(req[0]);
//                }
//            }
//        }
//        return numCourses == 0;
//    }



// dfs
//public:
//    bool canFinish(int numCourses, vector<vector<int>> & prerequisites) {
//        graph = vector<vector<int>> (numCourses);
//        for (const auto p : prerequisites) {
//            graph[p[0]].push_back(p[1]);
//        }
//        // states 0 = unknown 1 == visiting 2 == visited
//        vector<int> v(numCourses, 0);
//        for (int i = 0; i < numCourses; ++i) {
//            if (dfs(i, v)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//private:
//    vector<vector<int>> graph;
//    bool dfs(int cur, vector<int> & v) {
//        if (v[cur] == 1) {
//            return false;
//        }
//        if (v[cur] == 2) {
//            return false;
//        }
//        v[cur] = 1;
//        for (const int t: graph[cur]) {
//            if (dfs(t, v)) {
//                return true;
//            }
//        }
//        v[cur] = 2;
//        return false;
//    }

// bfs
//public:
//    bool canFinish(int n, vector<vector<int>> & prerequisites) {
//        vector<vector<int>> adj(n, vector<int> ());
//        vector<int> degree(n, 0);
//        for (auto &p : prerequisites) {
//            adj[p[1]].push_back(p[0]);
//            degree[p[0]]++;
//        }
//        queue<int> queue;
//        for (int i = 0; i < n; i++) {
//            if (degree[i] == 0) {
//                queue.push(i);
//            }
//        }
//        while (!queue.empty()) {
//            int curr = queue.front(); queue.pop(); n--;
//            for (auto next : adj[curr]) {
//                if (--degree[next] == 0) {
//                    queue.push(next);
//                }
//            }
//        }
//        return n == 0;
//    }
};



int main() {
    vector<vector<int>> courses;
    vector<int> course1, course2, course3, course4, course5, course6, course7, course8;

    course1.push_back(0);
    course1.push_back(10);

    course2.push_back(3);
    course2.push_back(18);

    course3.push_back(5);
    course3.push_back(5);

    course4.push_back(6);
    course4.push_back(11);

    course5.push_back(11);
    course5.push_back(14);

    course6.push_back(13);
    course6.push_back(11);

    course7.push_back(15);
    course7.push_back(1);

    course8.push_back(17);
    course8.push_back(4);

    courses.push_back(course1);
    courses.push_back(course2);
    courses.push_back(course3);
    courses.push_back(course4);
    courses.push_back(course5);
    courses.push_back(course6);
    courses.push_back(course7);
    courses.push_back(course8);




//    course1.push_back(1);
//    course1.push_back(0);
//
//    course2.push_back(0);
//    course2.push_back(1);
//    courses.push_back(course1);
//    courses.push_back(course2);

    Solution * solution = new Solution();
    cout << solution->canFinish(20, courses) << endl;
}
//
// Created by John on 2020/2/24.
//

#include "TwoZeroSeven.h"
#include <vector>
#include <list>
#include <deque>
#include <iostream>
#include "queue"

using namespace std;

class Solution{
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


// bfs
public:
    bool canFinish(int numCourses, vector<vector<int> > & prerequisites) {
        graph g = buildGraph(numCourses, prerequisites);
        vector<int> degrees  = computeIndegress(g);
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++) {
                if (!degrees[j]) {
                    break;
                }
            }
            if (j == numCourses) {
                return false;
            }
            degrees[j]--;
            for (int v : g[j]) {
                degrees[v]--;
            }
        }
        return true;
    }

private:
    typedef vector<vector<int> > graph;
    graph buildGraph(int numCourses, vector<vector<int> > & prerequisites) {
        graph g(numCourses);
        for (auto p : prerequisites) {
            g[p[1]].push_back(p[0]);
        }
        return g;
    }

    vector<int> computeIndegress(graph & g) {
        vector<int> degrees(g.size(), 0);
        for (auto adj : g) {
            for (int v : adj) {
                degrees[v]++;
            }
        }
        return degrees;
    }


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

//dfs
//public:
//    bool canFinish(int numCourses, vector<vector<int>> & prerequisites) {
//        graph g = buildGraph(numCourses, prerequisites);
//        vector<bool> todo (numCourses, false), done(numCourses, false);
//        for (int i = 0; i < numCourses; ++i) {
//            if (!done[i] && !acyclic(g, todo, done, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//private:
//    typedef vector<vector<int>> graph;
//    graph buildGraph(int numCourses, vector<vector<int>> & prerequisites) {
//        graph g(numCourses);
//        for (auto p : prerequisites) {
//            g[p[1]].push_back(p[0]);
//        }
//        return g;
//    }
//    bool acyclic(graph & g, vector<bool> & todo, vector<bool> done, int node) {
//        if (todo[node]) {
//            return false;
//        }
//        if (done[node]) {
//            return true;
//        }
//        todo[node] = done[node] = true;
//        for (int v: g[node]) {
//            if (!acyclic(g, todo, done, v)) {
//                return false;
//            }
//        }
//        todo[node] = false;
//        return true;
//    }

//public:
//    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
//        graph g = buildGraph(numCourses, prerequisites);
//        vector<bool> todo(numCourses, false), done(numCourses, false);
//        for (int i = 0; i < numCourses; i++) {
//            if (!done[i] && !acyclic(g, todo, done, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//private:
//    typedef vector<vector<int>> graph;
//    graph buildGraph(int numCourses, vector<vector<int>> prerequisites) {
//        graph g(numCourses);
//        for (auto p : prerequisites) {
//            g[p[1]].push_back(p[0]);
//        }
//        return g;
//    }
//
//    bool acyclic(graph & g, vector<bool> & todo, vector<bool> & done, int node) {
//        if (todo[node]) {
//            return false;
//        }
//        if (done[node]) {
//            return true;
//        }
//        todo[node] = done[node] = true;
//        for (int v : g[node]) {
//            if (!acyclic(g, todo, done, v)) {
//                return false;
//            }
//        }
//        todo[node] = false;
//        return true;
//    }
};



//int main() {
//    vector<vector<int>> courses;
//    vector<int> course1, course2, course3, course4, course5, course6, course7, course8;
//    course1.push_back(5);
//    course1.push_back(8);
//
//    course2.push_back(3);
//    course2.push_back(5);
//
//    course3.push_back(1);
//    course3.push_back(9);
//
//    course4.push_back(4);
//    course4.push_back(5);
//
//    course5.push_back(0);
//    course5.push_back(2);
//
//    course6.push_back(1);
//    course6.push_back(9);
//
//    course7.push_back(7);
//    course7.push_back(8);
//
//    course8.push_back(4);
//    course8.push_back(9);
//
//
//
//
////    course2.push_back(0);
////    course2.push_back(1);
////    pair<int, int> course1, course2, course3;
////    course1.first = 1;
////    course1.second = 0;
////    course2.first = 1;
////    course2.second = 2;
////    course3.first = 0;
////    course3.second = 1;
//
//    courses.push_back(course1);
//    courses.push_back(course2);
//    courses.push_back(course3);
//    courses.push_back(course4);
//    courses.push_back(course5);
//    courses.push_back(course6);
//    courses.push_back(course7);
//    courses.push_back(course8);
////    courses.push_back(course2);
//
////    pair<int, int> pair1, pair2;
////    pair1.first = 1;
////    pair1.second = 0;
////
////    pair2.first = 0;
////    pair2.second = 1;
////    course.push_back(pair1);
////    course.push_back(pair2);
//    Solution * solution = new Solution();
//    cout << solution->canFinish(10, courses) << endl;
//}
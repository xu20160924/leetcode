//
// Created by John on 2020/2/25.
//

#include "TwoOneZero.h"
#include <vector>
#include <deque>
#include <iostream>
#include "queue"

using namespace std;

class Solution {
//public:
//    vector<int> findOrder(int numCourses, vector<vector<int> > & prerequisites) {
//        vector<int> indegrees(numCourses), res;
//        if (prerequisites.empty()) {
//            for (int i = numCourses; i > 0; i--) {
//               res.push_back(i - 1);
//            }
//            return res;
//        }
//        for (vector<int> v : prerequisites) {
//            indegrees[v[0]]++;
//        }
//        deque<int> deque;
//        for (int i = 0; i < numCourses; i++) {
//            if (indegrees[i] == 0) {
//                deque.push_back(i);
//                res.push_back(indegrees[i]);
//            }
//        }
//        while (!deque.empty() && numCourses >= 0) {
//            numCourses--;
//            int pre = deque.front();
//            deque.pop_front();
//            for (vector<int> v : prerequisites) {
//                if (v[1] != pre) {
//                    continue;
//                }
//                if (--indegrees[v[0]] == pre) {
//                    deque.push_back(v[0]);
//                    res.push_back(v[0]);
//                }
//            }
//        }
//        return res;
//    }

//public:
//    vector<int> findOrder(int numCourses, vector<vector<int> > & prerequisites) {
//        vector<vector<int> > radjs(numCourses);
//        for (vector<int> v : prerequisites) {
//            radjs[v[1]].push_back(v[0]);
//        }
//
//        vector<int> order;
//        vector<bool> todo(numCourses, false), done(numCourses, false);
//        for (int i = 0; i < numCourses; i++) {
//            if (!done[i] && !acyclic(radjs, todo, done, i, order)) {
//                return vector<int> ();
//            }
//        }
//        reverse(order.begin(), order.end());
//        return order;
//    }
//    bool acyclic(vector<vector<int> > & adjs,  vector<bool> & todo, vector<bool> & done,  int node, vector<int> & order) {
//        if (todo[node]) {
//            return false;
//        }
//        if (done[node]) {
//            return true;
//        }
//        todo[node] = done[node] = true;
//        for (int neigh : adjs[node]) {
//            if (!acyclic(adjs, todo, done, neigh, order)) {
//                return false;
//            }
//        }
//        order.push_back(node);
//        todo[node] = false;
//        return true;
//    }


//public:
//    vector<int> findOrder(int numCourses, vector<pair<int, int> > & prerequisites) {
//        graph g = buildGraph(numCourses, prerequisites);
//        vector<int> order;
//        vector<bool> todo(numCourses, false), done(numCourses, false);
//        for (int i = 0; i < numCourses; i++) {
//            if (!done[i] && !acyclic(g, todo, done, i, order)) {
//                return vector<int> ();
//            }
//        }
//        reverse(order.begin(), order.end());
//        return order;
//    }
//
//private:
//    typedef vector<vector<int> > graph;
//    graph buildGraph(int numCourses, vector<pair<int, int> > & prerequisites ) {
//        graph g(numCourses);
//        for (auto p : prerequisites) {
//            g[p.second].push_back(p.first);
//        }
//        return g;
//    }
//    bool acyclic(graph & g, vector<bool> & todo, vector<bool> & done, int node, vector<int> & order) {
//        if (todo[node]) {
//            return false;
//        }
//        if (done[node]) {
//            return true;
//        }
//        todo[node] = done[node] = true;
//        for (int neigh : g[node]) {
//            if (!acyclic(g, todo, done, neigh, order)) {
//                return false;
//            }
//        }
//        order.push_back(node);
//        todo[node] = false;
//        return true;
//    }



//private:
//    typedef  vector<vector<int> > graph;
//    graph buildGraph(int numCourses, vector<>) {
//
//    }

//
//    bool canFinish(int n, vector<pair<int, int> >& pre) {
//        vector<vector<int> > adj(n, vector<int>());
//        vector<int> degree(n, 0);
//        for (auto &p: pre) {
//            adj[p.second].push_back(p.first);
//            degree[p.first]++;
//        }
//        queue<int> q;
//        for (int i = 0; i < n; i++)
//            if (degree[i] == 0) q.push(i);
//        while (!q.empty()) {
//            int curr = q.front(); q.pop(); n--;
//            for (auto next: adj[curr])
//                if (--degree[next] == 0) q.push(next);
//        }
//        return n == 0;
//    }
//
//
//public:
//    vector<int> canFinish(int n, vector<vector<int> > & pre) {
//        vector<vector<int> > adjs(n, vector<int>());
//        vector<int> degree(n, 0);
//        for(auto p : pre) {
//            adjs[p[1]].push_back(p[0]);
//            degree[p[1]]++;
//        }
//        queue<int> q;
//        for(int i = 0; i < n; i++) {
//            if(degree[i] == 0) {
//                q.push(i);
//            }
//        }
//        vector<int> order(n, 0);
//        int i = 0;
//        while(!q.empty()) {
//            int curr = q.front(); q.pop();
//            order[i++] = curr;
//            if(!adjs[curr].empty()) {
//                for (int neighbor : adjs[curr]) {
//                    degree[neighbor]--;
//
//                    if(degree[neighbor] == 0) {
//                        q.push(neighbor);
//                    }
//                }
//            }
//        }
//        if(i == n) {
//            return order;
//        }
//        return vector<int>();
//    }
//public:
//    vector<int> findOrder(int numCourses, vector<vector<int>> &prerequisites) {
//        graph g = buildGraph(numCourses, prerequisites);
//        vector<int> degrees = computeIndegrees(g);
//        vector<int> order;
//        for (int i = 0; i < numCourses; i++) {
//            int j = 0;
//            for (; j < numCourses; ++j) {
//                if (!degrees[j]) {
//                    order.push_back(j);
//                    break;
//                }
//            }
//            if (j == numCourses) {
//                return {};
//            }
//            degrees[j]--;
//            for (int v : g[j]) {
//                degrees[v]--;
//            }
//        }
//        return order;
//    }
//
//private:
//    typedef vector<vector<int>> graph;
//
//    graph buildGraph(int numCourses, vector<vector<int>> &prerequisites) {
//        graph g(numCourses);
//        for (auto p : prerequisites) {
//            g[p[1]].push_back(p[0]);
//        }
//        return g;
//    }
//
//    vector<int> computeIndegrees(graph & g) {
//        vector<int> degrees(g.size(), 0);
//        for (auto adj : g) {
//            for (int v : adj) {
//                degrees[v]++;
//            }
//        }
//        return degrees;
//    }
};
//int main() {
//    vector<vector<int> > courses;
//    vector<int> course1, course2, course3, course4;
////    course1.push_back(1);
////    course1.push_back(0);
////
////    course2.push_back(2);
////    course2.push_back(0);
////
////    course3.push_back(3);
////    course3.push_back(1);
////
////    course4.push_back(3);
////    course4.push_back(2);
////
////    courses.push_back(course1);
////    courses.push_back(course2);
////    courses.push_back(course3);
////    courses.push_back(course4);
//    course1.push_back(1);
//    course1.push_back(0);
//
//    courses.push_back(course1);
//
//
//    vector<pair<int, int> > coursesPair;
//    pair<int, int > pair1, pair2;
//    pair1.first = 1;
//    pair1.second = 0;
//    coursesPair.push_back(pair1);
//
//    Solution * solution = new Solution();
//    solution->canFinish(2, courses);
//}
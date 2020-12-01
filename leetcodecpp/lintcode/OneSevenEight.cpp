////
//// Created by John on 2020/3/26.
////
//
//#include "vector"
//#include "unordered_map"
//#include "unordered_set"
//#include "queue"
//
//
//using namespace std;
//
//class Solution{
//public:
//    bool validTree(int n, vector<vector<int> > & edges) {
//        if (edges.size() != n - 1) {
//            return false;
//        }
//        // convert adjecent list graph
//        unordered_map<int, unordered_set<int>> Graph_In  {toGraph(n, edges)};
//        // record connected vertex
//        unordered_set<int> recorded_node;
//        // iterator
//        unordered_map<int, unordered_set<int>>::const_iterator  it;
//
//        // queue
//        queue<int> current_levelNode;
//        current_levelNode.push(0);
//        while (!current_levelNode.empty()) {
//            int current_vertex {current_levelNode.front()};
//            current_levelNode.pop();
//
//            if (recorded_node.find(current_vertex) == recorded_node.end()) {
//                recorded_node.emplace(current_vertex);
//            }
//            it = Graph_In.find(current_vertex);
//            for (auto &i : it->second) {
//                if (recorded_node.find(i) == recorded_node.end()) {
//                    recorded_node.emplace(i);
//                    current_levelNode.push(i);
//                }
//            }
//        }
//        if (recorded_node.size() == n) {
//            return true;
//        }
//        return false;
//    }
//
//private:
//    unordered_map<int, unordered_set<int>> toGraph(int n, vector<vector<int> > & edges) {
//        unordered_map<int, unordered_set<int>> result_graph;
//        for (int i = 0; i < n; i++) {
//            unordered_set<int> current_vertex_connection;
//            for (int j = 0; j < edges.size(); j++) {
//                if (edges[j][0] == i) {
//                    current_vertex_connection.emplace(edges[j][1]);
//                } else if(edges[j][1] == i) {
//                    current_vertex_connection.emplace(edges[j][0]);
//                }
//            }
//            result_graph.emplace(i, current_exception());
//        }
//        return result_graph;
//    }
//};
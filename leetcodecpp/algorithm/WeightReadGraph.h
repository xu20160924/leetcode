//
// Created by John on 2020/2/27.
//

#ifndef UNTITLED_WEIGHTREADGRAPH_H
#define UNTITLED_WEIGHTREADGRAPH_H

#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <assert.h>

using namespace std;

template <typename  Graph, typename Weight>
class WeightReadGraph{
public:
    WeightReadGraph(Graph & graph, const string & filename) {
        ifstream file(filename);
        string line;
        int V, E;
        assert(file.is_open());
        assert(getline(file, line));
        stringstream ss(line);
        ss>>V>>E;
        assert(graph.V() == V);
        for (int i = 0; i < E; i ++) {
            assert(getline(file, line));
            stringstream ss(line);
            int a, b;
            Weight w;
            ss>>a>>b>>w;
            assert(a >= 0 && a < V);
            assert(b >= 0 && b < V);
            graph.addEdge(a, b, w);
        }
    }
};



#endif //UNTITLED_WEIGHTREADGRAPH_H

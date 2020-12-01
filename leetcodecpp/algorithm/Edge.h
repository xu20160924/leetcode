//
// Created by John on 2020/2/27.
//

#ifndef UNTITLED_EDGE_H
#define UNTITLED_EDGE_H

#include <cassert>
#include <ostream>


using namespace std;

template <typename Weight>
class Edge{
    int a, b;
    Weight weight;
public:
    Edge(int a, int b, Weight weight) {
        this->a = a;
        this->b = b;
        this->weight = weight;
    }

    Edge() {

    }
    ~Edge() {

    }

    int v() {
        return a;
    }
    int w() {
        return b;
    }
    Weight wt() {
        return weight;
    }
    int other(int x) {
        assert(x == a || x == b);
        return x == a ?  b : a;
    }
    friend ostream& operator << (ostream &os, const Edge &e) {
        os<< e.a << "-"<<e.b<<" : " << e.weight;
        return os;
    }
    bool operator<(Edge<Weight> & e) {
        return weight < e.wt();
    }
    bool operator<=(Edge<Weight> & e) {
        return weight <= e.wt();
    }
    bool operator>(Edge<Weight> & e) {
        return weight > e.wt();
    }
    bool operator>=(Edge<Weight> & e) {
        return weight >= e.wt();
    }
    bool operator==(Edge<Weight> & e) {
        return weight == e.wt();
    }
};

#endif //UNTITLED_EDGE_H

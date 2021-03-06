//
// Created by John on 2020/2/27.
//

#ifndef UNTITLED_LAZYPRIMMST_H
#define UNTITLED_LAZYPRIMMST_H

#include "Edge.h"
#include "MinHeap.h"

template <typename  Graph, typename Weight>
class LazyPrimeMST{
private:
    Graph &G;
    MinHeap<Edge<Weight> > pq;
    bool * marked;
    vector<Edge<Weight> > mst;
    Weight mstWeight;

    void visit(int v) {
        assert(!marked[v]);
        marked[v] = true;
        typename Graph::adjIterator adj(G, v);
        for(Edge<Weight> *e = adj.begin(); !adj.end(); e = adj.next()) {
            if(!marked[e->other(v)]) {
                pq.insert(*e);
            }
        }
    }

public:
    LazyPrimeMST(Graph &graph): G(graph), pq(MinHeap<Edge<Weight> >(graph.E())) {
        marked = new bool[G.V()];
        for(int i = 0; i < G.V(); i++) {
            marked[i] = false;
        }
        mst.clear();

        //lazy prim
        visit(0);
        while(!pq.isEmpty()) {
            Edge<Weight> e = pq.extractMin();
            if(marked[e.v()] == marked[e.w()]) { // if not corssing edge
                continue;
            }
            mst.push_back(e);
            if(!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }
        mstWeight = mst[0].wt();
        for(int i = 1; i < mst.size(); i++) {
            mstWeight += mst[i].wt();
        }
    }
    ~LazyPrimeMST() {
        delete[] marked;
    }
    Weight result() {
        return mstWeight;
    }
    vector<Edge<Weight> > mstEdges() {
        return mst;
    }

};

#endif //UNTITLED_LAZYPRIMMST_H

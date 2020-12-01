//
// Created by John on 2020/2/26.
//

#include <sys/time.h>
#include <cstdlib>
#include <iostream>
#include <iomanip>
#include "main.h"
#include "Component.h"
#include "Path.h"
#include "ShortestPath.h"
#include "WeightDenseGraph.h"
#include "WeightReadGraph.h"
#include "WeightSparseGraph.h"
#include "LazyPrimMST.h"


using namespace std;
//int main() {
////    int N = 20;
////    int M = 100;
////    srand(time(NULL));
////
////    // Sparse Graph
////    SparseGraph g1(N, false);
////    for (int i = 0; i < M; i++) {
////        int a = rand() % N;
////        int b = rand() % N;
////        g1.addEdge(a, b);
////    }
////    // time complexity O(E)
////    for (int v = 0; v < N; v++) {
////        cout << v << " : ";
////        SparseGraph::adjIterator adj(g1, v);
////        for (int w = adj.begin(); !adj.end(); w = adj.next()) {
////            cout << w << " ";
////        }
////        cout << endl;
////    }
////    cout << endl;
////
////    // Dense Graph
////    DenseGraph g2(N, false);
////    for (int i = 0; i < M; i++) {
////        int a = rand() % N;
////        int b = rand() % N;
////        g2.addEdge(a, b);
////    }
////    // time complexity O(V^2)
////    for (int v = 0; v < N; v++) {
////        cout << v << " : ";
////        DenseGraph::adjIterator adj(g2, v);
////        for (int w = adj.begin(); !adj.end(); adj.next()) {
////            cout << w << " ";
////        }
////        cout << endl;
////    }
////    return 0;
//
////    string filename = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/testG1.txt";
////    string filename = "../testG1.txt";
////    SparseGraph g1(13, false);
////    ReadGraph<SparseGraph> readGraph1(g1, filename);
////    g1.show();
////
////    cout<<endl;
////
////    DenseGraph g2(13, false);
////    ReadGraph<DenseGraph> readGraph2(g2, filename);
////    g2.show();
//
////    string filename1 = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/testG1.txt";
////    SparseGraph g1 = SparseGraph(13, false);
////    ReadGraph<SparseGraph> readGraph1(g1, filename1);
////    Component<SparseGraph> component1(g1);
////    cout<<"TestG1.txt, Component Count: " << component1.count() << endl;
////    cout<< endl;
////
////    string filename2 = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/testG2.txt";
////    SparseGraph g2 = SparseGraph(7, false);
////    ReadGraph<SparseGraph> readGraph2(g2, filename2);
////    Component<SparseGraph> component2(g2);
////    cout<<"TestG2.txt, Component Count: " << component2.count() << endl;
//
////    string filename2 = "/Users/johnMacBookPro/CLionProjects/untitlWeightDenseGraphed/algorithm/testG2.txt";
////    SparseGraph g = SparseGraph(7, false);
////    ReadGraph<SparseGraph> readGraph(g, filename2);
////    g.show();
////    cout<<endl;
////
////    Path<SparseGraph> dfs(g, 0);
////    cout<<"DFS : ";
////    dfs.showPath(6);
//
////    string filename2 = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/testG2.txt";
////    SparseGraph g = SparseGraph(7, false);
////    ReadGraph<SparseGraph> readGraph(g, filename2);
////    g.show();
////    cout << endl;
////
////    Path<SparseGraph> dfs(g, 0);
////    cout<< "DFS : ";
////    dfs.showPath(6);
////
////    ShortestPath<SparseGraph> bfs(g, 0);
////    cout<<"BFS : ";
////    bfs.showPath(6);
//
//
////    string filename1 = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/WeightTestG1.txt";
////    int V = 8;
////    cout<< fixed << setprecision(2);
////
////    // Test weighted desnse graph
////    WeightDenseGraph<double> g1 = WeightDenseGraph<double>(V, false);
////    WeightReadGraph<WeightDenseGraph<double>, double> readGraph1(g1, filename1);
////    g1.show();
////    cout<<endl;
////
////    WeightSparseGraph<double> g2 = WeightSparseGraph<double>(V, false);
////    WeightReadGraph<WeightSparseGraph<double>, double> readGraph2(g2, filename1);
////    g2.show();
////
////    cout<<endl;
//
//
//    string filename1 = "/Users/johnMacBookPro/CLionProjects/untitled/algorithm/WeightTestG1.txt";
//    int V = 8;
//    WeightSparseGraph<double> g = WeightSparseGraph<double>(V, false);
//    WeightReadGraph<WeightSparseGraph<double>, double> readGraph(g, filename1);
//    cout<< "Test Lazy Prim MST:" << endl;
////    LazyPrimMST<WeightSparseGraph<double>, double > lazyPrimMst(g);
//    LazyPrimeMST<WeightSparseGraph<double>, double> lazyPrimeMst(g);
//    vector<Edge<double> > mst = lazyPrimeMst.mstEdges();
//    for(int i = 0; i < mst.size(); i++) {
//        cout<<mst[i]<<endl;
//    }
//    cout<<"The MST weight is: " << lazyPrimeMst.result() << endl;
//    cout<<endl;
//
//    return 0;
//}
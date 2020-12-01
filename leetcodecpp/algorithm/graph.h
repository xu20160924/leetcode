//
// Created by John on 2020/2/8.
//

#ifndef UNTITLED_GRAPH_H
#define UNTITLED_GRAPH_H
#define MaxInt 32767 //表示极大值, 即∞
#define MVNum 100  //最大顶点数
typedef char VerTexType;  //设顶点的数据类型为字符型
typedef int ArcType;  //假设边的权值类型为整型

typedef struct {
    VerTexType vexs[MVNum];  //顶点表
    ArcType arcs[MVNum][MVNum];  //邻接矩阵
    int vexnum, arcnum;  //图的当前点数和变数
}AMGraph;  // Adjacency Matrix Graph

typedef struct ArcNode {
    int adjvex;  // 该边所指向的顶点的位置
    struct ArcNode * nextarc;   //指向下一条边的指针
    OtherInfo info;     //和边相关的信息
}ArcNode;

typedef struct VNode{
    VerTexType data; // 顶点信息
    ArcNode *firstarc; // 指向第一条依附在顶点的边的指针
}VNode, AdjList[MVNum]; //AdjList表示邻接表类型

typedef struct {
    AdjList  vertices; // vertices--vertex的复数
    int vexnum, arcnum;  //图的当前定点数和弧数
}ALGraph;


class graph {

};




#endif //UNTITLED_GRAPH_H

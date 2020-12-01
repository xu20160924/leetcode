////
//// Created by John on 2020/2/8.
////
//
//#include "graph.h"
//#include "iostream"
//
//using namespace std;
//
//int locateVex(AMGraph G, VerTexType u) {
//    // 图G中查找顶点u, 存在则返回顶点表中的下标；否则返回-1
//    int i;
//    for(i = 0; i < G.vexnum; ++i) {
//        if(u==G.vexs[i]) {
//            return i;
//        }
//        return -1;
//    }
//}
//
//int CreateUDN(AMGraph &G) {
//
//    int i, j, k, w;
//    // 采用邻接矩阵表示法，创建无向网G
//    cin >> G.vexnum >> G.arcnum; // 输入总顶点数，总边数
//    for(i = 0; i < G.vexnum; ++i) {
//        cin >> G.vexs[i];   // 依次输入点的信息
//    }
//    for(i = 0; i < G.vexnum; ++i) {  //初始化邻接矩阵
//        for(int j = 0; j < G.vexnum; ++j) {
//            G.arcs[i][j] = MaxInt;  //边的权值均置为极大值
//        }
//    }
//    for(int k = 0; k<G.arcnum; ++k) { // 构造邻接矩阵
//        cin >> v1 >> v2 >> w; // 输入一条边所依附的顶点及边的权值
//        i = locateVex(G, v1);
//        j = locateVex(G, v2);   //确定v1和v2在G中的位置
//        G.arcs[i][j] = w;   // 边<v1,v2>的权值置为w
//        G.arcs[j][i] = G.arcs[i][j];    //置<v1,v2>的对称边<v2, v1>的权值为w
//    }
////    return OK;
//}
//
//int CreateUDG(ALGraph &G){  //采用邻接表表示法，创建无向图G
//    cin >> G.vexnum >> G.arcnum;    //输入总顶点数，总边数
//    for(int i = 0; i < G.vexnum; ++i) { //输入各点，构造表头结点表
//        cin >> G.vertices[i].data;  // 输入顶点值
//        G.vertices[i].firstarc = NULL;  //初始化表头结点的指针域
//    }
//    for(int k = 0; k < G.arcnum; ++k) {  //输入各边，构造邻接表
//        cin >> v1 >> v2;    //输入一条边依附的两个顶点
//        j = locateVex(G, v1);
//        j = locateVex(G, v2);
//        ArcNode *p1 = new ArcNode;   // 生成一个新的边结点 * p1
//        p1->adjvex = j; //邻接点序号为j
//        p1->nextarc = G.vertices[i].firstarc;
//        G.vertices[i].firstarc = p1;  //将新结点*p1插入顶点vi的边表头部
//        //有向图不做以下操作 //只做下面则是逆邻接表
//        ArcNode *p2 = new ArcNode;  //生成另一个对称的新的边界点 p2
//        p2->adjvex = i; //邻接点序号为i
//        p2->nextarc = G.vertices[j].firstarc;
//        G.vertices[j].firstarc = p2; //将新结点*p2插入顶点vj的边表头部
//    }
//}
//
////采用邻接矩阵表示图的深度优先搜索遍历
//void DFS(AMGraph G, int v) {    //图G为邻接矩阵类型
//    cout << v; visited[v] = true; //访问第v个顶点
//    for (int w = 0; w < G.vexnum; w++) {    //依次检查邻接矩阵v所在的行
//        if((G.arcs[v][w]!=0) && (!visited[w]))
//            DFS(G, w);
//    }   // w是v的邻接点，如果w未访问，则递归调用dfs
//}
//
//void BFS(Graph G, int v) { //按广度优先非递归遍历连通图G
//    cout << v; visited[v] = true; // 访问第v个顶点
//    InitQueue(Q);   //辅助队列Q初始化，置空
//    EnQueue(Q);  // v进队
//    while(!QueueEmpty(Q)) { //队列非空
//        DeQueue(Q, u);  //队列元素出队并置为u
//        for(w = FirstAdjVex(G, u); w >= 0; w = NextAdjVex(G, u, w)) {
//            if(!visited[w]) {   //w为u的尚未访问的邻接顶点
//                cout << w; visited[w] = true;
//                EnQueue(Q, w);  //w进队
//            }
//        }
//    }
//}
